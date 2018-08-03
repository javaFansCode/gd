package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="记录美容师做过的服务项目和获得的内耗值")
public class BeauticianIntf implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("美容师id")
    private Integer btId;

    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("做过的服务项目id")
    private Integer serviceId;

    @ApiModelProperty("获得的内耗值")
    private BigDecimal internalFriction;

    @ApiModelProperty("完成服务时间")
    private Integer createtime;

    @ApiModelProperty("完成次数")
    private Integer nums;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public BigDecimal getInternalFriction() {
        return internalFriction;
    }

    public void setInternalFriction(BigDecimal internalFriction) {
        this.internalFriction = internalFriction;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
}