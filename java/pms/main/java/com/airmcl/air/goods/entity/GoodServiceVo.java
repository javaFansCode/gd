package com.airmcl.air.goods.entity;

import java.io.Serializable;
import java.util.List;

import com.airmcl.air.service.entity.Service;

public class GoodServiceVo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 5038100600392600503L;
	private Goods goods;
    private List<Service> services;
    private List<GoodsRelations> goodsRelations;
    
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	public List<GoodsRelations> getGoodsRelations() {
		return goodsRelations;
	}
	public void setGoodsRelations(List<GoodsRelations> goodsRelations) {
		this.goodsRelations = goodsRelations;
	}
    
    
}
