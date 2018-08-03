package com.airmcl.air.beautician.dao.ext;

import java.util.List;
import java.util.Map;

import com.airmcl.air.beautician.out.BeauitcianRelationService;

public interface BeauticianRelationsExtMapper {

	List<BeauitcianRelationService> findServiceByBeauticianId(Map<String, Object> para);
	
}
