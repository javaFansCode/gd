package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="技师主表")
public class Beautician implements Serializable {
    @ApiModelProperty("技师ID")
    private Integer id;

    @ApiModelProperty("技师光电中心id")
    private String openId;

    @ApiModelProperty("技师名称")
    private String name;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("密码")
    private String psw;

    @ApiModelProperty("技师头像")
    private String headpic;

    @ApiModelProperty("所属门店ID(0代表并无所属门店)")
    private Integer beautyId;

    @ApiModelProperty("职位类型(1:技师,2:门店管理)")
    private Byte careerType;

    @ApiModelProperty("专业总得分")
    private Integer professionalScore;

    @ApiModelProperty("手法总得分")
    private Integer punctualityScore;

    @ApiModelProperty("礼仪总得分")
    private Integer communicateScore;

    @ApiModelProperty("被评论次数")
    private Short commentTotal;

    @ApiModelProperty("服务次数")
    private Short serviceTotal;

    @ApiModelProperty("满意度评价总分")
    private Integer storeScore;

    @ApiModelProperty("好评次数")
    private Integer goodTotal;

    @ApiModelProperty("排序")
    private Short sort;

    @ApiModelProperty("状态 0已删除 1正常 2待验证 4下架")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

    @ApiModelProperty("工作经历")
    private  BeauticianExperience beauticianExperience;
    @ApiModelProperty("技师拓展信息")
    private   BeauticianExtend beauticianExtend;

    public BeauticianExperience getBeauticianExperience() {
        return beauticianExperience;
    }

    public void setBeauticianExperience(BeauticianExperience beauticianExperience) {
        this.beauticianExperience = beauticianExperience;
    }

    public BeauticianExtend getBeauticianExtend() {
        return beauticianExtend;
    }

    public void setBeauticianExtend(BeauticianExtend beauticianExtend) {
        this.beauticianExtend = beauticianExtend;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw == null ? null : psw.trim();
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Byte getCareerType() {
        return careerType;
    }

    public void setCareerType(Byte careerType) {
        this.careerType = careerType;
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

    public Short getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Short commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Short getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(Short serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public Integer getStoreScore() {
        return storeScore;
    }

    public void setStoreScore(Integer storeScore) {
        this.storeScore = storeScore;
    }

    public Integer getGoodTotal() {
        return goodTotal;
    }

    public void setGoodTotal(Integer goodTotal) {
        this.goodTotal = goodTotal;
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