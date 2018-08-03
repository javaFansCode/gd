package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="技师操作记录表")
public class BeauticianOperation implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("操作(1:增加,2:修改,3:删除)")
    private Byte operate;

    @ApiModelProperty("操作者类型(1:后台,2:管理端,3:总店)")
    private Byte operateType;

    @ApiModelProperty("操作者ID")
    private Integer operateId;

    @ApiModelProperty("删除时间")
    private Integer createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Byte getOperate() {
        return operate;
    }

    public void setOperate(Byte operate) {
        this.operate = operate;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }
}