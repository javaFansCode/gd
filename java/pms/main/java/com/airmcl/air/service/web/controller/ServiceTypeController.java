package com.airmcl.air.service.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.ServiceType;
import com.airmcl.air.service.entity.ServiceTypeEquipment;
import com.airmcl.air.service.entity.ServiceTypeEquipmentVo;
import com.airmcl.air.service.entity.ServiceTypeExample;
import com.airmcl.air.service.entity.ServiceTypeJSON;
import com.airmcl.air.service.service.ServiceTypeEquipmentService;
import com.airmcl.air.service.service.ServiceTypeService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="门店类型信息表")
@Controller
@RequestMapping("serviceType")
public class ServiceTypeController {
    @Resource
    protected ServiceTypeService serviceTypeService;
    @Resource
    protected ServiceTypeEquipmentService serviceTypeEquipmentService;

    @ApiOperation(httpMethod="POST", value="设置服务类型和设备关联")
    @RequestMapping(method = RequestMethod.POST, value = "service/toEditServiceTypeEquipment",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> updateOrSaveEditServiceTypeEquipment(@RequestBody List<ServiceTypeEquipment> serviceTypeEquipments){
    	if(serviceTypeEquipments==null||serviceTypeEquipments.size()==0){
    		throw new CommonException("传入的数据错误！");
    	}
    	ServiceTypeEquipment serviceTypeEquipment = serviceTypeEquipments.get(0);
    	Integer serviceTypeId = serviceTypeEquipment.getServiceType();
    	List<ServiceTypeEquipment> dbResults = serviceTypeEquipmentService.queryServiceTypeEquipmentsByServiceTypeId(serviceTypeId);
    	//新增
    	if(dbResults==null||dbResults.size()==0){
    		try {
				serviceTypeEquipmentService.updateServiceTypeEquipments(serviceTypeEquipments,null);
			} catch (Exception e) {
				throw new CommonException("新增出错");
			}
        //修改		
    	}else{
    		Map<String,ServiceTypeEquipment> newMap = createDataMap(serviceTypeEquipments);
    		Map<String,ServiceTypeEquipment> oldMap = createDataMap(dbResults);
    		
    		Map<String,ServiceTypeEquipment> sameMap = new HashMap<String, ServiceTypeEquipment>();
    		for(Map.Entry<String, ServiceTypeEquipment> resust : oldMap.entrySet()){
      		   if(newMap.containsKey(resust.getKey())){
      			   sameMap.put(resust.getKey(), resust.getValue());
      		   }
      	     }
    		if(sameMap.isEmpty()){
    			try {
					serviceTypeEquipmentService.updateServiceTypeEquipments(serviceTypeEquipments,dbResults);
				} catch (Exception e) {
					throw new CommonException("修改出错");
				}
    		}else{
    			 Map<String,ServiceTypeEquipment> addMap = new HashMap<String,ServiceTypeEquipment>();
    			//寻找新增的数据
     		   for(Map.Entry<String, ServiceTypeEquipment> ret : newMap.entrySet()){
     			    if(!sameMap.containsKey(ret.getKey())){
     			    	addMap.put(ret.getKey(), ret.getValue());
     			    }
     		   }
     		   Map<String,ServiceTypeEquipment> delMap = new HashMap<String,ServiceTypeEquipment>();
	     		//寻找删除的数据
	   		   for(  Map.Entry<String, ServiceTypeEquipment> sameRet :oldMap.entrySet()){
	   			   if(!sameMap.containsKey(sameRet.getKey())){
	   				   delMap.put(sameRet.getKey(), sameRet.getValue());
	   			   }
	   		   }
    			List<ServiceTypeEquipment> delList = new ArrayList<ServiceTypeEquipment>();
    			for(Map.Entry<String, ServiceTypeEquipment> reMap :delMap.entrySet()){
    				delList.add(reMap.getValue());
    			}
    			List<ServiceTypeEquipment> addList = new ArrayList<ServiceTypeEquipment>();
    			for(Map.Entry<String, ServiceTypeEquipment> reMap :addMap.entrySet()){
    				addList.add(reMap.getValue());
    			}
    			try {
					serviceTypeEquipmentService.updateServiceTypeEquipments(addList,delList);
				} catch (Exception e) {
					throw new CommonException("修改出错");
				}
    		}
    	}
    	return ResponseResult.success();
    }
    //转化
    private Map<String,ServiceTypeEquipment> createDataMap(List<ServiceTypeEquipment> params){
    	if(params==null||params.size()==0){
    		return null;
    	}
    	Map<String,ServiceTypeEquipment> resultMap = new HashMap<String,ServiceTypeEquipment>();
    	for(ServiceTypeEquipment p:params){
    		StringBuilder sb = new StringBuilder();
    		sb.append(p.getServiceType()).append("-").//
    		append(p.getEquipmentTypeId()).append("-").//
    		append(p.getEquipmentId());
    		resultMap.put(sb.toString(), p);
    	}
         return resultMap;
    }
    
    @ApiOperation(httpMethod="GET", value="跳转到服务类型关联服务设备界面")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditServiceTypeEquipmentView")
    @ResponseBody
    public ResponseResult<ServiceTypeEquipmentVo> toEditServiceTypeEquipmentView(@RequestParam(required=true) Integer serviceTypeId){
    	ServiceType serviceType = null;
    	if(serviceTypeId==null||(serviceType = serviceTypeService.queryObjById(serviceTypeId))==null){
    		throw new CommonException("传入的服务类型ID错误");
    	}
    	ServiceTypeEquipmentVo vo = new ServiceTypeEquipmentVo();
    	
    	vo.setServiceTypeName(serviceType.getName());
    	List<ServiceTypeEquipment>  serviceTypeEquipments =	serviceTypeEquipmentService.queryServiceTypeEquipmentsByServiceTypeId(serviceTypeId);
    	vo.setEquipments(serviceTypeEquipments);
    	return ResponseResult.success(vo);
    }
    
    @ApiOperation(httpMethod="POST", value="创建门店类型信息表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceType serviceType) {
    	int dd = (int) (System.currentTimeMillis()/1000);
    	serviceType.setCreatetime(dd);
        this.serviceTypeService.addObj(serviceType);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceType serviceType) {
        if (serviceType.getId() == null || serviceType.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.serviceTypeService.modifyObj(serviceType);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/stopServiceTypeById", consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestBody(required=true) ServiceTypeJSON serviceType) {
       Integer id =	serviceType.getId();
    	if(id==null||id<=0){
        	throw new CommonException("id 错误，请从新输入");
        }
        ServiceType type = this.serviceTypeService.queryObjById(id);
        if(type==null){
        	throw new CommonException("id 错误，请从新输入");
        }
        List<ServiceTypeEquipment> dbResults = serviceTypeEquipmentService.queryServiceTypeEquipmentsByServiceTypeId(id);
        if(dbResults!=null&&dbResults.size()>0){
        	throw new CommonException("此类型关联设备，不能停用");
        }
        type.setState(Byte.valueOf("2"));
        this.serviceTypeService.modifyObj(type);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询门店类型信息表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceType", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceType>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceTypeExample example = new ServiceTypeExample();
        example.setPageView(new PageView<ServiceType>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceTypeExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceType> pageData = this.serviceTypeService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
}