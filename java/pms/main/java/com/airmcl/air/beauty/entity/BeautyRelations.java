package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店项目关联表")
public class BeautyRelations implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("项目ID")
    private Integer relationId;

    @ApiModelProperty("类型（1=服务项目，2=商品）")
    private Byte type;

    @ApiModelProperty("操作者类型(1:后台 )")
    private Byte operateType;

    @ApiModelProperty("操作者ID")
    private Integer operateId;

    @ApiModelProperty("状态(0:删除关联 ,1:已关联)")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

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

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}