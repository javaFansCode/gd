package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceCityExample;
import com.airmcl.air.service.service.ServiceCityService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="服务项目对应城市价格表")
@Controller
@RequestMapping("serviceCity")
public class ServiceCityController {
    @Resource
    protected ServiceCityService serviceCityService;

    
    
    @ApiOperation(httpMethod="POST", value="创建服务项目对应城市价格表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceCity serviceCity) {
        this.serviceCityService.addObj(serviceCity);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceCity serviceCity) {
        if (serviceCity.getId() == null || serviceCity.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.serviceCityService.modifyObj(serviceCity);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) Integer id) {
    	if(id==null){
    		throw new CommonException("删除失败,id不能为空");
    	}
        this.serviceCityService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询服务项目对应城市价格表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceCity", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceCity>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceCityExample example = new ServiceCityExample();
        example.setPageView(new PageView<ServiceCity>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceCityExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceCity> pageData = this.serviceCityService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}