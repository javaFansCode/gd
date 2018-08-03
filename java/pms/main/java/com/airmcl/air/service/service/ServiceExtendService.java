package com.airmcl.air.service.service;

import com.airmcl.air.service.entity.ServiceExtend;
import com.airmcl.air.service.entity.ServiceExtendExample;
import com.els.base.core.service.BaseService;

public interface ServiceExtendService extends BaseService<ServiceExtend, ServiceExtendExample, Integer> {
	/**
	 * 
	 * @param serviceId 通过服务主表ID查询扩展表
	 * @return
	 */
	ServiceExtend queryServiceExtendByServiceId(Integer serviceId);
}