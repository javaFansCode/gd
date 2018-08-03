package com.airmcl.air.goods.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="商品表")
public class Goods implements Serializable {
    private Integer id;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("卡编号")
    private String cardNumber;

    @ApiModelProperty("封面")
    private String goodsCover;

    @ApiModelProperty("使用范围 1=服务项目，2=套餐，3=会员卡")
    private String range;

    @ApiModelProperty("金额")
    private BigDecimal amount;

    @ApiModelProperty("分账周期")
    private Byte ledgerCycle;

    @ApiModelProperty("分账规则id")
    private String ledgerRuleId;

    @ApiModelProperty("分账规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("1=会员卡，2=储蓄卡 , 3=月卡")
    private Byte type;

    @ApiModelProperty("1=天，2=月，3=年 有效期类型")
    private Byte expiryType;

    @ApiModelProperty("有效期")
    private Integer expiry;

    @ApiModelProperty("市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty("门店价")
    private BigDecimal price;

    @ApiModelProperty("会员价")
    private BigDecimal memberPrice;

    @ApiModelProperty("是否限购(1:不限购,2:限购)")
    private Byte isPurchase;

    @ApiModelProperty("是否使用优惠券(1:使用,2:不使用)")
    private Byte isCoupon;

    @ApiModelProperty("退款功能(1:支持,2:不支持)")
    private Byte isRefund;

    @ApiModelProperty("今日推荐(1:是,2:否)")
    private Byte isRecommend;

    @ApiModelProperty("自动上下架(1:是,2:否)")
    private Byte isAutoShelve;

    @ApiModelProperty("购买次数")
    private Integer purchaseTotal;

    @ApiModelProperty("评论次数")
    private Integer commentTotal;

    @ApiModelProperty("排序（越小越前）")
    private Integer sort;

    @ApiModelProperty("开售时间")
    private Integer openingtime;

    @ApiModelProperty("添加时间")
    private Integer createtime;

    @ApiModelProperty("1=正常，4=下架，0=删除")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getGoodsCover() {
        return goodsCover;
    }

    public void setGoodsCover(String goodsCover) {
        this.goodsCover = goodsCover == null ? null : goodsCover.trim();
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range == null ? null : range.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getLedgerCycle() {
        return ledgerCycle;
    }

    public void setLedgerCycle(Byte ledgerCycle) {
        this.ledgerCycle = ledgerCycle;
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getExpiryType() {
        return expiryType;
    }

    public void setExpiryType(Byte expiryType) {
        this.expiryType = expiryType;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Byte getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Byte isPurchase) {
        this.isPurchase = isPurchase;
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

    public Byte getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Byte getIsAutoShelve() {
        return isAutoShelve;
    }

    public void setIsAutoShelve(Byte isAutoShelve) {
        this.isAutoShelve = isAutoShelve;
    }

    public Integer getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Integer purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Integer getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(Integer commentTotal) {
        this.commentTotal = commentTotal;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getOpeningtime() {
        return openingtime;
    }

    public void setOpeningtime(Integer openingtime) {
        this.openingtime = openingtime;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}