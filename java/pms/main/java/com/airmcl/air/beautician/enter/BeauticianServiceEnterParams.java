package com.airmcl.air.beautician.enter;

import java.io.Serializable;
import java.util.List;

public class BeauticianServiceEnterParams implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 技师id
	 */
	private int beauticianId;
	/**
	 * 门店id
	 */
	private int beautyId;
	
	private List<Integer> serviceId; //服务项目id  这个用于美容师关联服务项目 入参字段
	
	private int[] ids;
	
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public List<Integer> getServiceId() {
		return serviceId;
	}
	public void setServiceId(List<Integer> serviceId) {
		this.serviceId = serviceId;
	}
	public int getBeautyId() {
		return beautyId;
	}
	public void setBeautyId(int beautyId) {
		this.beautyId = beautyId;
	}
	public int getBeauticianId() {
		return beauticianId;
	}
	public void setBeauticianId(int beauticianId) {
		this.beauticianId = beauticianId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
