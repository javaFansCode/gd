package com.airmcl.air.service.entity;

import java.io.Serializable;

public class ServiceHomeBuyVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7298109065204943803L;
	private ServiceHomeBuy serviceHomeBuy;
    private Service service;
    
	public ServiceHomeBuy getServiceHomeBuy() {
		return serviceHomeBuy;
	}
	public void setServiceHomeBuy(ServiceHomeBuy serviceHomeBuy) {
		this.serviceHomeBuy = serviceHomeBuy;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
}
