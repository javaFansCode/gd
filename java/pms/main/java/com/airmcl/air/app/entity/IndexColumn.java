package com.airmcl.air.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="首页栏目管理")
public class IndexColumn implements Serializable {
    private Integer id;

    @ApiModelProperty("类型 1=栏目管理，2=推荐项目")
    private Byte type;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("图片")
    private String image;

    @ApiModelProperty("省份id")
    private Integer province_id;

    @ApiModelProperty("城市id")
    private Integer city_id;

    @ApiModelProperty("服务项目id")
    private Integer service_id;

    @ApiModelProperty("商品类型(goods : 卡券类  service:项目)")
    private String service_type;

    @ApiModelProperty("修改时间")
    private Integer updatetime;

    @ApiModelProperty("添加时间")
    private Integer createtime;

    @ApiModelProperty("排序越大越前")
    private Integer sort;

    @ApiModelProperty("0=删除，1=正常，2=停用")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type == null ? null : service_type.trim();
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
}