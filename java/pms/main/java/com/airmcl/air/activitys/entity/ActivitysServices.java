package com.airmcl.air.activitys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="项目触发活动表")
public class ActivitysServices implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("活动ID")
    private Integer activityId;

    @ApiModelProperty("项目ID")
    private Integer serviceId;

    @ApiModelProperty("是否关联 1：是 0：否")
    private Byte state;

    @ApiModelProperty("创建时间")
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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