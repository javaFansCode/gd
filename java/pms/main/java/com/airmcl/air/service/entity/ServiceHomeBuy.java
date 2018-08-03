package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="项目限购控制表")
public class ServiceHomeBuy implements Serializable {
    @ApiModelProperty("id值")
    private Integer id;

    @ApiModelProperty("限购服务")
    private Integer serviceId;

    @ApiModelProperty("是否限购(1:关闭,2:开启)")
    private Byte isPurchase;

    @ApiModelProperty("限购次数")
    private Integer purchaseTotal;

    @ApiModelProperty("开始时间")
    private Integer starttime;

    @ApiModelProperty("结束时间")
    private Integer endtime;

    @ApiModelProperty("总次数")
    private Integer total;

    @ApiModelProperty("剩余次数")
    private Integer nums;

    @ApiModelProperty("状态  1正常，0删除")
    private Byte state;

    @ApiModelProperty("管理员ID")
    private Integer adminId;

    @ApiModelProperty("设置时间")
    private Integer createtime;

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

    public Byte getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Byte isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Integer getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Integer purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }
}