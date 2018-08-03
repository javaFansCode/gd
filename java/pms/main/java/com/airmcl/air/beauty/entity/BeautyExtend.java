package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店扩展表")
public class BeautyExtend implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("搜索范围 米为单位 0表示不限")
    private Integer searchArea;

    @ApiModelProperty("管理者")
    private String master;

    @ApiModelProperty("图片ID")
    private Integer beautyDescPicId;

    @ApiModelProperty("美容院标签")
    private String beautyTag;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("门店客服电话")
    private String beautyTel;

    @ApiModelProperty("营业时间，如:(9:00-18:00)")
    private String openTime;

    @ApiModelProperty("环境")
    private String environment;

    @ApiModelProperty("规模")
    private String sizeAndStrength;

    @ApiModelProperty("美容院简介")
    private String beautyDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getSearchArea() {
        return searchArea;
    }

    public void setSearchArea(Integer searchArea) {
        this.searchArea = searchArea;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public Integer getBeautyDescPicId() {
        return beautyDescPicId;
    }

    public void setBeautyDescPicId(Integer beautyDescPicId) {
        this.beautyDescPicId = beautyDescPicId;
    }

    public String getBeautyTag() {
        return beautyTag;
    }

    public void setBeautyTag(String beautyTag) {
        this.beautyTag = beautyTag == null ? null : beautyTag.trim();
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public String getBeautyTel() {
        return beautyTel;
    }

    public void setBeautyTel(String beautyTel) {
        this.beautyTel = beautyTel == null ? null : beautyTel.trim();
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment == null ? null : environment.trim();
    }

    public String getSizeAndStrength() {
        return sizeAndStrength;
    }

    public void setSizeAndStrength(String sizeAndStrength) {
        this.sizeAndStrength = sizeAndStrength == null ? null : sizeAndStrength.trim();
    }

    public String getBeautyDesc() {
        return beautyDesc;
    }

    public void setBeautyDesc(String beautyDesc) {
        this.beautyDesc = beautyDesc == null ? null : beautyDesc.trim();
    }
}