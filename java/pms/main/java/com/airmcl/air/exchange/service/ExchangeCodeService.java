package com.airmcl.air.exchange.service;

import com.airmcl.air.exchange.entity.ExchangeCode;
import com.airmcl.air.exchange.entity.ExchangeCodeExample;
import com.els.base.core.service.BaseService;

public interface ExchangeCodeService extends BaseService<ExchangeCode, ExchangeCodeExample, Integer> {
	/**
	 * 级联修改兑换码列表状态
	 * @param id
	 * @param state
	 * @return 受影响的条数
	 * @throws RuntimeException
	 */
	int updateExchangeCodeById(Integer id,byte state)throws RuntimeException;
}