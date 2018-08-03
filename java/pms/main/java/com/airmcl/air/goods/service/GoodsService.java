package com.airmcl.air.goods.service;

import java.util.List;

import com.airmcl.air.goods.entity.Goods;
import com.airmcl.air.goods.entity.GoodsAutoShelve;
import com.airmcl.air.goods.entity.GoodsExample;
import com.airmcl.air.goods.entity.GoodsExtend;
import com.airmcl.air.goods.entity.GoodsHomeBuy;
import com.airmcl.air.goods.entity.GoodsHomeBuyRecord;
import com.airmcl.air.goods.entity.GoodsHomeBuyVo;
import com.airmcl.air.goods.entity.GoodsRelations;
import com.airmcl.air.goods.entity.GoodsVo;
import com.airmcl.air.service.entity.Service;
import com.els.base.core.service.BaseService;

public interface GoodsService extends BaseService<Goods, GoodsExample, Integer> {
	GoodsExtend queryGoodsExtendByGoodsId(Integer goodId);
	int addGoodsAndGoodsExtend(GoodsVo vo)throws RuntimeException;
	int modifyGoodsAndGoodsExtend(GoodsVo vo)throws RuntimeException;
	GoodsAutoShelve queryGoodsAutoShelveByGoodsId(Integer goodId);
	int addGoodsAutoShelve(GoodsAutoShelve goodsAutoShelve);
	GoodsHomeBuy queryGoodsHomeBuyByGoodsId(Integer goodId);
	int modifyGoodsHomeBuyAndGoodsHomeBuyRecord(GoodsHomeBuyVo vo)throws RuntimeException;
	GoodsHomeBuyRecord queryGoodsHomeBuyRecord(Integer goodId);
	List<Service> queryAllSingleTypeOneService();
	List<GoodsRelations> queryGoodsRelationsByGoodsId(Integer goodsId);
	boolean modifyGoodsRelations(List<GoodsRelations> godsRelations,Integer goodsId)throws RuntimeException;
	/**
	 * 上下架或者删除商品时，级联修改门店和服务的关系状态
	 * @param goodId 商品的id
	 * @param state 商品的状态
	 * @return 受影响的行数
	 * @throws RuntimeException
	 */
	int modifyGoodsDetailState(Integer goodId,Byte state)throws RuntimeException;
}