package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店项目关联表 扩展表")
public class BeautyRelationsServicePara implements Serializable {


    private static final long serialVersionUID = 1L;
 
 
    @ApiModelProperty("门店ID")
    private Integer beautyId;
    

    @ApiModelProperty("类型（1=服务项目，2=商品）")
    private Byte type;

    @ApiModelProperty("状态 是否上架的 1:上架 2:下架 0:删除")
    private Byte serviceState;
    
     




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

    public Byte getServiceState() {
        return serviceState;
    }

    public void setServiceState(Byte serviceState) {
        this.serviceState = serviceState;
    }
}