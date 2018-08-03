package com.airmcl.air.service.service;

import com.airmcl.air.service.entity.ServiceHomeBuy;
import com.airmcl.air.service.entity.ServiceHomeBuyExample;
import com.els.base.core.service.BaseService;

public interface ServiceHomeBuyService extends BaseService<ServiceHomeBuy, ServiceHomeBuyExample, Integer> {
    //通过服务项目的ID获取服务项目的限购
	ServiceHomeBuy queryObjByserviceId(Integer serviceId);
	/**
	 * 修改限购
	 * @param serviceHomeBuy
	 * @return
	 * @throws RuntimeException
	 */
	int modifyServiceHomeBuyAndServiceHomeBuyRecord(ServiceHomeBuy serviceHomeBuy)throws RuntimeException;
}