package com.airmcl.air.comments.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value="订单评论主表")
public class Comments implements Serializable {
    @ApiModelProperty("评论主表id")
    private Integer id;

    @ApiModelProperty("被回复的评论id")
    private Integer parentId;

    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("服务项目id(逗号隔开)")
    private String serviceId;

    @ApiModelProperty("门店id")
    private Integer beautyId;

    @ApiModelProperty("技师id")
    private Integer btId;

    @ApiModelProperty("发表评论的用户id")
    private String userId;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("被评论的用户id")
    private Integer toUser;

    @ApiModelProperty("专业得分")
    private Byte professional;

    @ApiModelProperty("手法态度分数")
    private Byte punctuality;

    @ApiModelProperty("礼仪分数")
    private Byte communication;

    @ApiModelProperty("满意度得分")
    private Double satisfy;

    @ApiModelProperty("是否是套餐(1:单项,3:套餐)")
    private Byte orderType;

    @ApiModelProperty("项目名称(+号隔开)")
    private String serviceName;

    @ApiModelProperty("状态，1已审核，2未审核 0删除  3：下架")
    private Byte state;

    @ApiModelProperty("是否已回复0未回复 1已回复")
    private Byte isReply;

    @ApiModelProperty("0：未读  1：已读")
    private Byte isRead;

    @ApiModelProperty("评论来源(1:预约,2:合伙人)")
    private Byte type;

    @ApiModelProperty("评论时间")
    private Integer createtime;

    @ApiModelProperty("评论内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public Integer getBeautyId() {
        return beautyId;
    }

    public void setBeautyId(Integer beautyId) {
        this.beautyId = beautyId;
    }

    public Integer getBtId() {
        return btId;
    }

    public void setBtId(Integer btId) {
        this.btId = btId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getToUser() {
        return toUser;
    }

    public void setToUser(Integer toUser) {
        this.toUser = toUser;
    }

    public Byte getProfessional() {
        return professional;
    }

    public void setProfessional(Byte professional) {
        this.professional = professional;
    }

    public Byte getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Byte punctuality) {
        this.punctuality = punctuality;
    }

    public Byte getCommunication() {
        return communication;
    }

    public void setCommunication(Byte communication) {
        this.communication = communication;
    }

    public Double getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(Double satisfy) {
        this.satisfy = satisfy;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getIsReply() {
        return isReply;
    }

    public void setIsReply(Byte isReply) {
        this.isReply = isReply;
    }

    public Byte getIsRead() {
        return isRead;
    }

    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }



}