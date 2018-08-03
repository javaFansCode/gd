package com.airmcl.air.service.entity;

import java.io.Serializable;

public class ServicePackage implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2798506137940034074L;
	private Integer id;
    private Integer packageId;
    private Integer serviceId;
    private Integer beautyId;
    private Integer serviceTotal;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getBeautyId() {
		return beautyId;
	}
	public void setBeautyId(Integer beautyId) {
		this.beautyId = beautyId;
	}
	public Integer getServiceTotal() {
		return serviceTotal;
	}
	public void setServiceTotal(Integer serviceTotal) {
		this.serviceTotal = serviceTotal;
	}
    
    
    
}
