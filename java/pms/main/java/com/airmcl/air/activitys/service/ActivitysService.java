package com.airmcl.air.activitys.service;

import java.util.List;

import com.airmcl.air.activitys.entity.Activitys;
import com.airmcl.air.activitys.entity.ActivitysBeautyVo;
import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsExample;
import com.airmcl.air.activitys.entity.ActivitysCouponsVo;
import com.airmcl.air.activitys.entity.ActivitysExample;
import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesExample;
import com.airmcl.air.activitys.entity.ActivitysServicesVo;
import com.airmcl.air.activitys.entity.EnterActivitysVo;
import com.els.base.core.service.BaseService;

public interface ActivitysService extends BaseService<Activitys, ActivitysExample, Integer> {
	/**
	 * 
	 * @param vo 修改原来的活动详情
	 * @return
	 * @throws Exception
	 */
	boolean modifyActivitysDetail(EnterActivitysVo vo)throws RuntimeException;
	/**
	 * 保存活动详询
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean saveActivitysDetail(EnterActivitysVo vo)throws RuntimeException;
	 /**
	  * 查询活动服务关联表
	  * @param example
	  * @return
	  */
	 ActivitysServices queryActivitysServicesByActivitysServicesExample(ActivitysServicesExample example);
	 /**
	  * 查询优惠券和活动关联表
	  * @param example
	  * @return
	  */
	 ActivitysCoupons queryActivitysCouponsByActivitysCouponsExample(ActivitysCouponsExample example);
	 /**
	  * 根据活动id删除活动优惠券关联数据
	  * @param activitysId 活动id
	  * @return 受影响的行数
	  * @throws Exception
	  */
	int deleteActivitysCouponsByActivitysId(ActivitysCouponsExample example)throws RuntimeException;
	/**
	 * 删除活动服务的关联项目
	 * @param activitysServices
	 * @return 受影响的行数
	 * @throws Exception
	 */
	int deleteActivitysServices(ActivitysServices activitysServices)throws RuntimeException;
	/**
	 * 通过活动的id，查找和活动关联的优惠券
	 * @param activitysId 活动的id
	 * @return 优惠券列表
	 */
	List<ActivitysCouponsVo> queryActivitysCouponsVoListByActivitysId(Integer activitysId);
	/**
	 * 通过活动id，查找和活动关联的服务项目
	 * @param activitysId 活动id
	 * @return 服务项目列表
	 */
	List<ActivitysServicesVo> queryActivitysServicesVoListByActivitysId(Integer activitysId);
	/**
	 * 通过活动id，查找和活动关联的美容院
	 * @param activitysId
	 * @return
	 */
	List<ActivitysBeautyVo> queryActivitysBeautyVoListByActivitysId(Integer activitysId);
}