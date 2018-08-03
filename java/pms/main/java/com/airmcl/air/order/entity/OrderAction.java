package com.airmcl.air.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="mdd_api_order_action")
public class OrderAction implements Serializable {
    @ApiModelProperty("ID")
    private Integer id;

    @ApiModelProperty("订单ID")
    private Integer orderId;

    @ApiModelProperty("订单状态  0:已取消、1:已支付、2:待支付、3:服务中、4:已完成、5:用户未支付的取消、6:已出发、7:退款中、8:已退款 9：超时待服务    10；改签待服务    11：已冻结   12：已解冻")
    private Byte state;

    @ApiModelProperty("是否已读(1:未读,2:已读)")
    private Byte isRead;

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("技师ID")
    private Integer btId;

    @ApiModelProperty("1=系统操作，2=用户，3=技师，4=管理，5=后台 6=设备")
    private Byte operateType;

    @ApiModelProperty("操作者id")
    private String operateId;

    @ApiModelProperty("创建时间")
    private String createtime;

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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public Byte getOperateType() {
        return operateType;
    }

    public void setOperateType(Byte operateType) {
        this.operateType = operateType;
    }

    public String getOperateId() {
        return operateId;
    }

    public void setOperateId(String operateId) {
        this.operateId = operateId == null ? null : operateId.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}