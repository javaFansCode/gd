package com.airmcl.air.coupon.dao;

import java.util.List;

import com.airmcl.air.coupon.entity.UsersCoupon;
import com.airmcl.air.coupon.entity.UsersCouponExample;

public interface UserCouponMapper {
	
	 List<UsersCoupon> selectByExampleByPage(UsersCouponExample example);
	 
	 List<UsersCoupon> selectByExample(UsersCouponExample example);

	 /**
	  * 手动派劵批量插入mdd_api_users_coupon表信息
	  * @param usersCoupon
	  */
	void insert(UsersCoupon usersCoupon);
	  
}
