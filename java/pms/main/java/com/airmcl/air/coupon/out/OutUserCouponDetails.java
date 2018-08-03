package com.airmcl.air.coupon.out;

import java.io.Serializable;

public class OutUserCouponDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer couponId ;
	private String couponTitle;
	private String city;
	private String beautyId;
	private String serviceId;
	private String useType;
    private String moneyMax;
    private String moneyReduce;
    
    private String isUse;
    private String createTime;
    private Integer expiresTime;
    private String userPhone;//用户电话号码  来自用户中心
	private String nickName; //昵称	 来自用户中心
	private Byte expiryType; //优惠券过期类型(1:无限期 ,2:指定日期 ,3:指定天数)',
	private String userOpenId;
	private Integer couponStartTime; //优惠券开始时间
	public Integer getCouponStartTime() {
		return couponStartTime;
	}
	public void setCouponStartTime(Integer couponStartTime) {
		this.couponStartTime = couponStartTime;
	}
	public String getUserOpenId() {
		return userOpenId;
	}
	public Byte getExpiryType() {
		return expiryType;
	}
	public void setExpiryType(Byte expiryType) {
		this.expiryType = expiryType;
	}
	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBeautyId() {
		return beautyId;
	}

	public void setBeautyId(String beautyId) {
		this.beautyId = beautyId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}

	public String getMoneyMax() {
		return moneyMax;
	}

	public void setMoneyMax(String moneyMax) {
		this.moneyMax = moneyMax;
	}

	public String getMoneyReduce() {
		return moneyReduce;
	}

	public void setMoneyReduce(String moneyReduce) {
		this.moneyReduce = moneyReduce;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getExpiresTime() {
		return expiresTime;
	}

	public void setExpiresTime(Integer expiresTime) {
		this.expiresTime = expiresTime;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
