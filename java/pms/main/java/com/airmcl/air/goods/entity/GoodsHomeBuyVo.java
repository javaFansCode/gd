package com.airmcl.air.goods.entity;

import java.io.Serializable;

public class GoodsHomeBuyVo implements Serializable{
	private static final long serialVersionUID = 4540990391430256399L;
	private   GoodsHomeBuy goodsHomeBuy;
	private   Integer goodsId;
	private   String  goodsName;
	private   GoodsHomeBuyRecord goodsHomeBuyRecord;
	
	public GoodsHomeBuy getGoodsHomeBuy() {
		return goodsHomeBuy;
	}
	public void setGoodsHomeBuy(GoodsHomeBuy goodsHomeBuy) {
		this.goodsHomeBuy = goodsHomeBuy;
	}
	 
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public GoodsHomeBuyRecord getGoodsHomeBuyRecord() {
		return goodsHomeBuyRecord;
	}
	public void setGoodsHomeBuyRecord(GoodsHomeBuyRecord goodsHomeBuyRecord) {
		this.goodsHomeBuyRecord = goodsHomeBuyRecord;
	}
	
}
