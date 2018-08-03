package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店分润表")
public class BeautyProfitPara implements Serializable {
 

    @ApiModelProperty("门店id")
    private Integer beautyId;

    @ApiModelProperty("1=门店收益方，2=门店直推官总，3=门店间推官总，4=运营中心主席")
    private Byte type;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("id")
    private String openId;

    @ApiModelProperty("名称")
    private String name;

 
    private static final long serialVersionUID = 1L;
 
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

 
}