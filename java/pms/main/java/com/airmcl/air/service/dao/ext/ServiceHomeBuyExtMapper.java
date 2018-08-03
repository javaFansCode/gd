package com.airmcl.air.service.dao.ext;

import com.airmcl.air.service.entity.ServiceHomeBuy;

public interface ServiceHomeBuyExtMapper {
	ServiceHomeBuy selectServiceHomeByServiceId(Integer serviceId);
}
