package com.airmcl.air.service.entity;

import java.util.List;

/*
 * 关联设备VO类
 * xfl add 
 */
public class ServiceTypeEquipmentVo {
	private static final long serialVersionUID = 2520550826950177882L;
	private String serviceTypeName;
	private List<ServiceTypeEquipment> equipments;
	public String getServiceTypeName() {
		return serviceTypeName;
	}
	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}
	public List<ServiceTypeEquipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<ServiceTypeEquipment> equipments) {
		this.equipments = equipments;
	}

	
}
