package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="技师扩展表")
public class BeauticianExtend implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("技师标签(逗号分隔)")
    private String tag;

    @ApiModelProperty("职位(同时拥有多个职位用逗号隔开)")
    private String place;

    @ApiModelProperty("总收入")
    private BigDecimal income;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("美容师简介")
    private String btDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBtDesc() {
        return btDesc;
    }

    public void setBtDesc(String btDesc) {
        this.btDesc = btDesc == null ? null : btDesc.trim();
    }
}