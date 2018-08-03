package com.airmcl.air.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="mdd_api_order")
public class Order implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("订单总表ID")
    private Integer orderId;

    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("服务项目ID(ID之间逗号隔开)")
    private String serviceId;

    @ApiModelProperty("项目时长(单位:分钟) 商品类的有效期(单位:年)")
    private Short serviceTime;

    @ApiModelProperty("优惠券ID")
    private Integer couponId;

    @ApiModelProperty("月卡id")
    private Integer monthCardId;

    @ApiModelProperty("门店ID")
    private Integer beautyId;

    @ApiModelProperty("门店名称")
    private String beautyName;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("技师名称")
    private String btName;

    @ApiModelProperty("技师电话")
    private String btMobile;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("填写的联系人手机号码")
    private String userMobile;

    @ApiModelProperty("推荐人手机号(会员卡使用)")
    private Integer refereeMobile;

    @ApiModelProperty("联系人姓名")
    private String nickname;

    @ApiModelProperty("用户账号")
    private String mobile;

    @ApiModelProperty("订单价格")
    private BigDecimal price;

    @ApiModelProperty("改价后的价格")
    private BigDecimal changePrice;

    @ApiModelProperty("实付价格(实付价格=价格-优惠券)")
    private BigDecimal actualPrice;

    @ApiModelProperty("优惠价格")
    private BigDecimal reducePrice;

    @ApiModelProperty("是否是用户套餐购买(1:否[单次或用户套餐购买],2:是[套餐购买])(此字段已经废弃)")
    private Byte isUserPackage;

    @ApiModelProperty("订单类型(1:单项目购买,2:套餐购买,3:套餐预约,4:储值卡,5:会员卡)")
    private Byte orderType;

    @ApiModelProperty("订单门店类型细分（关联表industry）industryID(此字段已经废弃)")
    private Byte orderIndustryType;

    @ApiModelProperty("0:已取消,1:已支付,2:待支付,3:服务中,4:已完成,5:用户未支付的取消,7:退款中,8:已退款,9超时待服务,10:改签待服务,11:冻结,12:解冻,95:已退款删除 , 96:已完成删除,99:待支付删除")
    private Byte state;

    @ApiModelProperty("支付方式 1:微信支付 2:支付宝支付,3:套餐支付,4.第三方支付:5.免支付")
    private Byte payWay;

    @ApiModelProperty("服务开启时间")
    private Integer serviceStartTime;

    @ApiModelProperty("服务结束时间")
    private Integer serviceEndTime;

    @ApiModelProperty("设备分润比例(已经废弃,使用项目的分润类型代替)")
    private Float rofitRatio;

    @ApiModelProperty("支付时间")
    private Integer payTime;

    @ApiModelProperty("预约时间")
    private Integer reserveTime;

    @ApiModelProperty("过期时间")
    private Integer expireTime;

    @ApiModelProperty("支付方式总数")
    private String buyPayWay;

    @ApiModelProperty("下单时间")
    private Integer createtime;

    @ApiModelProperty("是否评论(1:未评论,2:已评论)")
    private Byte iscomment;

    @ApiModelProperty("是否回复评论(1:未回复,2:已回复)")
    private Byte isreply;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("是否核销  0未核销 1已核销")
    private Byte isCheck;

    @ApiModelProperty("分润规则id")
    private String ledgerRuleId;

    @ApiModelProperty("分润规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("分润周期")
    private Byte ledgerCycle;

    @ApiModelProperty("服务项目名称(名称之间用|隔开)")
    private String serviceName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Short getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Short serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getMonthCardId() {
        return monthCardId;
    }

    public void setMonthCardId(Integer monthCardId) {
        this.monthCardId = monthCardId;
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public String getBeautyName() {
        return beautyName;
    }

    public void setBeautyName(String beautyName) {
        this.beautyName = beautyName == null ? null : beautyName.trim();
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName == null ? null : btName.trim();
    }

    public String getBtMobile() {
        return btMobile;
    }

    public void setBtMobile(String btMobile) {
        this.btMobile = btMobile == null ? null : btMobile.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public Integer getRefereeMobile() {
        return refereeMobile;
    }

    public void setRefereeMobile(Integer refereeMobile) {
        this.refereeMobile = refereeMobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        this.changePrice = changePrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
    }

    public Byte getIsUserPackage() {
        return isUserPackage;
    }

    public void setIsUserPackage(Byte isUserPackage) {
        this.isUserPackage = isUserPackage;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getOrderIndustryType() {
        return orderIndustryType;
    }

    public void setOrderIndustryType(Byte orderIndustryType) {
        this.orderIndustryType = orderIndustryType;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getPayWay() {
        return payWay;
    }

    public void setPayWay(Byte payWay) {
        this.payWay = payWay;
    }

    public Integer getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(Integer serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public Integer getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(Integer serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    public Float getRofitRatio() {
        return rofitRatio;
    }

    public void setRofitRatio(Float rofitRatio) {
        this.rofitRatio = rofitRatio;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Integer reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String getBuyPayWay() {
        return buyPayWay;
    }

    public void setBuyPayWay(String buyPayWay) {
        this.buyPayWay = buyPayWay == null ? null : buyPayWay.trim();
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public Byte getIscomment() {
        return iscomment;
    }

    public void setIscomment(Byte iscomment) {
        this.iscomment = iscomment;
    }

    public Byte getIsreply() {
        return isreply;
    }

    public void setIsreply(Byte isreply) {
        this.isreply = isreply;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Byte isCheck) {
        this.isCheck = isCheck;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }
}