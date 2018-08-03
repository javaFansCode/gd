package com.airmcl.air.goods.entity;

import java.io.Serializable;

public class GoodsAutoShelveVo implements Serializable {
	private static final long serialVersionUID = 34271687874939372L;
	private GoodsAutoShelve goodsAutoShelve;
	private String goodsName;
	private Integer goodsId;
	public GoodsAutoShelve getGoodsAutoShelve() {
		return goodsAutoShelve;
	}
	public void setGoodsAutoShelve(GoodsAutoShelve goodsAutoShelve) {
		this.goodsAutoShelve = goodsAutoShelve;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	
}
