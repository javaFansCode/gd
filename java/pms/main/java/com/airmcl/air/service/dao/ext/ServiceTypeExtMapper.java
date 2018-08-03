package com.airmcl.air.service.dao.ext;

import java.util.List;

import com.airmcl.air.service.entity.ServiceType;

public interface ServiceTypeExtMapper {
    /**
     * 查询所有可用的服务类型
     * @return
     */
	List<ServiceType> selectServiceTypes();
}
