package com.airmcl.air.beauty.service;

import java.util.Map;

import com.airmcl.air.beauty.entity.BeautyProfit;
import com.airmcl.air.beauty.entity.BeautyProfitExample;
import com.els.base.core.service.BaseService;

public interface BeautyProfitService extends BaseService<BeautyProfit, BeautyProfitExample, Integer> {
	/***
	 * 更新店铺分润受益方状态
	 * @param para
	 */
    void updateBeautyProfitState(Map<String, Object> para);
}