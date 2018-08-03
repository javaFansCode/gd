package com.airmcl.air.activitys.entity;

import java.io.Serializable;

public class ActivitysCouponsVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7104951956465279126L;
	private Integer id;
	private Integer couponId;
	private String  couponTitle;
	private Integer activityId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponTitle() {
		return couponTitle;
	}

	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

}
