package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="美容师职称表")
public class JobTitle implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("职称名")
    private String title;

    @ApiModelProperty("职称状态  1：正常  0：已删除")
    private Byte state;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("等级")
    private Byte level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }
}