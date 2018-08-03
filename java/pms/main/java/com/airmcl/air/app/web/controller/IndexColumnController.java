package com.airmcl.air.app.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.app.entity.IndexColumn;
import com.airmcl.air.app.entity.IndexColumnExample;
import com.airmcl.air.app.entity.IndexEnterColumnAndModelParams;
import com.airmcl.air.app.entity.IndexOutColumnAndModel;
import com.airmcl.air.app.service.IndexColumnService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="首页栏目管理")
@Controller
@RequestMapping("indexColumn")
public class IndexColumnController {
    @Resource
    protected IndexColumnService indexColumnService;

    @ApiOperation(httpMethod="POST", value="创建首页栏目管理")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody IndexColumn indexColumn) {
    	Integer time = (int) (System.currentTimeMillis()/1000);
			indexColumn.setCreatetime(time);
			indexColumn.setUpdatetime(time);
			this.indexColumnService.addObj(indexColumn);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody IndexColumn indexColumn) {
        if (indexColumn.getId() == null || indexColumn.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.indexColumnService.modifyObj(indexColumn);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
    	this.indexColumnService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<IndexColumn>> findAll() {
        IndexColumnExample example = new IndexColumnExample();
        List<IndexColumn> list=this.indexColumnService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    /**
     * 栏目查询以及推荐项目查询调用同一个接口
     * 
     * @param pageNo
     * @param pageSize
     * @param enterParams
     * @return
     */
    @ApiOperation(httpMethod="POST", value="查询首页栏目管理")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 IndexColumn", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<IndexOutColumnAndModel>> findByPage(
	 @RequestParam(defaultValue="0") int pageNo,
     @RequestParam(defaultValue="10") int pageSize,
	 @RequestBody(required=false) IndexEnterColumnAndModelParams enterParams) {
    	
    	PageView<IndexOutColumnAndModel> resultData = this.indexColumnService.findPageByParams(enterParams,pageNo,pageSize);
    	
        return ResponseResult.success(resultData);
    }

    /**
     * 批量删
     * @param ids
     * @return
     */

    @RequestMapping(method  = {RequestMethod.GET, RequestMethod.POST}, value = "service/deleteByIds", consumes = "application/json")
    @ResponseBody
    public ResponseResult<String> deleteByIds(@RequestParam(required=true) int[] ids) {
        this.indexColumnService.updateStateByIds(ids);
        return ResponseResult.success();
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}")
    @ResponseBody
    public ResponseResult<IndexColumn> findById(@PathVariable("id") Integer id) {
        IndexColumn indexColumn = this.indexColumnService.queryObjById(id);
        return ResponseResult.success(indexColumn);
    }
}