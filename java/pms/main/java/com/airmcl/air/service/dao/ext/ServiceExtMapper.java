package com.airmcl.air.service.dao.ext;

import java.util.List;

import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.entity.ServiceIdNameCover;

public interface ServiceExtMapper {
	
	List<ServiceIdNameCover> selectServiceIdNameCoverByServiceIds(List<Integer>ids);
    List<Service> selectAllSingleService();
    List<Service> selectAllSingleAndTypeOneService();
}
