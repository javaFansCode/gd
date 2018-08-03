package com.airmcl.air.beauty.service;

import java.util.List;
import java.util.Map;

import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import com.airmcl.air.beauty.entity.BeautyRelationsGoodsVO;
import com.airmcl.air.beauty.entity.BeautyRelationsServiceVO;
import com.airmcl.air.beauty.entity.OutBeautyRelationsRecord;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

public interface BeautyRelationsService extends BaseService<BeautyRelations, BeautyRelationsExample, Integer> {
	/**
	 * 获取门店关联服务项目
	 */
	 List<BeautyRelationsServiceVO> selectServiceByBeautyId(Map<String, Object> para);

	 /**
	  * 根据id获取关联关系 
	  * @param id
	  * @return
	  */
	 BeautyRelations selectByPrimaryKey(Integer id);
		/**
		 * 获取门店关联商品
		 */
	public List<BeautyRelationsGoodsVO> selectGoodsByBeautyId(Map<String, Object> para);
	/**
	 * 获取门店关联项目记录
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageView<OutBeautyRelationsRecord> findBeautyRelationsRecord(int pageNo, int pageSize);
}