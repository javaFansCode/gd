package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@ApiModel(value="门店主表")
public class Beauty implements Serializable {
    @ApiModelProperty("门店ID")
    private Integer id;

    @ApiModelProperty("门店封面图")
    private String beautyCover;

    @ApiModelProperty("门店联系人号码")
    private String mobile;

    @ApiModelProperty("美容院名称")
    private String beautyName;

    @ApiModelProperty("门店名称拼音")
    private String beautyNamePhonetic;

    @ApiModelProperty("行业类型(1:美容,2:美业)")
    private Byte type;

    @ApiModelProperty("门店细分（关联表industry）industryID(此字段已经废弃)")
    private Byte industryType;

    @ApiModelProperty("省份")
    private Integer province;

    @ApiModelProperty("城市")
    private Integer city;

    @ApiModelProperty("县区")
    private Integer district;

    @ApiModelProperty("街道")
    private Integer street;

    @ApiModelProperty("服务次数")
    private Integer serviceTotal;

    @ApiModelProperty("被评论次数")
    private Integer commentTotal;

    @ApiModelProperty("专业分数")
    private Integer professionalScore;

    @ApiModelProperty("服务总得分")
    private Integer punctualityScore;

    @ApiModelProperty("效果总得分")
    private Integer communicateScore;

    @ApiModelProperty("门店评分")
    private Short storeScore;

    @ApiModelProperty("服务时间")
    private String serviceTime;

    @ApiModelProperty("经度")
    private String longitude;

    @ApiModelProperty("维度")
    private String latitude;

    @ApiModelProperty("排序(越小排越前)")
    private Short sort;

    @ApiModelProperty("状态 1:正常 0:删除 4:下架")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeautyCover() {
        return beautyCover;
    }

    public void setBeautyCover(String beautyCover) {
        this.beautyCover = beautyCover == null ? null : beautyCover.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getBeautyName() {
        return beautyName;
    }

    public void setBeautyName(String beautyName) {
        this.beautyName = beautyName == null ? null : beautyName.trim();
    }

    public String getBeautyNamePhonetic() {
        return beautyNamePhonetic;
    }

    public void setBeautyNamePhonetic(String beautyNamePhonetic) {
        this.beautyNamePhonetic = beautyNamePhonetic == null ? null : beautyNamePhonetic.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getIndustryType() {
        return industryType;
    }

    public void setIndustryType(Byte industryType) {
        this.industryType = industryType;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    public Integer getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(Integer serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Integer getProfessionalScore() {
        return professionalScore;
    }

    public void setProfessionalScore(Integer professionalScore) {
        this.professionalScore = professionalScore;
    }

    public Integer getPunctualityScore() {
        return punctualityScore;
    }

    public void setPunctualityScore(Integer punctualityScore) {
        this.punctualityScore = punctualityScore;
    }

    public Integer getCommunicateScore() {
        return communicateScore;
    }

    public void setCommunicateScore(Integer communicateScore) {
        this.communicateScore = communicateScore;
    }

    public Short getStoreScore() {
        return storeScore;
    }

    public void setStoreScore(Short storeScore) {
        this.storeScore = storeScore;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime == null ? null : serviceTime.trim();
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

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}