package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.BeauticianIntf;
import com.airmcl.air.beautician.entity.BeauticianIntfExample;
import com.airmcl.air.beautician.service.BeauticianIntfService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="记录美容师做过的服务项目和获得的内耗值")
@Controller
@RequestMapping("beauticianIntf")
public class BeauticianIntfController {
    @Resource
    protected BeauticianIntfService beauticianIntfService;

    @ApiOperation(httpMethod="POST", value="创建记录美容师做过的服务项目和获得的内耗值")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeauticianIntf beauticianIntf) {
        this.beauticianIntfService.addObj(beauticianIntf);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeauticianIntf beauticianIntf) {
        if (beauticianIntf.getId() == null || beauticianIntf.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beauticianIntfService.modifyObj(beauticianIntf);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beauticianIntfService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<BeauticianIntf>> findAll() {
        BeauticianIntfExample example = new BeauticianIntfExample();
        List<BeauticianIntf> list=this.beauticianIntfService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询记录美容师做过的服务项目和获得的内耗值")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeauticianIntf", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeauticianIntf>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeauticianIntfExample example = new BeauticianIntfExample();
        example.setPageView(new PageView<BeauticianIntf>(pageNo, pageSize));
        
        if (wapper != null) {
            BeauticianIntfExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeauticianIntf> pageData = this.beauticianIntfService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}