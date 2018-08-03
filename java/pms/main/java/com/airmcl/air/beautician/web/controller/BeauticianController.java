package com.airmcl.air.beautician.web.controller;

import com.airmcl.air.beautician.entity.Beautician;
import com.airmcl.air.beautician.entity.BeauticianExample;
import com.airmcl.air.beautician.entity.BeauticianExample.Criteria;
import com.airmcl.air.beautician.entity.StateEnum;
import com.airmcl.air.beautician.service.BeauticianService;
import com.airmcl.basae.utils.BaseConst;
import com.airmcl.basae.utils.Dictionary;
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

@Api(value="技师主表")
@Controller
@RequestMapping("beautician")
public class BeauticianController {
    @Resource
    protected BeauticianService beauticianService;

    @ApiOperation(httpMethod="POST", value="创建技师主表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Beautician beautician) {
        this.beauticianService.addObj(beautician);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Beautician beautician) {
        if (beautician.getId() == null || beautician.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        Beautician beautician1 = this.beauticianService.queryObjById(beautician.getId());
        if(beautician1==null){
            throw new CommonException("id 无效，保存失败");
        }



        this.beauticianService.modifyObj(beautician);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findById/{id}")
    @ResponseBody
    public ResponseResult<Beautician> findById(@PathVariable("id") Integer id) {
        Beautician beautician = this.beauticianService.queryObjById(id);
        return ResponseResult.success(beautician);
    }





    @RequestMapping(method  = {RequestMethod.GET, RequestMethod.POST}, value = "service/deleteById", produces = "application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {


        this.beauticianService.deleteObjById(id);
        return ResponseResult.success();
    }

    /**
     * 批量删除技师
     * @param ids
     * @return
     */
    @RequestMapping(method  = {RequestMethod.GET, RequestMethod.POST}, value = "service/deleteByIds", consumes = "application/json")
    @ResponseBody
    public ResponseResult<String> deleteByIds(@RequestParam(required=true) int[] ids) {
        this.beauticianService.deleteByIds(ids);
        return ResponseResult.success();
    }




    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<Beautician>> findAll() {
        BeauticianExample example = new BeauticianExample();
        List<Beautician> list=this.beauticianService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询技师主表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Beautician", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Beautician>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeauticianExample example = new BeauticianExample();
        //时间降序
        example.setOrderByClause("createtime desc");
        example.setPageView(new PageView<Beautician>(pageNo, pageSize));
        BeauticianExample.Criteria criteria = example.createCriteria().andStateNotEqualTo(BaseConst.BEAUTICIAN_STATE_DELETE);//将删除状态的技师不在列表中显示
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<Beautician> pageData = this.beauticianService.queryObjByPage(example);
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
        this.beauticianService.updateState(ids,state);
        return  ResponseResult.success();
    }

}