package com.airmcl.air.coupon.enter;

import java.io.Serializable;

public class EnterUserCouponParams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer couponId;	//优惠券Id
	private String userPhone;//用户电话号码  来自用户中心
	private String nickName; //昵称	 来自用户中心
	private String couponTitle;		//优惠券名称 
	private String startcreatetime; //查询条件 --创建开始时间
	private String endcreatetime;	//创建结束时间
	private String userId; //用于用户中心返回的ucopenId 然后去本地系统查信息
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCouponTitle() {
		return couponTitle;
	}
	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getStartcreatetime() {
		return startcreatetime;
	}
	public void setStartcreatetime(String startcreatetime) {
		this.startcreatetime = startcreatetime;
	}
	public String getEndcreatetime() {
		return endcreatetime;
	}
	public void setEndcreatetime(String endcreatetime) {
		this.endcreatetime = endcreatetime;
	}

}
