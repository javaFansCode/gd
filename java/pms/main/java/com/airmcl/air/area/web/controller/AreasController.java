package com.airmcl.air.area.web.controller;

import com.airmcl.air.area.entity.Areas;
import com.airmcl.air.area.entity.AreasExample;
import com.airmcl.air.area.service.AreasService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="三级联动地区表")
@Controller
@RequestMapping("areas")
public class AreasController {
    @Resource
    protected AreasService areasService;

    @ApiOperation(httpMethod="POST", value="创建三级联动地区表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Areas areas) {
        this.areasService.addObj(areas);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Areas areas) {
        if (areas.getId() == null || areas.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.areasService.modifyObj(areas);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        if (id <=0) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.areasService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询三级联动地区表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Areas", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Areas>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        AreasExample example = new AreasExample();
        example.setPageView(new PageView<Areas>(pageNo, pageSize));
        
        if (wapper != null) {
            AreasExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Areas> pageData = this.areasService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }

    @ApiOperation(httpMethod="GET", value="查询三级联动地区数据，不分页")
    @RequestMapping(method = RequestMethod.GET, value = "service/getAreasList",consumes ="application/json")
    @ResponseBody
    public ResponseResult<List<Areas>> getAreasList(@RequestParam int parent_id){
        AreasExample example = new AreasExample();

        AreasExample.Criteria criteria = example.createCriteria();
        criteria.andParent_idEqualTo(parent_id);

        List<Areas> areasList = this.areasService.queryAllObjByExample(example);
        return ResponseResult.success(areasList);
    }
}