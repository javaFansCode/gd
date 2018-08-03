package com.airmcl.air.beauty.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnterBeautyVO implements Serializable{
     /**
	 * 
	 */
	private static final long serialVersionUID = -4073444937407952253L;
	private Beauty beauty;
    private List<BeautyProfit> beautyProfitList = new ArrayList<>();
    private BeautyExtend beautyExtend;
    
	public Beauty getBeauty() {
		return beauty;
	}
	public void setBeauty(Beauty beauty) {
		this.beauty = beauty;
	}
	public List<BeautyProfit> getBeautyProfitList() {
		return beautyProfitList;
	}
	public void setBeautyProfitList(List<BeautyProfit> beautyProfitList) {
		this.beautyProfitList = beautyProfitList;
	}
	public BeautyExtend getBeautyExtend() {
		return beautyExtend;
	}
	public void setBeautyExtend(BeautyExtend beautyExtend) {
		this.beautyExtend = beautyExtend;
	}
     
}
