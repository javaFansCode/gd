package com.airmcl.air.activitys.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="活动表")
public class Activitys implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("活动标题")
    private String title;

    @ApiModelProperty("活动开始时间")
    private Integer starttime;

    @ApiModelProperty("活动结束时间")
    private Integer endtime;

    @ApiModelProperty("活动类型1直减 2满减 3折扣 4送券 5余额充值 6送礼品 7充加送  9:送券+余额充值")
    private Byte type;

    @ApiModelProperty("执行方式 1注册 2支付完成 3支付时 4好评 5登录 6完成订单 7钱包充值成功")
    private Byte executionType;

    @ApiModelProperty("折扣 如果type类型为3(折扣类型)则在原金额上*折扣/100")
    private Short discount;

    @ApiModelProperty("减除金额/赠送金额（为0时赠送实付金额）")
    private BigDecimal reduceMoney;

    @ApiModelProperty("满足多少金额 用于满减")
    private BigDecimal meetMoney;

    @ApiModelProperty("0无条件 1首单")
    private Byte term;

    @ApiModelProperty("是否推荐(1:否,2:是)")
    private Byte isrecommend;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("活动状态 0关闭 1开启  2:删除")
    private Byte state;

    @ApiModelProperty("创建时间")
    private Integer createtime;

    @ApiModelProperty("活动介绍")
    private String introduction;

    private static final long serialVersionUID = 1L;
   
    private List<ActivitysCouponsVo> couponList = new ArrayList<>();
    
    private List<ActivitysServicesVo> serviceItemList= new ArrayList<>();
    
    private List<ActivitysBeautyVo> activitysBeautyVoList= new ArrayList<>();
    
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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getExecutionType() {
        return executionType;
    }

    public void setExecutionType(Byte executionType) {
        this.executionType = executionType;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    public BigDecimal getReduceMoney() {
        return reduceMoney;
    }

    public void setReduceMoney(BigDecimal reduceMoney) {
        this.reduceMoney = reduceMoney;
    }

    public BigDecimal getMeetMoney() {
        return meetMoney;
    }

    public void setMeetMoney(BigDecimal meetMoney) {
        this.meetMoney = meetMoney;
    }

    public Byte getTerm() {
        return term;
    }

    public void setTerm(Byte term) {
        this.term = term;
    }

    public Byte getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Byte isrecommend) {
        this.isrecommend = isrecommend;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

	public List<ActivitysCouponsVo> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<ActivitysCouponsVo> couponList) {
		this.couponList = couponList;
	}

	public List<ActivitysServicesVo> getServiceItemList() {
		return serviceItemList;
	}

	public void setServiceItemList(List<ActivitysServicesVo> serviceItemList) {
		this.serviceItemList = serviceItemList;
	}

	public List<ActivitysBeautyVo> getActivitysBeautyVoList() {
		return activitysBeautyVoList;
	}

	public void setActivitysBeautyVoList(List<ActivitysBeautyVo> activitysBeautyVoList) {
		this.activitysBeautyVoList = activitysBeautyVoList;
	}

    
	 
	 
    
    
}