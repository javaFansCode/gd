package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="服务项目美容师对应表")
public class BeauticianService implements Serializable {
    private Integer id;

    @ApiModelProperty("服务项目id")
    private Integer serviceId;

    @ApiModelProperty("美容院id")
    private Integer beautyId;

    @ApiModelProperty("美容师id")
    private Integer beauticianId;

    @ApiModelProperty("状态 0删除 1正常")
    private Byte status;

    @ApiModelProperty("添加时间")
    private Integer created;

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

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Integer getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(Integer beauticianId) {
        this.beauticianId = beauticianId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }
}