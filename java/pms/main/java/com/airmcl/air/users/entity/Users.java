package com.airmcl.air.users.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="会员用户表")
public class Users implements Serializable {
    @ApiModelProperty("用户ID")
    private Integer id;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("持卡人姓名")
    private String vipcardName;

    @ApiModelProperty("会员卡开启时间")
    private Integer vipStartTime;

    @ApiModelProperty("会员卡过期时间")
    private Integer vipExpire;

    @ApiModelProperty("会员卡累计天数")
    private Integer vipDay;

    @ApiModelProperty("储值卡数量")
    private Integer mdcardTotal;

    @ApiModelProperty("服务次数")
    private Integer serviceTotal;

    @ApiModelProperty("可用套餐数")
    private Integer packageTotal;

    @ApiModelProperty("可用优惠券数")
    private Integer couponTotal;

    @ApiModelProperty("消费金额")
    private BigDecimal useMoney;

    @ApiModelProperty("状态 0:删除, 1:正常，2:禁用")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

    @ApiModelProperty("会员编号(v15151489010900727)和订单编号一样长")
    private String vipNumber;

    @ApiModelProperty("收益人手机号")
    private String refereeMobile;

    @ApiModelProperty("受益人id(如果是首次购买的会员,去门店受益人,如果是兑换的,取对方返回的受益人)")
    private String refereeId;

    @ApiModelProperty("受益人姓名")
    private String refereeName;

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

    public String getVipcardName() {
        return vipcardName;
    }

    public void setVipcardName(String vipcardName) {
        this.vipcardName = vipcardName == null ? null : vipcardName.trim();
    }

    public Integer getVipStartTime() {
        return vipStartTime;
    }

    public void setVipStartTime(Integer vipStartTime) {
        this.vipStartTime = vipStartTime;
    }

    public Integer getVipExpire() {
        return vipExpire;
    }

    public void setVipExpire(Integer vipExpire) {
        this.vipExpire = vipExpire;
    }

    public Integer getVipDay() {
        return vipDay;
    }

    public void setVipDay(Integer vipDay) {
        this.vipDay = vipDay;
    }

    public Integer getMdcardTotal() {
        return mdcardTotal;
    }

    public void setMdcardTotal(Integer mdcardTotal) {
        this.mdcardTotal = mdcardTotal;
    }

    public Integer getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(Integer serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public Integer getPackageTotal() {
        return packageTotal;
    }

    public void setPackageTotal(Integer packageTotal) {
        this.packageTotal = packageTotal;
    }

    public Integer getCouponTotal() {
        return couponTotal;
    }

    public void setCouponTotal(Integer couponTotal) {
        this.couponTotal = couponTotal;
    }

    public BigDecimal getUseMoney() {
        return useMoney;
    }

    public void setUseMoney(BigDecimal useMoney) {
        this.useMoney = useMoney;
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

    public String getVipNumber() {
        return vipNumber;
    }

    public void setVipNumber(String vipNumber) {
        this.vipNumber = vipNumber == null ? null : vipNumber.trim();
    }

    public String getRefereeMobile() {
        return refereeMobile;
    }

    public void setRefereeMobile(String refereeMobile) {
        this.refereeMobile = refereeMobile == null ? null : refereeMobile.trim();
    }

    public String getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(String refereeId) {
        this.refereeId = refereeId == null ? null : refereeId.trim();
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName == null ? null : refereeName.trim();
    }
}