package com.airmcl.air.beauty.entity;

import java.io.Serializable;

public class OutBeautyRelationsRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id; // 门店ID
	private String BeautyName; // 门店名称
	private String ServiceName;// 服务项目名称
	private Byte type;// "类型（1=服务项目，2=商品）"
	private Byte OperateType; // 操作者类型
	private Integer OperateId; // 操作者ID
	private Integer bt_id;
	private Integer rb_id;
	private Byte State; // 状态(0:删除 ,1:正常)
	private String CreateTime; // 创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeautyName() {
		return BeautyName;
	}

	public void setBeautyName(String beautyName) {
		BeautyName = beautyName;
	}

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	public Byte getOperateType() {
		return OperateType;
	}

	public void setOperateType(Byte operateType) {
		OperateType = operateType;
	}

	public Integer getOperateId() {
		return OperateId;
	}

	public void setOperateId(Integer operateId) {
		OperateId = operateId;
	}

	public Byte getState() {
		return State;
	}

	public void setState(Byte state) {
		State = state;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public Integer getBt_id() {
		return bt_id;
	}

	public void setBt_id(Integer bt_id) {
		this.bt_id = bt_id;
	}

	public Integer getRb_id() {
		return rb_id;
	}

	public void setRb_id(Integer rb_id) {
		this.rb_id = rb_id;
	}

}
