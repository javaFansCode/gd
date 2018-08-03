package com.airmcl.air.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="商品限购控制表")
public class GoodsHomeBuy implements Serializable {
    @ApiModelProperty("id值")
    private Integer id;

    @ApiModelProperty("限购商品")
    private Integer goodsId;

    @ApiModelProperty("是否限购(1:关闭,2:开启)")
    private Byte isPurchase;

    @ApiModelProperty("限购次数")
    private Byte purchaseTotal;

    @ApiModelProperty("总次数")
    private Integer total;

    @ApiModelProperty("剩余次数")
    private Integer nums;

    @ApiModelProperty("开始时间")
    private Integer starttime;

    @ApiModelProperty("结束时间")
    private Integer endtime;

    @ApiModelProperty("状态 0删除 1正常")
    private Byte state;

    @ApiModelProperty("管理员ID")
    private Integer adminId;

    @ApiModelProperty("添加时间")
    private Integer createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Byte getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Byte isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Byte getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Byte purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
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