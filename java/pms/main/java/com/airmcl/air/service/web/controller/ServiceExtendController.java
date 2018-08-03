package com.airmcl.air.service.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceExtendExample;
import com.airmcl.air.service.service.ServiceExtendService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="服务项目扩展表")
@Controller
@RequestMapping("serviceExtend")
public class ServiceExtendController {
    @Resource
    protected ServiceExtendService serviceExtendService;

    @ApiOperation(httpMethod="POST", value="创建服务项目扩展表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody ServiceExtend serviceExtend) {
        this.serviceExtendService.addObj(serviceExtend);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody ServiceExtend serviceExtend) {
        if (serviceExtend.getId() == null || serviceExtend.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.serviceExtendService.modifyObj(serviceExtend);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) Integer id) {
        
        if(id==null||id<=0){
        	throw new CommonException("删除失败,id不能为空");
        }
        this.serviceExtendService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询服务项目扩展表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 ServiceExtend", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<ServiceExtend>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        ServiceExtendExample example = new ServiceExtendExample();
        example.setPageView(new PageView<ServiceExtend>(pageNo, pageSize));
        
        if (wapper != null) {
            ServiceExtendExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<ServiceExtend> pageData = this.serviceExtendService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}