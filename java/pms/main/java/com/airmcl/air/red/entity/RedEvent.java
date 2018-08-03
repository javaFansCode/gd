package com.airmcl.air.red.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="红包触发事件表")
public class RedEvent implements Serializable {
    private Integer id;

    private Integer redId;

    @ApiModelProperty("1 支付奖励邀请人；2注册奖励邀请人；3支付奖励被邀请人；4注册奖励被邀请人；5确认有效手机号后奖励邀请人；6确认有效手机号后奖励被邀请人")
    private Byte type;

    @ApiModelProperty("状态0删除 1开启")
    private Byte state;

    private Integer createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRedId() {
        return redId;
    }

    public void setRedId(Integer redId) {
        this.redId = redId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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