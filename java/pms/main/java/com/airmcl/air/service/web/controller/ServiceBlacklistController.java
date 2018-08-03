package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.ServiceBlacklist;
import com.airmcl.air.service.entity.ServiceBlacklistExample;
import com.airmcl.air.service.service.ServiceBlacklistService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="项目黑名单表")
@Controller
@RequestMapping("serviceBlacklist")
public class ServiceBlacklistController {
    @Resource
    protected ServiceBlacklistService serviceBlacklistService;

    @ApiOperation(httpMethod="POST", value="创建项目黑名单表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceBlacklist serviceBlacklist) {
        this.serviceBlacklistService.addObj(serviceBlacklist);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceBlacklist serviceBlacklist) {
        if (serviceBlacklist.getId() == null || serviceBlacklist.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.serviceBlacklistService.modifyObj(serviceBlacklist);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        
        this.serviceBlacklistService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询项目黑名单表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceBlacklist", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceBlacklist>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceBlacklistExample example = new ServiceBlacklistExample();
        example.setPageView(new PageView<ServiceBlacklist>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceBlacklistExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceBlacklist> pageData = this.serviceBlacklistService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}