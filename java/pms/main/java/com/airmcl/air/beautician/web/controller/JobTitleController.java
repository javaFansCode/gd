package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.Beautician;
import com.airmcl.air.beautician.entity.JobTitle;
import com.airmcl.air.beautician.entity.JobTitleExample;
import com.airmcl.air.beautician.entity.StateEnum;
import com.airmcl.air.beautician.service.JobTitleService;
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

@Api(value="美容师职称表")
@Controller
@RequestMapping("jobTitle")
public class JobTitleController {
    @Resource
    protected JobTitleService jobTitleService;

    @ApiOperation(httpMethod="POST", value="创建美容师职称表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody JobTitle jobTitle) {
        this.jobTitleService.addObj(jobTitle);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody JobTitle jobTitle) {
        if (jobTitle.getId() == null || jobTitle.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }

        JobTitle jobTitle1 = this.jobTitleService.queryObjById(jobTitle.getId());
        if (jobTitle1==null){
            throw new CommonException("id 无效，保存失败");
        }


        this.jobTitleService.modifyObj(jobTitle);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.jobTitleService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<JobTitle>> findAll() {
        JobTitleExample example = new JobTitleExample();
        List<JobTitle> list=this.jobTitleService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询美容师职称表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 JobTitle", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<JobTitle>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        JobTitleExample example = new JobTitleExample();
        example.setPageView(new PageView<JobTitle>(pageNo, pageSize));
        
        if (wapper != null) {
            JobTitleExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<JobTitle> pageData = this.jobTitleService.queryObjByPage(example);
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
        this.jobTitleService.deleteByIds(ids);
        return ResponseResult.success();
    }

    /**
     * 查询单条数据
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}")
    @ResponseBody
    public ResponseResult<JobTitle> findById(@PathVariable("id") Integer id) {
        JobTitle jobTitle = this.jobTitleService.queryObjById(id);
        return ResponseResult.success(jobTitle);
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
        this.jobTitleService.updateState(ids,state);
        return  ResponseResult.success();
    }

}