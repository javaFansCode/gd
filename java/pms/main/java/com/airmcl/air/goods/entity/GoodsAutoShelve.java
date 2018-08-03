package com.airmcl.air.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="商品自动上下架")
public class GoodsAutoShelve implements Serializable {
    @ApiModelProperty("id值")
    private Integer id;

    @ApiModelProperty("限购商品")
    private Integer goodsId;

    @ApiModelProperty("上架时间")
    private Integer uppertime;

    @ApiModelProperty("下架时间")
    private Integer lowertime;

    @ApiModelProperty("状态 2关闭 1正常")
    private Byte state;

    @ApiModelProperty("管理员ID")
    private Integer adminId;

    @ApiModelProperty("修改时间")
    private Integer updatetime;

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

    public Integer getUppertime() {
        return uppertime;
    }

    public void setUppertime(Integer uppertime) {
        this.uppertime = uppertime;
    }

    public Integer getLowertime() {
        return lowertime;
    }

    public void setLowertime(Integer lowertime) {
        this.lowertime = lowertime;
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

    public Integer getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Integer updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }
}