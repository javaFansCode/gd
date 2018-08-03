package com.airmcl.air.service.dao.ext;

import java.util.List;

import com.airmcl.air.service.entity.ServiceCity;

public interface ServiceCityExtMapper {
	
   List<ServiceCity> selectOpenCity();
   
   List<ServiceCity> selectOpenCityByServiceId(Integer serviceId);
}
