package com.airmcl.air.activitys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="mdd_api_activitys_beauty")
public class ActivitysBeauty implements Serializable {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("活动的id")
    private Integer activityId;

    @ApiModelProperty("美容院的id")
    private Integer btId;

    @ApiModelProperty("是否关联 1：是 0：否")
    private Byte state;

    @ApiModelProperty("数据建立的时间")
    private Integer createtime;

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

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }
}