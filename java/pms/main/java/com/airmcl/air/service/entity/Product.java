package com.airmcl.air.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="产品表")
public class Product implements Serializable {
    private Integer id;

    @ApiModelProperty("行业类型(1:美容,2:美业)")
    private Byte type;

    @ApiModelProperty("门店细分（关联表industry）industryID(废弃)")
    private Byte industryType;

    @ApiModelProperty("图片名")
    private String imgUrl;

    @ApiModelProperty("产品描述")
    private String title;

    @ApiModelProperty("标题_拼音")
    private String titlePhonetic;

    @ApiModelProperty("产品功效")
    private String effect;

    @ApiModelProperty("产品成分")
    private String contain;

    @ApiModelProperty("适用人群")
    private String peopleUse;

    @ApiModelProperty("产品状态  1：正常    0：删除")
    private Byte state;

    @ApiModelProperty("添加时间")
    private Integer createtime;

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

    public Byte getIndustryType() {
        return industryType;
    }

    public void setIndustryType(Byte industryType) {
        this.industryType = industryType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitlePhonetic() {
        return titlePhonetic;
    }

    public void setTitlePhonetic(String titlePhonetic) {
        this.titlePhonetic = titlePhonetic == null ? null : titlePhonetic.trim();
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect == null ? null : effect.trim();
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain == null ? null : contain.trim();
    }

    public String getPeopleUse() {
        return peopleUse;
    }

    public void setPeopleUse(String peopleUse) {
        this.peopleUse = peopleUse == null ? null : peopleUse.trim();
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