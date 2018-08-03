package com.airmcl.air.service.entity;

import java.io.Serializable;

public class ServiceIdNameCover implements Serializable{
	private static final long serialVersionUID = 6865378640401149588L;
	private Integer id;
	private String  serviceName;
	private String  serviceCover;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceCover() {
		return serviceCover;
	}
	public void setServiceCover(String serviceCover) {
		this.serviceCover = serviceCover;
	}
	
     
}
