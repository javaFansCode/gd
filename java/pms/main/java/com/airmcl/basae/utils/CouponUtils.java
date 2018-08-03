package com.airmcl.basae.utils;

import com.airmcl.air.coupon.entity.CouponTitleVO;
import com.airmcl.air.coupon.entity.UsersCoupon;

/**
 * 优惠券工具类，生成优惠券标题
 * @author wzy
 * Date: 2018/4/2
 * Time: 16:59
 */
public class CouponUtils {

    /**
     * 拼装优惠信息文字
     * @param coupon
     * @return
     */
    public static CouponTitleVO getCouponTitle(UsersCoupon coupon){

        CouponTitleVO couponTitleVO = new CouponTitleVO();
        switch (coupon.getUseType().intValue()){
            case 1:
                couponTitleVO.setTitle("满" + coupon.getMoneyMax() + "减" + coupon.getMoneyReduce());
                couponTitleVO.setMoney("￥" + coupon.getMoneyReduce());
                break;
            case 2:
                couponTitleVO.setTitle("不可与其他优惠同时使用");
                couponTitleVO.setMoney("￥" + coupon.getMoneyAmount());
                break;
            case 3:
                couponTitleVO.setTitle(coupon.getDiscount() + "折优惠");
                couponTitleVO.setMoney(coupon.getDiscount() + "折");
                break;
            case 4:
                couponTitleVO.setTitle("最高折扣" + coupon.getMoneyReduce() + "元");
                couponTitleVO.setMoney(coupon.getDiscount() + "折");
                break;
            case 5:
                couponTitleVO.setTitle("最高折扣" + coupon.getMoneyReduce() + "元");
                couponTitleVO.setMoney(coupon.getDiscount() + "折");
                break;
            case 6:
                couponTitleVO.setTitle("最高折扣" + coupon.getMoneyReduce() + "元");
                couponTitleVO.setMoney(coupon.getDiscount() + "折");
                break;
            default:
                break;
        }
        return couponTitleVO;
    }
}
