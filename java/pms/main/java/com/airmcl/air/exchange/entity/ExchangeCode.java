package com.airmcl.air.exchange.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="兑换码主表")
public class ExchangeCode implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("兑换码生成记录表id")
    private Integer recordId;

    @ApiModelProperty("兑换码")
    private String code;

    @ApiModelProperty("兑换码类型 1coupon优惠券")
    private Byte type;

    @ApiModelProperty("兑换码 开启时间")
    private Integer starttime;

    @ApiModelProperty("兑换码结束时间")
    private Integer endtime;

    @ApiModelProperty("兑换金额 兑换码为money时使用")
    private BigDecimal money;

    @ApiModelProperty("优惠券id")
    private String couponId;

    @ApiModelProperty("状态 0删除 1正常 2作废 3已使用")
    private Byte state;

    @ApiModelProperty("可被兑换次数")
    private Integer times;

    private Integer usetime;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("密码(提供给美容师,发放给用户)")
    private String secret;

    @ApiModelProperty("兑换码持有人(即美容师id,0代表未绑定美容师)")
    private Integer beauticianId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public Integer getBeauticianId() {
        return beauticianId;
    }

    public void setBeauticianId(Integer beauticianId) {
        this.beauticianId = beauticianId;
    }
}