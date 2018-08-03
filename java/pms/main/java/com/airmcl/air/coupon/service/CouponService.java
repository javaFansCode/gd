package com.airmcl.air.coupon.service;

import javax.servlet.http.HttpServletResponse;

import com.airmcl.air.coupon.enter.EnterUserCouponParams;
import com.airmcl.air.coupon.entity.Coupon;
import com.airmcl.air.coupon.entity.CouponExample;
import com.airmcl.air.coupon.entity.CouponVO;
import com.airmcl.air.coupon.out.OutUserCouponDetails;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

import jxl.write.WritableWorkbook;

public interface CouponService extends BaseService<Coupon, CouponExample, Integer> {
	/**
     * 查询优惠券详情列表
     * @param params
     */
    PageView<OutUserCouponDetails> findUserCouponDetailsByParams(int pageNo,int pageSize,EnterUserCouponParams params) throws Exception;

    /**
     * 导出
     */
    /**
     * 导出
     */
    WritableWorkbook exportDataToExcel(Integer couponId,String userPhone,String couponTitle,
    		String startcreatetime,String endcreatetime,HttpServletResponse response) throws Exception;

    /**
     * 手动送券
     * @param userPhone
     */
	void sendCouponByHand(String mobile, String couponId);
	/**
	 * 保存优惠券和优惠券关联的服务项目
	 * @param coupon
	 * @return
	 * @throws RuntimeException
	 */
	int saveCouponServiceDetail(CouponVO coupon)throws RuntimeException;
}