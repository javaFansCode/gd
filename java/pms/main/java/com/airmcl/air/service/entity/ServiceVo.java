package com.airmcl.air.service.entity;

import java.io.Serializable;
import java.util.List;

public class ServiceVo implements Serializable {

	private static final long serialVersionUID = -7609305699316069921L;
	
	private ServiceExtend serviceExtend;
	
	private Service service;
	
	private List<ServiceType> serviceTypes;
	
	private List<Service> allSingleService;
	
	private List<ServicePackage> allSelectService;
	
	

	public List<Service> getAllSingleService() {
		return allSingleService;
	}

	public void setAllSingleService(List<Service> allSingleService) {
		this.allSingleService = allSingleService;
	}

	 

	public List<ServicePackage> getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(List<ServicePackage> allSelectService) {
		this.allSelectService = allSelectService;
	}

	public ServiceExtend getServiceExtend() {
		return serviceExtend;
	}

	public void setServiceExtend(ServiceExtend serviceExtend) {
		this.serviceExtend = serviceExtend;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<ServiceType> getServiceTypes() {
		return serviceTypes;
	}

	public void setServiceTypes(List<ServiceType> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}

	
}
