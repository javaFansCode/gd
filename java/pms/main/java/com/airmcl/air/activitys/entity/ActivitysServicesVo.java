package com.airmcl.air.activitys.entity;

import java.io.Serializable;

public class ActivitysServicesVo implements Serializable {
	
	private static final long serialVersionUID = 9009592869998596269L;
	private Integer id;
	private Byte state;
	private Integer serviceId;
	private String servceName;
	private Integer activityId;
	
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

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

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServceName() {
		return servceName;
	}

	public void setServceName(String servceName) {
		this.servceName = servceName;
	}

}
