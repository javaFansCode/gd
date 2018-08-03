package com.airmcl.air.exchange.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="兑换码生成记录表")
public class ExchangeCodeRecord implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("活动标题")
    private String title;

    @ApiModelProperty("管理员id")
    private String adminId;

    @ApiModelProperty("活动前缀")
    private String prefixCode;

    @ApiModelProperty("兑换码类型 1coupon优惠券2 money钱包余额")
    private Byte type;

    @ApiModelProperty("兑换码 开启时间")
    private Integer starttime;

    @ApiModelProperty("兑换码结束时间")
    private Integer endtime;

    @ApiModelProperty("兑换金额 兑换码为money时使用")
    private BigDecimal money;

    @ApiModelProperty("优惠券id")
    private String couponId;

    @ApiModelProperty("兑换码组合类型 1英文 2数字 3英文+数字")
    private Byte combinationType;

    @ApiModelProperty("兑换码字数")
    private Byte words;

    @ApiModelProperty("生成兑换码数量")
    private Short numbers;

    @ApiModelProperty("可兑换次数")
    private Integer times;

    @ApiModelProperty("兑换总次数")
    private Integer usetime;

    @ApiModelProperty("状态 0删除 1正常 2作废")
    private Byte state;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("兑换码说明")
    private String introduction;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getPrefixCode() {
        return prefixCode;
    }

    public void setPrefixCode(String prefixCode) {
        this.prefixCode = prefixCode == null ? null : prefixCode.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public Byte getCombinationType() {
        return combinationType;
    }

    public void setCombinationType(Byte combinationType) {
        this.combinationType = combinationType;
    }

    public Byte getWords() {
        return words;
    }

    public void setWords(Byte words) {
        this.words = words;
    }

    public Short getNumbers() {
        return numbers;
    }

    public void setNumbers(Short numbers) {
        this.numbers = numbers;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getUsetime() {
        return usetime;
    }

    public void setUsetime(Integer usetime) {
        this.usetime = usetime;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }
}