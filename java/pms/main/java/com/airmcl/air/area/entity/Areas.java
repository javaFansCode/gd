package com.airmcl.air.area.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="三级联动地区表")
public class Areas implements Serializable {
    private Integer id;

    private String name;

    private Integer parent_id;

    @ApiModelProperty("1=省，2=市，3=区")
    private Byte level;

    @ApiModelProperty("是否开通 1=是 ，0=否")
    private Byte is_open;

    @ApiModelProperty("是否是港澳台(1:否,2:是)")
    private Byte is_outside;

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

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getIs_open() {
        return is_open;
    }

    public void setIs_open(Byte is_open) {
        this.is_open = is_open;
    }

    public Byte getIs_outside() {
        return is_outside;
    }

    public void setIs_outside(Byte is_outside) {
        this.is_outside = is_outside;
    }
}