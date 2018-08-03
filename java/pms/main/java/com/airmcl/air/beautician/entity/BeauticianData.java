package com.airmcl.air.beautician.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="技师每日数据统计表")
public class BeauticianData implements Serializable {
    private Integer id;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("时间日期")
    private Integer datetime;

    @ApiModelProperty("流水总额")
    private BigDecimal stream;

    @ApiModelProperty("收入流水")
    private BigDecimal income;

    @ApiModelProperty("服务用户数")
    private Integer serviceuser;

    @ApiModelProperty("指派用户数")
    private Integer assignuser;

    @ApiModelProperty("关联项目数")
    private Integer contentservice;

    @ApiModelProperty("订单总数")
    private Integer allorder;

    @ApiModelProperty("完成订单数")
    private Integer finishorder;

    @ApiModelProperty("待服务订单数")
    private Integer pendorder;

    @ApiModelProperty("已完成非套餐支付数")
    private String alipay;

    @ApiModelProperty("已完成套餐支付数")
    private String wxpay;

    @ApiModelProperty("钱包支付（用，分开 前：已完成 后：待服务）")
    private String walletpay;

    @ApiModelProperty("套餐支付数（用，分开 前：已完成 后：待服务）")
    private String packagepay;

    @ApiModelProperty("评论总数")
    private Integer allcomment;

    @ApiModelProperty("好评数")
    private Integer goodcomment;

    @ApiModelProperty("中评数")
    private Integer mediumcomment;

    @ApiModelProperty("差评数")
    private Integer badcomment;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("优惠券支付（用，分开 前：已完成 后：待服务）")
    private String couponpay;

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

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Integer getDatetime() {
        return datetime;
    }

    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    public BigDecimal getStream() {
        return stream;
    }

    public void setStream(BigDecimal stream) {
        this.stream = stream;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public Integer getServiceuser() {
        return serviceuser;
    }

    public void setServiceuser(Integer serviceuser) {
        this.serviceuser = serviceuser;
    }

    public Integer getAssignuser() {
        return assignuser;
    }

    public void setAssignuser(Integer assignuser) {
        this.assignuser = assignuser;
    }

    public Integer getContentservice() {
        return contentservice;
    }

    public void setContentservice(Integer contentservice) {
        this.contentservice = contentservice;
    }

    public Integer getAllorder() {
        return allorder;
    }

    public void setAllorder(Integer allorder) {
        this.allorder = allorder;
    }

    public Integer getFinishorder() {
        return finishorder;
    }

    public void setFinishorder(Integer finishorder) {
        this.finishorder = finishorder;
    }

    public Integer getPendorder() {
        return pendorder;
    }

    public void setPendorder(Integer pendorder) {
        this.pendorder = pendorder;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay == null ? null : alipay.trim();
    }

    public String getWxpay() {
        return wxpay;
    }

    public void setWxpay(String wxpay) {
        this.wxpay = wxpay == null ? null : wxpay.trim();
    }

    public String getWalletpay() {
        return walletpay;
    }

    public void setWalletpay(String walletpay) {
        this.walletpay = walletpay == null ? null : walletpay.trim();
    }

    public String getPackagepay() {
        return packagepay;
    }

    public void setPackagepay(String packagepay) {
        this.packagepay = packagepay == null ? null : packagepay.trim();
    }

    public Integer getAllcomment() {
        return allcomment;
    }

    public void setAllcomment(Integer allcomment) {
        this.allcomment = allcomment;
    }

    public Integer getGoodcomment() {
        return goodcomment;
    }

    public void setGoodcomment(Integer goodcomment) {
        this.goodcomment = goodcomment;
    }

    public Integer getMediumcomment() {
        return mediumcomment;
    }

    public void setMediumcomment(Integer mediumcomment) {
        this.mediumcomment = mediumcomment;
    }

    public Integer getBadcomment() {
        return badcomment;
    }

    public void setBadcomment(Integer badcomment) {
        this.badcomment = badcomment;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public String getCouponpay() {
        return couponpay;
    }

    public void setCouponpay(String couponpay) {
        this.couponpay = couponpay == null ? null : couponpay.trim();
    }
}