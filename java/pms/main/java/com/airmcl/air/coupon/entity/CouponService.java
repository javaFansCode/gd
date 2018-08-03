package com.airmcl.air.coupon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="优惠券限制项目表")
public class CouponService implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("优惠券ID")
    private Integer couponId;

    @ApiModelProperty("项目ID")
    private Integer serviceId;

    @ApiModelProperty("项目名称")
    private String serviceName;

    @ApiModelProperty("使用情况 0删除，1正常")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}