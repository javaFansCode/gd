package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.BeauticianExperience;
import com.airmcl.air.beautician.entity.BeauticianExperienceExample;
import com.airmcl.air.beautician.entity.StateEnum;
import com.airmcl.air.beautician.service.BeauticianExperienceService;
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

@Api(value="技师工作经历表")
@Controller
@RequestMapping("beauticianExperience")
public class BeauticianExperienceController {
    @Resource
    protected BeauticianExperienceService beauticianExperienceService;

    @ApiOperation(httpMethod="POST", value="创建技师工作经历表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeauticianExperience beauticianExperience) {
        this.beauticianExperienceService.addObj(beauticianExperience);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeauticianExperience beauticianExperience) {
        if (beauticianExperience.getId() == null || beauticianExperience.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beauticianExperienceService.modifyObj(beauticianExperience);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beauticianExperienceService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<BeauticianExperience>> findAll() {
        BeauticianExperienceExample example = new BeauticianExperienceExample();
        List<BeauticianExperience> list=this.beauticianExperienceService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询技师工作经历表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeauticianExperience", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeauticianExperience>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeauticianExperienceExample example = new BeauticianExperienceExample();
        example.setPageView(new PageView<BeauticianExperience>(pageNo, pageSize));
        
        if (wapper != null) {
            BeauticianExperienceExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeauticianExperience> pageData = this.beauticianExperienceService.queryObjByPage(example);
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
        this.beauticianExperienceService.updateState(ids,state);
        return  ResponseResult.success();
    }
}