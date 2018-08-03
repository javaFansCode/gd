package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.airmcl.air.service.entity.ServiceType;
import com.airmcl.air.service.entity.ServiceTypeEquipment;
import com.airmcl.air.service.entity.ServiceTypeEquipmentExample;
import com.airmcl.air.service.entity.ServiceTypeEquipmentVo;
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

@Api(value="设备关联服务类型表")
@Controller
@RequestMapping("serviceTypeEquipment")
public class ServiceTypeEquipmentController {
    @Resource
    protected ServiceTypeEquipmentService serviceTypeEquipmentService;
    
    @ApiOperation(httpMethod="POST", value="创建设备关联服务类型表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceTypeEquipment serviceTypeEquipment) {
        this.serviceTypeEquipmentService.addObj(serviceTypeEquipment);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceTypeEquipment serviceTypeEquipment) {
        if (serviceTypeEquipment.getId() == null || serviceTypeEquipment.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.serviceTypeEquipmentService.modifyObj(serviceTypeEquipment);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
         
        this.serviceTypeEquipmentService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询设备关联服务类型表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceTypeEquipment", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceTypeEquipment>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceTypeEquipmentExample example = new ServiceTypeEquipmentExample();
        example.setPageView(new PageView<ServiceTypeEquipment>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceTypeEquipmentExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceTypeEquipment> pageData = this.serviceTypeEquipmentService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}