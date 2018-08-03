package com.airmcl.air.beautician.service;

import java.util.List;
import java.util.Map;

import com.airmcl.air.beautician.enter.BeauticianServiceEnterParams;
import com.airmcl.air.beautician.entity.BeauticianRelations;
import com.airmcl.air.beautician.entity.BeauticianRelationsExample;
import com.airmcl.air.beautician.out.BeauticianRelationsServiceOut;
import com.els.base.core.service.BaseService;

public interface BeauticianRelationsService extends BaseService<BeauticianRelations, BeauticianRelationsExample, Integer> {
    void updateState(int[] ids, Integer state);

    /**
     * 根据技师id查询技师所关联的服务项目
     * @param beauticianId
     * @return
     */
	List<BeauticianRelationsServiceOut> findServiceByBeauticianId(Map<String, Object> para);

	/**
	 * 美容师关联服务项目
	 * @param enterParams
	 */
	void insertRelationShip(BeauticianServiceEnterParams enterParams);
	
}