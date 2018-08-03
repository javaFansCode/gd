package com.airmcl.air.activitys.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.activitys.entity.Activitys;
import com.airmcl.air.activitys.entity.ActivitysBeautyVo;
import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsExample;
import com.airmcl.air.activitys.entity.ActivitysCouponsVo;
import com.airmcl.air.activitys.entity.ActivitysExample;
import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesExample;
import com.airmcl.air.activitys.entity.ActivitysServicesVo;
import com.airmcl.air.activitys.entity.EditActivityVo;
import com.airmcl.air.activitys.entity.EnterActivitysVo;
import com.airmcl.air.activitys.service.ActivitysService;
import com.airmcl.air.scheduler.service.ActivityJobService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParam;
import com.els.base.core.utils.query.QueryParamWapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="活动表")
@Controller
@RequestMapping("activitys")
public class ActivitysController {  
    @Resource
    protected ActivitysService activitysService;

    @Resource 
    protected ActivityJobService activityJobService;
    
    @RequestMapping(method = RequestMethod.POST, value = "service/ajaxEditActivitys")
    @ResponseBody
    public ResponseResult<String> ajaxEditActivitys(@RequestParam(required=true) Integer activityId,@RequestParam(required=false) Byte activityState,@RequestParam(required=false) Byte recommend){
    	boolean isOk = false;
    	Activitys activitys = null;
    	if (activityId == null || activityId <=0) {
            throw new CommonException("传入的数据有误");
        }
    	if((activityState==null&&recommend==null)||(activityState!=null&&recommend!=null)){
    		 throw new CommonException("传入的数据有误");
    	}
    	activitys = activitysService.queryObjById(activityId);
    	Byte delState = new Byte("0");
    	if(activitys==null||delState.equals(activitys.getState())){
    		 throw new CommonException("传入的数据有误");
    	}
    	Byte switchKey = -1;
    	if(recommend!=null){
    		if(recommend.equals(Byte.valueOf("1"))||recommend.equals(Byte.valueOf("2"))){
    			switchKey = 3;
    		}
    	}else{
    		switchKey = activityState;
    	}
    	
		switch (switchKey) {
		//活动状态 0 删除
		case 0:
			EnterActivitysVo vo = new EnterActivitysVo();
			activitys.setState(activityState);
			vo.setActivitys(activitys);
			try {
				activitysService.modifyActivitysDetail(vo);
				activitys = null;
				isOk = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			//活动状态 1:开启  2:停用
			break;
		case 1:
		case 2:
			try {
				Activitys tempActivitys = new Activitys();
				tempActivitys.setId(activitys.getId());
				tempActivitys.setState(activityState);
				activitys = null;
				activitysService.modifyObj(tempActivitys);
				isOk = true;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			break;
		//推荐活动
		case 3:
			try {
				Activitys tempActivitys = new Activitys();
				tempActivitys.setId(activitys.getId());
				tempActivitys.setIsrecommend(recommend);
				activitys = null;
				activitysService.modifyObj(tempActivitys);
				isOk = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	   return isOk == true?ResponseResult.success():ResponseResult.fail(ResponseCode.ERROR);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "service/ajaxEditCouponsAndServices")
    @ResponseBody
    public ResponseResult<String> ajaxEditCouponsAndServices(@RequestParam(required=true) Integer activityId,@RequestParam(required=true) Integer objectId,@RequestParam(required=true)Byte type)   {
    	if (activityId == null || activityId <=0 || (activitysService.queryObjById(activityId))==null) {
             throw new CommonException("传入的数据有误");
         }
    	if(type==null|| objectId==null|| objectId <=0){
    		throw new CommonException("传入的数据有误");
    	}
    	 boolean isOk = true;
    	 switch (type) {
    	 //删除优惠券
		  case 0:
			ActivitysCouponsExample example=new ActivitysCouponsExample();
			ActivitysCouponsExample.Criteria criteria= example.createCriteria();
			criteria.andIdEqualTo(objectId);
			ActivitysCoupons activitysCoupons = activitysService.queryActivitysCouponsByActivitysCouponsExample(example);
			if(activitysCoupons==null){
				isOk=false;
				break;
			}
			try {
				activitysService.deleteActivitysCouponsByActivitysId(example);
			} catch (Exception e) {
				e.printStackTrace();
				isOk=false;
			}
			break;
		 //删除服务
         case 1:
        	 ActivitysServicesExample servicesExample=new ActivitysServicesExample();
        	 ActivitysServicesExample.Criteria criterias = servicesExample.createCriteria();
        	 criterias.andIdEqualTo(objectId);
        	 criterias.andStateEqualTo(Byte.valueOf("1"));
        	 ActivitysServices activitysServices= activitysService.queryActivitysServicesByActivitysServicesExample(servicesExample);
        	 if(activitysServices==null){
        		 isOk=false;
 				 break;
        	 }
        	 activitysServices.setState(Byte.valueOf("0"));
        	 try {
				activitysService.deleteActivitysServices(activitysServices);
			} catch (Exception e) {
				e.printStackTrace();
				isOk=false;
			}
			break;
		default:
			isOk=false;
			break;
		}
    	 return  isOk==true?ResponseResult.success():ResponseResult.fail(ResponseCode.ERROR);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "service/toEditActivitysVo")
    @ResponseBody
    public ResponseResult<EditActivityVo> toEditActivitysVo(@RequestParam Integer id) {
        if (id == null || id <=0) {
            throw new CommonException("传入的id有误");
        }
        Activitys activitys = this.activitysService.queryObjById(id);
        Byte delState = new Byte("0");
        if(activitys==null||delState.equals(activitys.getState())){
        	 throw new CommonException("查找不到该活动或者改活动已经被删除");
        }
        EditActivityVo editActivityVo = new EditActivityVo();
        editActivityVo.setActivitys(activitys);
        activitys = null;
        List<ActivitysCouponsVo>  activitysCouponsVoList = activitysService.queryActivitysCouponsVoListByActivitysId(id);
        List<ActivitysServicesVo> activitysServicesVoList= activitysService.queryActivitysServicesVoListByActivitysId(id);
        List<ActivitysBeautyVo>   activitysBeautyVoList =  activitysService.queryActivitysBeautyVoListByActivitysId(id);
        
        if(activitysCouponsVoList!=null&&!activitysCouponsVoList.isEmpty()){
        	editActivityVo.setActivitysCouponsList(activitysCouponsVoList);
        	activitysCouponsVoList = null;
        }
        if(activitysServicesVoList!=null&&!activitysServicesVoList.isEmpty()){
        	editActivityVo.setActivitysServicesList(activitysServicesVoList);
        	activitysServicesVoList = null;
        }
        if(activitysBeautyVoList!=null&&!activitysBeautyVoList.isEmpty()){
        	editActivityVo.setActivitysBeautyVoList(activitysBeautyVoList);
        	activitysBeautyVoList = null;
        }
        return ResponseResult.success(editActivityVo);
    }
    
    @ApiOperation(httpMethod="POST", value="创建活动表")
    @RequestMapping(method = RequestMethod.POST, value = "service/create",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody EnterActivitysVo enterActivitysVo) {
        try {
			 this.activitysService.saveActivitysDetail(enterActivitysVo);
		} catch (Exception e) {
			 e.printStackTrace();
			 return ResponseResult.fail(ResponseCode.ERROR);
		}
        return ResponseResult.success();
    }

    @RequestMapping(method = RequestMethod.POST, value = "service/edit",consumes ="application/json")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody EnterActivitysVo vo) {
    	Activitys activitys = vo.getActivitys();
        if (activitys.getId() == null || activitys.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        
		try {
			boolean isOk = this.activitysService.modifyActivitysDetail(vo);
			return isOk == true?ResponseResult.success():ResponseResult.fail(ResponseCode.Fail);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseResult.fail(ResponseCode.ERROR);
		}
    }

    @ApiOperation(httpMethod="POST", value="查询活动表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Activitys", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping(method = RequestMethod.POST, value = "service/findByPage",consumes ="application/json")
    @ResponseBody
    public ResponseResult<PageView<Activitys>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper,
	 @RequestParam(required=false) Integer validTimeSt,//
	 @RequestParam(required=false) Integer validTimeEt) {
    	
        ActivitysExample example = new ActivitysExample();
        example.setOrderByClause("createtime desc");
        example.setPageView(new PageView<Activitys>(pageNo, pageSize));
        ActivitysExample.Criteria criteria = example.createCriteria();
        boolean notStateFlag = true;
        if (wapper != null) {
        	  List<QueryParam> queryParamList = wapper.getQueryParams();
        	  if(queryParamList!=null){
        		  for (QueryParam queryParam : queryParamList) {
     				 if( queryParam.getProperty().contains("state")){
     					  notStateFlag = false;
     					  break;
     				 }
     			 }
        	  }
        	  CriteriaUtils.addCriterion(criteria, wapper);
        }
        if(notStateFlag){
        	criteria.andStateNotEqualTo((byte)0);
        }
        if(validTimeSt!=null&&validTimeEt!=null){
        	//最大的时间
        	int maxTime = Math.max(validTimeSt, validTimeEt);
        	//最小的时间
        	int minTime = Math.min(validTimeSt, validTimeEt);
        	// maxTime >= starttime
        	// minTime <= endtime
        	criteria.andStarttimeLessThanOrEqualTo(maxTime);
        	criteria.andEndtimeGreaterThanOrEqualTo(minTime);
        	/**
        	 * (`starttime` >= '开始有效' AND `starttime` <= '截止有效') 
        	 * OR (`endtime` >= '开始有效' AND `endtime` <= '截止有效')
        	 * OR (starttime>='开始有效' AND endtime <= '截止有效') 
        	 * OR (starttime<='开始有效' AND endtime>='截止有效')
        	 */
//        	ActivitysExample.Criteria start = example.createCriteria();
//        	start.andStarttimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(start);
//        	
//        	ActivitysExample.Criteria end = example.createCriteria();
//        	end.andEndtimeBetween(validTimeSt, validTimeEt).andStateNotEqualTo((byte)0);
//        	example.or(end);
//        	
//        	ActivitysExample.Criteria stend = example.createCriteria();
//        	stend.andStarttimeGreaterThanOrEqualTo(validTimeSt).andStateNotEqualTo((byte)0)//
//        	.andEndtimeLessThanOrEqualTo(validTimeEt);
//        	example.or(stend);
//        	
//        	ActivitysExample.Criteria sttend =example.createCriteria();
//	        	sttend.andStarttimeLessThanOrEqualTo(validTimeEt).andStateNotEqualTo((byte)0)//
//	        	.andEndtimeGreaterThanOrEqualTo(validTimeSt);
//	        	example.or(sttend);
        	
        }
        PageView<Activitys> pageData = this.activitysService.queryObjByPage(example);
        List<Activitys> activitysList =   pageData.getQueryResult();
        for (Activitys activitys : activitysList) {
        	Integer activitysId = activitys.getId();
        	List<ActivitysCouponsVo>  vosCV = activitysService.queryActivitysCouponsVoListByActivitysId(activitysId);
        	List<ActivitysServicesVo> vosSV = activitysService.queryActivitysServicesVoListByActivitysId(activitysId);
        	List<ActivitysBeautyVo>   beautyVo =	activitysService.queryActivitysBeautyVoListByActivitysId(activitysId);
        	activitys.setCouponList(vosCV);
        	activitys.setServiceItemList(vosSV);
        	activitys.setActivitysBeautyVoList(beautyVo);
		}
        return ResponseResult.success(pageData);
    }
}