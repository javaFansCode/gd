package com.airmcl.air.beauty.web.controller;

import com.airmcl.air.beauty.entity.*;
import com.airmcl.air.beauty.service.BeautyExtendService;
import com.airmcl.air.beauty.service.BeautyProfitService;
import com.airmcl.air.beauty.service.BeautyService;
import com.airmcl.basae.utils.BaseConst;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value="门店主表")
@Controller
@RequestMapping("beauty")
public class BeautyController {
    @Resource
    protected BeautyService beautyService;
    @Resource
    protected BeautyExtendService beautyExtendService;
    @Resource
    protected BeautyProfitService beautyProfitService;
    
    @ApiOperation(httpMethod="GET", value="获取门店详细信息")
    @RequestMapping(method = RequestMethod.GET, value = "service/getBeautyDetail")
    @ResponseBody
    public ResponseResult<EnterBeautyVO> findBeautyDetail(@RequestParam (required = true) int id ) {
    	 EnterBeautyVO enterBeautyVO = new EnterBeautyVO();
    	 Beauty beauty = beautyService.queryObjById(id);
    	 if(beauty==null){
    		 return ResponseResult.fail(ResponseCode.Param_Error, enterBeautyVO);
    	 }
    	 enterBeautyVO.setBeauty(beauty);
    	 BeautyExtendExample beautyExtendExample = new BeautyExtendExample();
    	 beautyExtendExample.createCriteria().andBeautyIdEqualTo(id);
    	 List<BeautyExtend> beautyExtendList = beautyExtendService.queryAllObjByExample(beautyExtendExample);
    	 if(beautyExtendList!=null&&beautyExtendList.size()>0){
    		 enterBeautyVO.setBeautyExtend(beautyExtendList.get(0));
    	 }
    	 BeautyProfitExample beautyProfitExample = new BeautyProfitExample();
    	 beautyProfitExample.createCriteria().andBeautyIdEqualTo(id).andStateEqualTo((byte)1);
    	 List<BeautyProfit>  beautyProfitList =  beautyProfitService.queryAllObjByExample(beautyProfitExample);
    	 if(beautyProfitList!=null){
    		 enterBeautyVO.setBeautyProfitList(beautyProfitList);
    	 }
    	 return ResponseResult.success(enterBeautyVO);
    }
    @ApiOperation(httpMethod="POST", value="创建门店主表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody EnterBeautyVO enterBeautyVO) {
    	Long time = System.currentTimeMillis()/1000;
        try {
			 beautyService.addBeautyDetail(enterBeautyVO,time.intValue());
			 return ResponseResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage().contains("doesn't have a default value")){
				return ResponseResult.fail(ResponseCode.Param_Error);
			}
		}
        return ResponseResult.fail(ResponseCode.ERROR);
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/changeState",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestParam (required = true) int id,@RequestParam  (required = true)  int state   ) {
    	Beauty beauty=null;
     
		beauty=beautyService.queryObjById(id);
		beauty.setState(Byte.parseByte(String.valueOf(state)) );
		this.beautyService.modifyObj(beauty);
 
        return ResponseResult.success();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody EnterBeautyVO enterBeautyVO) {
        Beauty beauty = enterBeautyVO.getBeauty();
		if (beauty.getId() == null || beauty.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
         }
		 try {
			 this.beautyService.updateBeautyDetail(enterBeautyVO);
			 return ResponseResult.success();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
        this.beautyService.modifyObj(beauty);
        return ResponseResult.fail(ResponseCode.ERROR);
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/deleteById",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.beautyService.deleteObjById(id);
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
    @ResponseBody
    public ResponseResult<List<Beauty>> findAll() {
        BeautyExample example = new BeautyExample();
        List<Beauty> list=this.beautyService.queryAllObjByExample(example);
        	return ResponseResult.success(list);
    }

    @ApiOperation(httpMethod="POST", value="查询门店主表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Beauty", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Beauty>> findByPage(  
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        BeautyExample example = new BeautyExample();
        example.setPageView(new PageView<Beauty>(pageNo, pageSize));
        example.setOrderByClause("createtime DESC");
        BeautyExample.Criteria criteria =  example.createCriteria().andStateNotEqualTo(BaseConst.BEAUTY_STATE_DELETE);//将删除状态的门店不在列表中显示
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        PageView<Beauty> pageData = this.beautyService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
     
    @ApiOperation(httpMethod="POST", value="根据门店id数组查询对应详情信息")
    @RequestMapping(method = RequestMethod.GET, value = "service/findInfoByListId")
    @ResponseBody
    public ResponseResult<List<Beauty>> findInfoByListId(
    		@RequestParam(value = "id") String id){
    	List<Beauty> list = beautyService.selectDetilByIds(id);
		return  ResponseResult.success(list);
    }
    
}