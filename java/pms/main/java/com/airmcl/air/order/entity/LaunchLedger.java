package com.airmcl.air.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="订单分账发起表")
public class LaunchLedger implements Serializable {
    @ApiModelProperty("主键id")
    private String id;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("用户uc_openid")
    private String userUcOpenId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户手机号")
    private String userMobile;

    @ApiModelProperty("体验中心id（光电必填）")
    private String storeId;

    @ApiModelProperty("体验中心名称（光电必填）")
    private String storeName;

    @ApiModelProperty("订单支付流水号（需要分账时必填）")
    private String orderPayRequestNo;

    @ApiModelProperty("分账金额")
    private String ledgerAmount;

    @ApiModelProperty("分账规则id")
    private String ledgerRuleId;

    @ApiModelProperty("分账规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("服务项目id")
    private String productId;

    @ApiModelProperty("服务项目名称")
    private String productName;

    @ApiModelProperty("分账周期（天）")
    private Integer ledgerCycle;

    @ApiModelProperty("applicationNo 应用编号（光电中心MCL2018020110064508，时光部落 MCL2018020110101005，时光姬MCL2018020110091008 ）")
    private String applicationNo;

    @ApiModelProperty("0、未分账。1、分账成功。2、分账失败。3、分账中。")
    private Byte state;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUserUcOpenId() {
        return userUcOpenId;
    }

    public void setUserUcOpenId(String userUcOpenId) {
        this.userUcOpenId = userUcOpenId == null ? null : userUcOpenId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getOrderPayRequestNo() {
        return orderPayRequestNo;
    }

    public void setOrderPayRequestNo(String orderPayRequestNo) {
        this.orderPayRequestNo = orderPayRequestNo == null ? null : orderPayRequestNo.trim();
    }

    public String getLedgerAmount() {
        return ledgerAmount;
    }

    public void setLedgerAmount(String ledgerAmount) {
        this.ledgerAmount = ledgerAmount == null ? null : ledgerAmount.trim();
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getLedgerCycle() {
        return ledgerCycle;
    }

    public void setLedgerCycle(Integer ledgerCycle) {
        this.ledgerCycle = ledgerCycle;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo == null ? null : applicationNo.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}