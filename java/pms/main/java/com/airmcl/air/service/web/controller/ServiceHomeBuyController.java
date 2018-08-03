package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.entity.ServiceHomeBuy;
import com.airmcl.air.service.entity.ServiceHomeBuyExample;
import com.airmcl.air.service.entity.ServiceHomeBuyVo;
import com.airmcl.air.service.service.ServiceHomeBuyService;
import com.airmcl.air.service.service.ServiceService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="项目限购控制表")
@Controller
@RequestMapping("serviceHomeBuy")
public class ServiceHomeBuyController {
    @Resource
    protected ServiceHomeBuyService serviceHomeBuyService;
    @Resource
    protected ServiceService serviceService;
    //serviceHomeBuy/service/toEditeView
    
    @ApiOperation(httpMethod="POST", value="创建项目限购控制表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody(required=true) ServiceHomeBuy serviceHomeBuy) {
    	Integer serviceId = serviceHomeBuy.getServiceId();
    	if(serviceId==null){
    		throw new CommonException("数据添加失败");
    	}
		Service service = serviceService.queryObjById(serviceId);
		if(service==null){
			throw new CommonException("数据添加失败");
		}
		try {
			this.serviceHomeBuyService.modifyServiceHomeBuyAndServiceHomeBuyRecord(serviceHomeBuy);
			 return ResponseResult.success();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		throw new CommonException("数据添加失败");
    }

    @ApiOperation(httpMethod="GET", value="项目限购回显")
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditeView")
    @ResponseBody
    public ResponseResult<ServiceHomeBuyVo> toEditeView(@RequestParam(required=true) Integer serviceId) {
    	if(serviceId==null||serviceId<=0){
    		throw new CommonException("数据回显失败,id错误");
    	}
    	Service service = serviceService.queryObjById(serviceId);
    	if(service==null){
    		throw new CommonException("数据回显失败,id错误");
    	}
    	ServiceHomeBuyVo vo = new ServiceHomeBuyVo();
    	ServiceHomeBuy serviceHomeBuy = this.serviceHomeBuyService.queryObjByserviceId(serviceId);
    	if(serviceHomeBuy!=null){
    		vo.setServiceHomeBuy(serviceHomeBuy);
    	}
    	vo.setService(service);
        return ResponseResult.success(vo);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceHomeBuy serviceHomeBuy) {
        if (serviceHomeBuy.getId() == null || serviceHomeBuy.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        ServiceHomeBuy tempServiceHomeBuy = this.serviceHomeBuyService.queryObjByserviceId(serviceHomeBuy.getServiceId());
        if(tempServiceHomeBuy==null){
        	throw new CommonException("数据错误，回显失败");
        }
    	try {
			 this.serviceHomeBuyService.modifyServiceHomeBuyAndServiceHomeBuyRecord(serviceHomeBuy);
			 return ResponseResult.success();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
    	throw new CommonException("数据修改失败");
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) Integer id) {
    	if(id==null||id<=0){
    		throw new CommonException("删除失败,id不能为空");
    	}
        this.serviceHomeBuyService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询项目限购控制表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceHomeBuy", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceHomeBuy>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceHomeBuyExample example = new ServiceHomeBuyExample();
        example.setPageView(new PageView<ServiceHomeBuy>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceHomeBuyExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceHomeBuy> pageData = this.serviceHomeBuyService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}