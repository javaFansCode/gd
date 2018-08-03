package com.airmcl.air.activitys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="活动触发优惠券表")
public class ActivitysCoupons implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("活动ID")
    private Integer activityId;

    @ApiModelProperty("优惠券ID")
    private Integer couponId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
}