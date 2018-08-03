package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import com.airmcl.air.beautician.entity.StateEnum;
import com.airmcl.air.beautician.service.BeauticianRelationsService;
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

@Api(value="技师项目关联表")
@Controller
@RequestMapping("beauticianRelations")
public class BeauticianRelationsController {
    @Resource
    protected BeauticianRelationsService beauticianRelationsService;

    @ApiOperation(httpMethod="POST", value="创建技师项目关联表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeauticianRelations beauticianRelations) {
        this.beauticianRelationsService.addObj(beauticianRelations);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeauticianRelations beauticianRelations) {
        if (beauticianRelations.getId() == null || beauticianRelations.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beauticianRelationsService.modifyObj(beauticianRelations);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beauticianRelationsService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<BeauticianRelations>> findAll() {
        BeauticianRelationsExample example = new BeauticianRelationsExample();
        List<BeauticianRelations> list=this.beauticianRelationsService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询技师项目关联表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeauticianRelations", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeauticianRelations>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeauticianRelationsExample example = new BeauticianRelationsExample();
        example.setPageView(new PageView<BeauticianRelations>(pageNo, pageSize));
        
        if (wapper != null) {
            BeauticianRelationsExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeauticianRelations> pageData = this.beauticianRelationsService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }


    /**
     * 批量修改state状态
     * 状态，1已审核，2未审核 0删除  3下架
     */

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "service/updateState" )
    @ResponseBody
    public ResponseResult<String> updateState(@RequestParam(required=true) int[] ids,@RequestParam(required=true)  Integer state){
        if(StateEnum.fromCode(state)==null){
            throw new CommonException("不存在的状态，保存失败");
        }
        this.beauticianRelationsService.updateState(ids,state);
        return  ResponseResult.success();
    }
}