package com.airmcl.air.coupon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ApiModel(value="优惠券表")
public class Coupon implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("城市ID（0代表所有城市，多个城市用‘，’分开）")
    private String city;

    @ApiModelProperty("门店id 0 全部 ，多个逗号隔开")
    private String beautyId;

    @ApiModelProperty("0=没有限制服务，1=限制服务,2=禁用服务项目")
    private Byte isService;

    @ApiModelProperty("0=没有限制储蓄卡，1=限制储蓄卡2=禁用储蓄卡")
    private Byte isMcard;

    @ApiModelProperty("0=没有限制会员卡，1=限制会员卡,2=禁用会员卡")
    private Byte isVcard;

    @ApiModelProperty("储蓄卡id逗号隔开")
    private String mcardId;

    @ApiModelProperty("会员卡id逗号隔开")
    private String vcardId;

    @ApiModelProperty("优惠券名称")
    private String couponTitle;

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

    @ApiModelProperty("最高减免上限,(null为不设置)")
    private Float reduceMax;

    @ApiModelProperty("过期类型(1:无限期 ,2:指定日期 ,3:指定天数)")
    private Byte expiryType;

    @ApiModelProperty("开始时间")
    private Integer starttime;

    @ApiModelProperty("使用期(如:30天)")
    private Integer expiry;

    @ApiModelProperty("领取数")
    private Integer teceiveTotal;

    @ApiModelProperty("优惠券上限")
    private Integer upperLimit;

    @ApiModelProperty("状态(0:删除,1:开启,2:关闭)")
    private Byte state;

    @ApiModelProperty("创建时间")
    private String createtime;

    @ApiModelProperty("修改时间")
    private String updatetime;

    @ApiModelProperty("使用说明")
    private String useDesc;

    @ApiModelProperty("温馨提示")
    private String prompt="";

    private String serviceId;
    
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle == null ? null : couponTitle.trim();
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

    public Float getReduceMax() {
        return reduceMax;
    }

    public void setReduceMax(Float reduceMax) {
        this.reduceMax = reduceMax;
    }

    public Byte getExpiryType() {
        return expiryType;
    }

    public void setExpiryType(Byte expiryType) {
        this.expiryType = expiryType;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }

    public Integer getTeceiveTotal() {
        return teceiveTotal;
    }

    public void setTeceiveTotal(Integer teceiveTotal) {
        this.teceiveTotal = teceiveTotal;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUseDesc() {
        return useDesc;
    }

    public void setUseDesc(String useDesc) {
        this.useDesc = useDesc == null ? null : useDesc.trim();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? "" : prompt.trim();
    }

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
    
    
}