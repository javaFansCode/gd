package com.airmcl.air.app.web.controller;

import com.airmcl.air.app.entity.IndexColumn;
import com.airmcl.air.app.entity.IndexModel;
import com.airmcl.air.app.entity.IndexModelExample;
import com.airmcl.air.app.service.IndexModelService;
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

@Api(value="首页模块显示表")
@Controller
@RequestMapping("indexModel")
public class IndexModelController {
    @Resource
    protected IndexModelService indexModelService;

    @ApiOperation(httpMethod="POST", value="创建首页模块显示表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody IndexModel indexModel) {
        this.indexModelService.addObj(indexModel);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody IndexModel indexModel) {
        if (indexModel.getId() == null || indexModel.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.indexModelService.modifyObj(indexModel);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.indexModelService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<IndexModel>> findAll() {
        IndexModelExample example = new IndexModelExample();
        List<IndexModel> list=this.indexModelService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询首页模块显示表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 IndexModel", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<IndexModel>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        IndexModelExample example = new IndexModelExample();
        example.setPageView(new PageView<IndexModel>(pageNo, pageSize));
        
        if (wapper != null) {
            IndexModelExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<IndexModel> pageData = this.indexModelService.queryObjByPage(example);
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
        this.indexModelService.updateStateByIds(ids);
        return ResponseResult.success();
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}",consumes ="application/json")
    @ResponseBody
    public ResponseResult<IndexModel> findById(@PathVariable("id") Integer id) {
        IndexModel indexModel = this.indexModelService.queryObjById(id);
        return ResponseResult.success(indexModel);
    }

}