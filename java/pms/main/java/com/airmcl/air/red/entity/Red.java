package com.airmcl.air.red.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="分享红包表")
public class Red implements Serializable {
    private Integer id;

    @ApiModelProperty("城市ID(0:不限制城市)")
    private String city="0";

    @ApiModelProperty("门店ID(0:代表不限制门店)")
    private String beautyId;

    @ApiModelProperty("红包名")
    private String name;

    @ApiModelProperty("开始时间")
    private Integer starttime;

    @ApiModelProperty("结束时间")
    private Integer endtime;

    @ApiModelProperty("红包类型 1新用户红包 2老用户支付获得红包 3老用户完成获得红包 4.分享返券红包")
    private Byte type;

    @ApiModelProperty("分享页标题")
    private String shareTitle;

    @ApiModelProperty("分享页副标题")
    private String shareSubtitle;

    @ApiModelProperty("分享页图片路径")
    private String sharePicUrl;

    @ApiModelProperty("活动页")
    private String activityTitle;

    @ApiModelProperty("0:所有预约触发   1：在线预约触发   2：快速预约触发")
    private Byte triggerType;

    @ApiModelProperty("状态 0删除 1开启 2停用（可修改） 3停用（不可修改）")
    private Byte state;

    private Integer createtime;

    @ApiModelProperty("活动规则")
    private String activityRule;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(String beautyId) {
        this.beautyId = beautyId == null ? null : beautyId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getEndtime() {
        return endtime;
    }

    public void setEndtime(Integer endtime) {
        this.endtime = endtime;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle == null ? null : shareTitle.trim();
    }

    public String getShareSubtitle() {
        return shareSubtitle;
    }

    public void setShareSubtitle(String shareSubtitle) {
        this.shareSubtitle = shareSubtitle == null ? null : shareSubtitle.trim();
    }

    public String getSharePicUrl() {
        return sharePicUrl;
    }

    public void setSharePicUrl(String sharePicUrl) {
        this.sharePicUrl = sharePicUrl == null ? null : sharePicUrl.trim();
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public Byte getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Byte triggerType) {
        this.triggerType = triggerType;
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

    public String getActivityRule() {
        return activityRule;
    }

    public void setActivityRule(String activityRule) {
        this.activityRule = activityRule == null ? null : activityRule.trim();
    }
}