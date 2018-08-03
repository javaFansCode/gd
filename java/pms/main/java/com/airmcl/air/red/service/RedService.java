package com.airmcl.air.red.service;

import com.airmcl.air.red.entity.Red;
import com.airmcl.air.red.entity.RedExample;
import com.airmcl.air.red.entity.RedVo;
import com.els.base.core.service.BaseService;

public interface RedService extends BaseService<Red, RedExample, Integer> {
	/**
	 * 修改红包的状态
	 * @param red
	 * @return
	 */
	boolean editRedStateByRed(Red red)throws RuntimeException;
	/**
	 * 修改红包详情
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean modifyRedDetailInfo(RedVo vo)throws RuntimeException;
	/**
	 * 根据红包id，查询红包详情
	 * @param redId
	 * @return
	 */
	RedVo queryRedDetailByRedId(Integer redId);
	/**
	 * 保存红包详情
	 * @param redVo
	 * @return
	 * @throws RuntimeException
	 */
	boolean addRedDetailInfo(RedVo redVo)throws RuntimeException;
}