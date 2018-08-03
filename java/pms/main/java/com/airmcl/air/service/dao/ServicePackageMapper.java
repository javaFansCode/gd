package com.airmcl.air.service.dao;

import java.util.List;

import com.airmcl.air.service.entity.ServicePackage;

public interface ServicePackageMapper {
   int insertIntoServicePackage(ServicePackage servicePackages);
   int updateServicePackage(ServicePackage servicePackages);
   List<ServicePackage> selectAllServicePackagesByServiceId(Integer serviceId);
   int delServicePackageByPackageId(Integer serviceId);
   int insertBatch( List<ServicePackage> pakages);
}
