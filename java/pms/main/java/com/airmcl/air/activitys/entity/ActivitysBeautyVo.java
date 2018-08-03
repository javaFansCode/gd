package com.airmcl.air.activitys.entity;

import java.io.Serializable;

public class ActivitysBeautyVo implements Serializable {
	private static final long serialVersionUID = 5469688940667215768L;
	private Integer id;
	private Byte state;
	private Integer beautyId;
	private String beautyName;
	private Integer activityId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Byte getState() {
		return state;
	}
	public void setState(Byte state) {
		this.state = state;
	}
	public Integer getBeautyId() {
		return beautyId;
	}
	public void setBeautyId(Integer beautyId) {
		this.beautyId = beautyId;
	}
	public String getBeautyName() {
		return beautyName;
	}
	public void setBeautyName(String beautyName) {
		this.beautyName = beautyName;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	
}
