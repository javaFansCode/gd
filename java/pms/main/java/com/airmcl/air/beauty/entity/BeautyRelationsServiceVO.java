package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店项目关联表 扩展表")
public class BeautyRelationsServiceVO implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("服务项目ID")
    private Integer serviceId;

    @ApiModelProperty("项目名称")
    private String serviceName;

    @ApiModelProperty("项目封面图")
    private String serviceCover;
    
    @ApiModelProperty("状态(0:删除 ,1:正常)")
    private Integer state;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("类型（1=服务项目，2=商品）")
    private Byte type;

    @ApiModelProperty("状态 是否上架的 1:上架 2:下架 0:删除")
    private Byte serviceState;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceCover() {
        return serviceCover;
    }

    public void setServiceCover(String serviceCover) {
        this.serviceCover = serviceCover == null ? null : serviceCover.trim();
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

    public Byte getServiceState() {
        return serviceState;
    }

    public void setServiceState(Byte serviceState) {
        this.serviceState = serviceState;
    }
}