package com.airmcl.air.service.dao.ext;

import java.util.List;

import com.airmcl.air.service.entity.ServiceTypeEquipment;

public interface ServiceTypeEquipmentExtMapper {
	
    List<ServiceTypeEquipment> selectServiceTypeEquipmentsByServiceTypeId(Integer serviceTypeId);
}
