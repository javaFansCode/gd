package com.airmcl.air.service.service;

import java.util.List;

import com.airmcl.air.service.entity.ServiceType;
import com.airmcl.air.service.entity.ServiceTypeExample;
import com.els.base.core.service.BaseService;

public interface ServiceTypeService extends BaseService<ServiceType, ServiceTypeExample, Integer> {
    /**
     * 查询所有服务项目类型
     * @return
     */
	List<ServiceType> queryAllServiceType();
}