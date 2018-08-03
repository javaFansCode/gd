package com.airmcl.air.area.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="服务开通城市表")
public class OpenCity implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("1=省，2=市，3=区,4=街道")
    private Byte level;

    @ApiModelProperty("越小越前")
    private Short sort;

    @ApiModelProperty("父级id")
    private Integer parent_id;

    @ApiModelProperty("地区id")
    private Integer area_id;

    @ApiModelProperty("地区父id")
    private Integer area_parent_id;

    @ApiModelProperty("是否开放预约1开放预约 2此城市所有美容师都不可以被预约")
    private Byte open_reserve;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("维度")
    private String latitude;

    @ApiModelProperty("0=删除，1=正常")
    private Byte state;

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

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public Integer getArea_parent_id() {
        return area_parent_id;
    }

    public void setArea_parent_id(Integer area_parent_id) {
        this.area_parent_id = area_parent_id;
    }

    public Byte getOpen_reserve() {
        return open_reserve;
    }

    public void setOpen_reserve(Byte open_reserve) {
        this.open_reserve = open_reserve;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}