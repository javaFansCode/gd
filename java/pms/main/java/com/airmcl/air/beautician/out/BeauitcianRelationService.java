package com.airmcl.air.beautician.out;

import java.io.Serializable;

public class BeauitcianRelationService implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer serviceId;
	private Integer state ;
	private Integer beautyId;
	private Integer relationsId;
	
	public Integer getRelationsId() {
		return relationsId;
	}
	public void setRelationsId(Integer relationsId) {
		this.relationsId = relationsId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getBeautyId() {
		return beautyId;
	}
	public void setBeautyId(Integer beautyId) {
		this.beautyId = beautyId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
