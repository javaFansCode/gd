package com.airmcl.air.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="服务项目主表")
public class Service implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("美容院ID")
    private Integer beautyId;

    @ApiModelProperty("行业类型(1:美容,2:美业)")
    private Byte type;

    @ApiModelProperty("分账规则id")
    private String ledgerRuleId;

    @ApiModelProperty("分账规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("分账周期")
    private Byte ledgerCycle;

    @ApiModelProperty("项目类型")
    private Byte serviceType;

    @ApiModelProperty("项目名称")
    private String serviceName;

    @ApiModelProperty("项目标题拼音")
    private String serviceNamePhonetic;

    @ApiModelProperty("项目副标题")
    private String serviceSubtitle;

    @ApiModelProperty("项目时长(单位:分钟)")
    private Integer serviceTime;

    @ApiModelProperty("项目封面图")
    private String serviceCover;

    @ApiModelProperty("原价")
    private BigDecimal originalPrice;

    @ApiModelProperty("会员价")
    private BigDecimal memberPrice;

    @ApiModelProperty("销售价")
    private BigDecimal price;

    @ApiModelProperty("设备分润比例")
    private Float rofitRatio;

    @ApiModelProperty("促销价")
    private BigDecimal discountPrice;

    @ApiModelProperty("被预约次数")
    private Short appointTotal;

    @ApiModelProperty("评论次数")
    private Short commentTotal;

    @ApiModelProperty("排序 越大越前")
    private Short sort;

    @ApiModelProperty("是否是套餐(1:否,2:是)")
    private Byte isPackage;

    @ApiModelProperty("标签(逗号隔开)")
    private String tag;

    @ApiModelProperty("支付方式 1:微信 2:支付宝 3:钱包 6:线下支付")
    private String payWay;

    @ApiModelProperty("是否使用优惠券(1:使用,2:不使用)")
    private Byte isCoupon;

    @ApiModelProperty("退款功能(1:支持,2:不支持)")
    private Byte isRefund;

    @ApiModelProperty("是否限购(1:关闭,2:开启)")
    private Byte isPurchase;

    @ApiModelProperty("过期时间(天数,0代表无限期)")
    private Byte outTimeDay;

    @ApiModelProperty("状态 是否上架的 1:上架 2:下架 0:删除")
    private Byte state;

    @ApiModelProperty("服务打包")
    private List<ServicePackage> servicePackages;
    
    @ApiModelProperty("创建时间")
    private Integer createtime;
    
    @ApiModelProperty("扫码开机字段")
    private Byte sweepTheYard;
    
    private static final long serialVersionUID = 1L;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getLedgerRuleId() {
        return ledgerRuleId;
    }

    public void setLedgerRuleId(String ledgerRuleId) {
        this.ledgerRuleId = ledgerRuleId == null ? null : ledgerRuleId.trim();
    }

    public String getLedgerRuleName() {
        return ledgerRuleName;
    }

    public void setLedgerRuleName(String ledgerRuleName) {
        this.ledgerRuleName = ledgerRuleName == null ? null : ledgerRuleName.trim();
    }

    public Byte getLedgerCycle() {
        return ledgerCycle;
    }

    public void setLedgerCycle(Byte ledgerCycle) {
        this.ledgerCycle = ledgerCycle;
    }

    public Byte getServiceType() {
        return serviceType;
    }

    public void setServiceType(Byte serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceNamePhonetic() {
        return serviceNamePhonetic;
    }

    public void setServiceNamePhonetic(String serviceNamePhonetic) {
        this.serviceNamePhonetic = serviceNamePhonetic == null ? null : serviceNamePhonetic.trim();
    }

    public String getServiceSubtitle() {
        return serviceSubtitle;
    }

    public void setServiceSubtitle(String serviceSubtitle) {
        this.serviceSubtitle = serviceSubtitle == null ? null : serviceSubtitle.trim();
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public String getServiceCover() {
        return serviceCover;
    }

    public void setServiceCover(String serviceCover) {
        this.serviceCover = serviceCover == null ? null : serviceCover.trim();
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ServicePackage> getServicePackages() {
		return servicePackages;
	}

	public void setServicePackages(List<ServicePackage> servicePackages) {
		this.servicePackages = servicePackages;
	}

	public Float getRofitRatio() {
        return rofitRatio;
    }

    public void setRofitRatio(Float rofitRatio) {
        this.rofitRatio = rofitRatio;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Short getAppointTotal() {
        return appointTotal;
    }

    public void setAppointTotal(Short appointTotal) {
        this.appointTotal = appointTotal;
    }

    public Short getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Short commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Byte getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Byte isPackage) {
        this.isPackage = isPackage;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public Byte getIsCoupon() {
        return isCoupon;
    }

    public void setIsCoupon(Byte isCoupon) {
        this.isCoupon = isCoupon;
    }

    public Byte getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Byte isRefund) {
        this.isRefund = isRefund;
    }

    public Byte getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Byte isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Byte getOutTimeDay() {
        return outTimeDay;
    }

    public void setOutTimeDay(Byte outTimeDay) {
        this.outTimeDay = outTimeDay;
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
        this.createtime = createtime ;
    }

	public Byte getSweepTheYard() {
		return sweepTheYard;
	}

	public void setSweepTheYard(Byte sweepTheYard) {
		this.sweepTheYard = sweepTheYard;
	}
    
}