package com.airmcl.air.service.service;

import java.util.List;

import com.airmcl.air.service.entity.ServiceTypeEquipment;
import com.airmcl.air.service.entity.ServiceTypeEquipmentExample;
import com.els.base.core.service.BaseService;

public interface ServiceTypeEquipmentService extends BaseService<ServiceTypeEquipment, ServiceTypeEquipmentExample, Integer> {
	 /**
	  * 通过服务类型ID获取服务类型和服务设备的关联信息
	  * @param serviceTypeId
	  * @return
	  */
	 List<ServiceTypeEquipment> queryServiceTypeEquipmentsByServiceTypeId(Integer serviceTypeId);
     /**
      * 批量保存设备项目
      * @param serviceTypeEquipments
      */
	 void updateServiceTypeEquipments(List<ServiceTypeEquipment> serviceTypeEquipments,//
			 
	 List<ServiceTypeEquipment> delServiceTypeEquipments)throws RuntimeException;
}