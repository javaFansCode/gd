package com.airmcl.air.service.service;

import java.util.List;

import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceCityExample;
import com.els.base.core.service.BaseService;

public interface ServiceCityService extends BaseService<ServiceCity, ServiceCityExample, Integer> {

	List<ServiceCity> queryOpenReserveCity();
	
	List<ServiceCity> queryOpenReserveCityByServiceId(Integer serviceId);
	
    void addAllServiceCity(List<ServiceCity> serviceCities ) throws RuntimeException;
}