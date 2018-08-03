package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="项目限购修改记录表")
public class ServicesHomeBuyRecord implements Serializable {
    private Integer id;

    @ApiModelProperty("项目ID")
    private Integer serviceId;

    @ApiModelProperty("管理员ID")
    private Integer adminId;

    @ApiModelProperty("是否限购(1:关闭,2:开启)")
    private Byte isPurchase;

    @ApiModelProperty("添加时间")
    private Integer createtime;

    @ApiModelProperty("修改总次数")
    private Integer total;

    @ApiModelProperty("修改限购次数")
    private Integer purchaseTotal;

    @ApiModelProperty("修改类型")
    private String type;

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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Byte getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Byte isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Integer purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}