package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="门店类型信息表")
public class ServiceType implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("项目类型名称")
    private String name;

    @ApiModelProperty("排序  越大越前")
    private Integer sort;

    @ApiModelProperty("状态(1:可用,2:禁用,0删除)")
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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