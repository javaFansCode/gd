package com.airmcl.air.beauty.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.basae.utils.DateUtil;
import com.airmcl.air.beauty.entity.BeautyProfit;
import com.airmcl.air.beauty.entity.BeautyProfitExample;
import com.airmcl.air.beauty.entity.BeautyProfitPara;
import com.airmcl.air.beauty.service.BeautyProfitService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="门店分润表")
@Controller
@RequestMapping("beautyProfit")
public class BeautyProfitController {
    @Resource
    protected BeautyProfitService beautyProfitService;

    @ApiOperation(httpMethod="POST", value="创建门店分润受益方")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody BeautyProfitPara bpp) {
    	//第一步：先将该门店对应门店受益方类型的状态修改为0删除
    	Map<String, Object> para=new HashMap<String, Object>();
    	para.put("beautyId",bpp.getBeautyId());
    	para.put("type", bpp.getType());
    	this.beautyProfitService.updateBeautyProfitState(para);
    	
    	//第二步：添加该门店指定类型的门店收益方
    	BeautyProfit bp=new BeautyProfit();
    	bp.setCreatetime(Integer.valueOf( String.valueOf(DateUtil.getTimeLong())) );
    	bp.setState((byte)1);
    	bp.setBeautyId(bpp.getBeautyId());
    	bp.setMobile(bpp.getMobile());
    	bp.setName(bpp.getName());
    	bp.setOpenId(bpp.getOpenId());
    	bp.setType(bpp.getType());
        this.beautyProfitService.addObj(bp);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody BeautyProfit beautyProfit) {
        if (beautyProfit.getId() == null || beautyProfit.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.beautyProfitService.modifyObj(beautyProfit);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beautyProfitService.deleteObjById(id);
        return ResponseResult.success();
    }

    /***
     * 获取指定门店的分润受益人
     * @param beautyId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<BeautyProfit>> findAll(@RequestParam(required=true) int beautyId) {
        BeautyProfitExample example = new BeautyProfitExample();
        BeautyProfitExample.Criteria criteria = example.createCriteria();
        criteria.andBeautyIdEqualTo(beautyId);
        criteria.andStateEqualTo((byte)1);
        List<BeautyProfit> list=this.beautyProfitService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询门店分润表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 BeautyProfit", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<BeautyProfit>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeautyProfitExample example = new BeautyProfitExample();
        example.setPageView(new PageView<BeautyProfit>(pageNo, pageSize));
        
        if (wapper != null) {
            BeautyProfitExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<BeautyProfit> pageData = this.beautyProfitService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}