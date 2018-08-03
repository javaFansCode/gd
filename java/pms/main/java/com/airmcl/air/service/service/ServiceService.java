package com.airmcl.air.service.service;

import java.util.List;

import com.airmcl.air.service.entity.Service;
import com.airmcl.air.service.entity.ServiceCity;
import com.airmcl.air.service.entity.ServiceExample;
import com.airmcl.air.service.entity.ServiceIdNameCover;
import com.airmcl.air.service.entity.ServicePackage;
import com.airmcl.air.service.entity.ServiceVo;
import com.els.base.core.service.BaseService;

public interface ServiceService extends BaseService<Service, ServiceExample, Integer> {
	
	/**
	 * 修改服务项目并且修改服务项目关联的门店信息表
	 * @param service 服务信息
	 * @return 
	 * @throws RuntimeException
	 */
	int updateService(Service service)throws RuntimeException;
	
	List<ServiceIdNameCover> queryServiceInfo(List<Integer>ids);
	
	int saveServicePackage(List<ServicePackage> servicePackages);
	List<ServicePackage> queryServicePackageByServiceId(Integer serviceId);
	int modifyServicePackage(ServicePackage servicePackage);
	/**
	 * 查询单个项目
	 * @return
	 */
	List<Service> querySingleService();
	
	int delAllServicePackage(Integer serviceId);
	/**
	 * 添加服务项目主管理详情
	 * @param serviceVo
	 * @return
	 * @throws Exception
	 */
	boolean saveServiceDetail(ServiceVo serviceVo)throws RuntimeException;
	/**
	 * 修改服务项目主管理详情
	 * @param serviceVo
	 * @return
	 * @throws Exception
	 */
    boolean modifyServiceDetail(ServiceVo serviceVo,Service oldService)throws RuntimeException;
    /**
     * 修改城市价格
     * @param addCitys
     * @param updateCitys
     * @return
     * @throws Exception
     */
    boolean modifyServiceCities(List<ServiceCity> addCitys,List<ServiceCity> updateCitys)throws RuntimeException;
}