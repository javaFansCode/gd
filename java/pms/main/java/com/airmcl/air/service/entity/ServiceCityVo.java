package com.airmcl.air.service.entity;

import java.io.Serializable;
import java.util.List;

public class ServiceCityVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 464966394943908845L;
	private List<ServiceCity> serviceCities;
	private String serviceName;
	private Integer serviceId;

	public List<ServiceCity> getServiceCities() {
		return serviceCities;
	}

	public void setServiceCities(List<ServiceCity> serviceCities) {
		this.serviceCities = serviceCities;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

}
