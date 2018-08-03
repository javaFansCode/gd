package com.airmcl.air.activitys.entity;

import java.io.Serializable;
import java.util.List;

public class EnterActivitysVo implements Serializable {
	
	private static final long serialVersionUID = 7398930875509392218L;

	private Activitys activitys;
     
     private List<ActivitysCoupons> activitysCouponsList;
     
     private List<ActivitysServices> activitysServicesList;
     
     private List<ActivitysBeauty> activitysBeauticianList;

	public Activitys getActivitys() {
		return activitys;
	}

	public void setActivitys(Activitys activitys) {
		this.activitys = activitys;
	}

	public List<ActivitysCoupons> getActivitysCouponsList() {
		return activitysCouponsList;
	}

	public void setActivitysCouponsList(List<ActivitysCoupons> activitysCouponsList) {
		this.activitysCouponsList = activitysCouponsList;
	}

	public List<ActivitysServices> getActivitysServicesList() {
		return activitysServicesList;
	}

	public void setActivitysServicesList(List<ActivitysServices> activitysServicesList) {
		this.activitysServicesList = activitysServicesList;
	}

	public List<ActivitysBeauty> getActivitysBeauticianList() {
		return activitysBeauticianList;
	}

	public void setActivitysBeauticianList(List<ActivitysBeauty> activitysBeauticianList) {
		this.activitysBeauticianList = activitysBeauticianList;
	}
     
}
