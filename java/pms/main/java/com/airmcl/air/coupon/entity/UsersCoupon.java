package com.airmcl.air.coupon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="用户优惠券表")
public class UsersCoupon implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("优惠券ID")
    private Integer couponId;

    @ApiModelProperty("优惠券标题")
    private String couponTitle;

    @ApiModelProperty("0:指派 ,1:注册 ,2:好评,3兑换码")
    private Byte sendType;

    @ApiModelProperty("优惠券类型(1:优惠券 ,2:现金券 ,3:折扣券)")
    private Byte type;

    @ApiModelProperty("使用类型(1:满减,2:现金抵扣,3:直折,4:满折+减额上线,5:满折,6:直折+减额上限)")
    private Byte useType;

    @ApiModelProperty("满多少")
    private BigDecimal moneyMax;

    @ApiModelProperty("减多少")
    private BigDecimal moneyReduce;

    @ApiModelProperty("现金券金额")
    private BigDecimal moneyAmount;

    @ApiModelProperty("打折")
    private Float discount;

    @ApiModelProperty("使用时间")
    private Integer useTime;

    @ApiModelProperty("过期类型(1:无限期 ,2:指定日期 ,3:指定天数)")
    private Byte expiryType;

    @ApiModelProperty("过期时间")
    private Integer expiresTime;

    @ApiModelProperty("1 :预约 2:直购 3:全部")
    private Byte itemType;

    @ApiModelProperty("减额上限")
    private BigDecimal reduceMax;

    @ApiModelProperty("开始时间")
    private Integer starttime;

    @ApiModelProperty("使用情况(1:未使用,2:已使用,3:已失效)")
    private Byte isUse;

    @ApiModelProperty("0=没有限制服务，1=限制服务,2=禁用服务项目")
    private Byte isService;

    @ApiModelProperty("0=没有限制储蓄卡，1=限制储蓄卡2=禁用储蓄卡")
    private Byte isMcard;

    @ApiModelProperty("0=没有限制会员卡，1=限制会员卡,2=禁用会员卡")
    private Byte isVcard;

    @ApiModelProperty("指定项目id(逗号隔开)")
    private String serviceId;

    @ApiModelProperty("指定储蓄卡id(逗号隔开)")
    private String mcardId;

    @ApiModelProperty("指定会员卡id(逗号隔开)")
    private String vcardId;

    @ApiModelProperty("城市ID（0代表所有城市，多个城市用‘，’分开）")
    private String city;

    @ApiModelProperty("门店id 0 全部 ，多个逗号隔开")
    private String beautyId;

    @ApiModelProperty("是否开启 1是 2否 0已删除")
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle == null ? null : couponTitle.trim();
    }

    public Byte getSendType() {
        return sendType;
    }

    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getUseType() {
        return useType;
    }

    public void setUseType(Byte useType) {
        this.useType = useType;
    }

    public BigDecimal getMoneyMax() {
        return moneyMax;
    }

    public void setMoneyMax(BigDecimal moneyMax) {
        this.moneyMax = moneyMax;
    }

    public BigDecimal getMoneyReduce() {
        return moneyReduce;
    }

    public void setMoneyReduce(BigDecimal moneyReduce) {
        this.moneyReduce = moneyReduce;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }

    public Byte getExpiryType() {
        return expiryType;
    }

    public void setExpiryType(Byte expiryType) {
        this.expiryType = expiryType;
    }

    public Integer getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(Integer expiresTime) {
        this.expiresTime = expiresTime;
    }

    public Byte getItemType() {
        return itemType;
    }

    public void setItemType(Byte itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getReduceMax() {
        return reduceMax;
    }

    public void setReduceMax(BigDecimal reduceMax) {
        this.reduceMax = reduceMax;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }

    public Byte getIsService() {
        return isService;
    }

    public void setIsService(Byte isService) {
        this.isService = isService;
    }

    public Byte getIsMcard() {
        return isMcard;
    }

    public void setIsMcard(Byte isMcard) {
        this.isMcard = isMcard;
    }

    public Byte getIsVcard() {
        return isVcard;
    }

    public void setIsVcard(Byte isVcard) {
        this.isVcard = isVcard;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getMcardId() {
        return mcardId;
    }

    public void setMcardId(String mcardId) {
        this.mcardId = mcardId == null ? null : mcardId.trim();
    }

    public String getVcardId() {
        return vcardId;
    }

    public void setVcardId(String vcardId) {
        this.vcardId = vcardId == null ? null : vcardId.trim();
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