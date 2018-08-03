package com.airmcl.air.users.out;

import java.io.Serializable;

public class OutUserRelationship implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userNickName; //用户昵称
	private String userPhone; //用户手机号
	private Integer state; //用户注册状态  :1未注册 2.已注册',
	private String refereePhone; //推荐人电话号码
	private String createTime; //关联时间
	private String vipcardName; //推荐人昵称
	private String vipNumber; //会员卡号
	private String userId;
	private String userType; //是否是会员
	private Integer vipExpire; //会员卡过期时间
	private Integer id ;//调试--区别返回数据
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVipExpire() {
		return vipExpire;
	}
	public void setVipExpire(Integer vipExpire) {
		this.vipExpire = vipExpire;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVipcardName() {
		return vipcardName;
	}
	public void setVipcardName(String vipcardName) {
		this.vipcardName = vipcardName;
	}
	public String getVipNumber() {
		return vipNumber;
	}
	public void setVipNumber(String vipNumber) {
		this.vipNumber = vipNumber;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRefereePhone() {
		return refereePhone;
	}
	public void setRefereePhone(String refereePhone) {
		this.refereePhone = refereePhone;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
