package com.airmcl.air.goods.entity;

import java.io.Serializable;

public class GoodsVo implements Serializable {

	private static final long serialVersionUID = -6477392071891382558L;
	private Goods goods;
	private GoodsExtend goodsExtend;
	
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public GoodsExtend getGoodsExtend() {
		return goodsExtend;
	}
	public void setGoodsExtend(GoodsExtend goodsExtend) {
		this.goodsExtend = goodsExtend;
	}
	
}
