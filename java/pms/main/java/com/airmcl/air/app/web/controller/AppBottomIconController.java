package com.airmcl.air.app.web.controller;

import com.airmcl.air.app.entity.AppBottomIcon;
import com.airmcl.air.app.entity.AppBottomIconExample;
import com.airmcl.air.app.service.AppBottomIconService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="app底部管理")
@Controller
@RequestMapping("appBottomIcon")
public class AppBottomIconController {
    @Resource
    protected AppBottomIconService appBottomIconService;

    @ApiOperation(httpMethod="POST", value="创建app底部管理")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody AppBottomIcon appBottomIcon) {
        this.appBottomIconService.addObj(appBottomIcon);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody AppBottomIcon appBottomIcon) {
        if (appBottomIcon.getId() == null || appBottomIcon.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.appBottomIconService.modifyObj(appBottomIcon);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.appBottomIconService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<AppBottomIcon>> findAll() {
        AppBottomIconExample example = new AppBottomIconExample();
        List<AppBottomIcon> list=this.appBottomIconService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询app底部管理")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 AppBottomIcon", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<AppBottomIcon>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        AppBottomIconExample example = new AppBottomIconExample();
        example.setPageView(new PageView<AppBottomIcon>(pageNo, pageSize));
        
        if (wapper != null) {
            AppBottomIconExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<AppBottomIcon> pageData = this.appBottomIconService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }


    /**
     * 批量删
     * @param ids
     * @return
     */

    @RequestMapping(method  = {RequestMethod.GET, RequestMethod.POST}, value = "service/deleteByIds", consumes = "application/json")
    @ResponseBody
    public ResponseResult<String> deleteByIds(@RequestParam(required=true) int[] ids) {
        this.appBottomIconService.updateStateByIds(ids);
        return ResponseResult.success();
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}",consumes ="application/json")
    @ResponseBody
    public ResponseResult<AppBottomIcon> findById(@PathVariable("id") Integer id) {
        AppBottomIcon appBottomIcon = this.appBottomIconService.queryObjById(id);
        return ResponseResult.success(appBottomIcon);
    }



}