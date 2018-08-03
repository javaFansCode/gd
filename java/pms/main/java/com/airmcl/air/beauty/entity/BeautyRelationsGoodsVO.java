package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="v_mdd_api_beauty_relations_goods")
public class BeautyRelationsGoodsVO implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    private Integer goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("封面")
    private String goodsCover;
   
    @ApiModelProperty("状态(0:删除 ,1:正常)")
    private Integer state;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("类型（1=服务项目，2=商品）")
    private Byte type;

    @ApiModelProperty("1=正常，4=下架，0=删除")
    private Byte goodsState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover == null ? null : goodsCover.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

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