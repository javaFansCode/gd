package com.airmcl.air.beauty.service;

import java.util.List;

import com.airmcl.air.beauty.entity.Beauty;
import com.airmcl.air.beauty.entity.BeautyExample;
import com.airmcl.air.beauty.entity.EnterBeautyVO;
import com.els.base.core.service.BaseService;

public interface BeautyService extends BaseService<Beauty, BeautyExample, Integer> {
	 /**
	  * 保存门店详细信息
	  * @param enterBeautyVO
	  * @throws RuntimeException
	  */
     void addBeautyDetail(EnterBeautyVO enterBeautyVO,final Integer createtime)throws RuntimeException;

     /**
      * 根据id数组查询对应门店详情
      * @param ids
      * @return
      */
	List<Beauty> selectDetilByIds(String id);
	/**
	 * 编辑美容院信息
	 * @param enterBeautyVO
	 * @throws RuntimeException
	 */
	void updateBeautyDetail(EnterBeautyVO enterBeautyVO)throws RuntimeException;
}