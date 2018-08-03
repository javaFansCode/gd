package com.airmcl.air.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="banner图")
public class Banner implements Serializable {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("省份id")
    private Integer province_id;

    @ApiModelProperty("城市id")
    private Integer city_id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("标签")
    private String tag;

    @ApiModelProperty("是否是链接(1:是,2:不是)")
    private Byte islink;

    @ApiModelProperty("地址链接")
    private String url;

    @ApiModelProperty("项目Id(0:没有对应项目)")
    private Integer service_id;

    @ApiModelProperty("商品类型(goods : 卡券类 service :项目)")
    private String service_type;

    @ApiModelProperty("排序(越大越前)")
    private Integer sort;

    @ApiModelProperty("状态(1:正常,2:禁用,0:删除)")
    private Byte state;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("简介")
    private String description;
    
    @ApiModelProperty("banner图片")
    private String bannerImage;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public Byte getIslink() {
        return islink;
    }

    public void setIslink(Byte islink) {
        this.islink = islink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}