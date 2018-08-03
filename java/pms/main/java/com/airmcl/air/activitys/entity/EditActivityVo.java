package com.airmcl.air.activitys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EditActivityVo implements Serializable{
	private static final long serialVersionUID = 6640491684733994335L;

	private Activitys activitys;
	private List<ActivitysCouponsVo> activitysCouponsList= new ArrayList<>();;
	private List<ActivitysServicesVo> activitysServicesList= new ArrayList<>();;
	private List<ActivitysBeautyVo> activitysBeautyVoList= new ArrayList<>();;
	
	public Activitys getActivitys() {
		return activitys;
	}
	public void setActivitys(Activitys activitys) {
		this.activitys = activitys;
	}
	public List<ActivitysCouponsVo> getActivitysCouponsList() {
		return activitysCouponsList;
	}
	public void setActivitysCouponsList(List<ActivitysCouponsVo> activitysCouponsList) {
		this.activitysCouponsList = activitysCouponsList;
	}
	public List<ActivitysServicesVo> getActivitysServicesList() {
		return activitysServicesList;
	}
	public void setActivitysServicesList(List<ActivitysServicesVo> activitysServicesList) {
		this.activitysServicesList = activitysServicesList;
	}
	public List<ActivitysBeautyVo> getActivitysBeautyVoList() {
		return activitysBeautyVoList;
	}
	public void setActivitysBeautyVoList(List<ActivitysBeautyVo> activitysBeautyVoList) {
		this.activitysBeautyVoList = activitysBeautyVoList;
	}
	 
	
	
}
