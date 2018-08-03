package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.BeauticianWorktime;
import com.airmcl.air.beautician.entity.BeauticianWorktimeExample;
import com.airmcl.air.beautician.service.BeauticianWorktimeService;
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

@Api(value="技师工作预约时间记录表")
@Controller
@RequestMapping("beauticianWorktime")
public class BeauticianWorktimeController {
    @Resource
    protected BeauticianWorktimeService beauticianWorktimeService;

    @ApiOperation(httpMethod="POST", value="创建技师工作预约时间记录表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeauticianWorktime beauticianWorktime) {
        this.beauticianWorktimeService.addObj(beauticianWorktime);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeauticianWorktime beauticianWorktime) {
        if (beauticianWorktime.getId() == null || beauticianWorktime.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beauticianWorktimeService.modifyObj(beauticianWorktime);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beauticianWorktimeService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<BeauticianWorktime>> findAll() {
        BeauticianWorktimeExample example = new BeauticianWorktimeExample();
        List<BeauticianWorktime> list=this.beauticianWorktimeService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询技师工作预约时间记录表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeauticianWorktime", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeauticianWorktime>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeauticianWorktimeExample example = new BeauticianWorktimeExample();
        example.setPageView(new PageView<BeauticianWorktime>(pageNo, pageSize));
        
        if (wapper != null) {
            BeauticianWorktimeExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeauticianWorktime> pageData = this.beauticianWorktimeService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}