package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店项目关联表 扩展表")
public class BeautyRelationsGoodsPara implements Serializable {


    private static final long serialVersionUID = 1L;
 
 
    @ApiModelProperty("门店ID")
    private Integer beautyId;
    

    @ApiModelProperty("类型（1=服务项目，2=商品）")
    private Byte type;

    @ApiModelProperty("状态  1=正常，4=下架，0=删除")
    private Byte goodsState;
    
     




    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Byte goodsState) {
        this.goodsState = goodsState;
    }
}