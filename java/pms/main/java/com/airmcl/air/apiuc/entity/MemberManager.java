package com.airmcl.air.apiuc.entity;


import java.io.Serializable;

 

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="用户中心")
public class MemberManager implements Serializable {
	
 
 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("开放ID")
	private String openId;
 
	@ApiModelProperty("用户昵称")
	private String nickName;
 
	@ApiModelProperty("用户姓名")
	private String realName;
 
	@ApiModelProperty("身份证号")
	private String idCard;
  
	@ApiModelProperty("用户性别,1：男；0女；-1:未知；")
	private Integer gender;
 
	@ApiModelProperty("用户生日")
	private long birthday;
 
	@ApiModelProperty("手机号码")
	private String mobile;
 
	@ApiModelProperty("座机号码")
	private String tel;
 
	@ApiModelProperty("邮箱地址")
	private String email;
 
	@ApiModelProperty("所属国家")
	private String country;
 
	@ApiModelProperty("所在省份")
	private String province;
 
	@ApiModelProperty("所在城市")
	private String city;
 
	@ApiModelProperty("所在区域")
	private String district;
 
	@ApiModelProperty("详细地址")
	private String address;
 
	@ApiModelProperty("用户密码")
	private String password;
 
	@ApiModelProperty("用户头像")
	private String headImg;
 
	@ApiModelProperty("创建时间")
	private long createTime;
 
	@ApiModelProperty("状态")
	private Integer status;
 
	@ApiModelProperty("有效性,1:有效；0无效")
	private Integer isValid;
	
 
 
	/**
	 * 获取开放ID
	 * @return java.lang.String
	 */
	public String getOpenId() {
		return this.openId;
	}
	
	/**
	 * 设置开放ID
	 * @param openId
	 * @type java.lang.String
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	/**
	 * 获取用户昵称
	 * @return java.lang.String
	 */
	public String getNickName() {
		return this.nickName;
	}
	
	/**
	 * 设置用户昵称
	 * @param nickName
	 * @type java.lang.String
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * 获取用户姓名
	 * @return java.lang.String
	 */
	public String getRealName() {
		return this.realName;
	}
	
	/**
	 * 设置用户姓名
	 * @param realName
	 * @type java.lang.String
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	/**
	 * 获取身份证号
	 * @return java.lang.String
	 */
	public String getIdCard() {
		return this.idCard;
	}
	
	/**
	 * 设置身份证号
	 * @param idCard
	 * @type java.lang.String
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	/**
	 * 获取用户性别,1：男；0女；-1:未知；
	 * @return Integer
	 */
	public Integer getGender() {
		return this.gender;
	}
	
	/**
	 * 设置用户性别,1：男；0女；-1:未知；
	 * @param gender
	 * @type Integer
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	
	/**
	 * 获取用户生日
	 * @return java.util.Date
	 */
	public long getBirthday() {
		return this.birthday;
	}
	
	/**
	 * 设置用户生日
	 * @param birthday
	 * @type java.util.Date
	 */
	public void setBirthday(long birthday) {
		this.birthday = birthday;
	}
	
	/**
	 * 获取手机号码,加上国际地区号
	 * @return java.lang.String
	 */
	public String getMobile() {
		return this.mobile;
	}
	
	/**
	 * 设置手机号码,加上国际地区号
	 * @param mobile
	 * @type java.lang.String
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * 获取座机号码,加上区号
	 * @return java.lang.String
	 */
	public String getTel() {
		return this.tel;
	}
	
	/**
	 * 设置座机号码,加上区号
	 * @param tel
	 * @type java.lang.String
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 获取邮箱地址
	 * @return java.lang.String
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * 设置邮箱地址
	 * @param email
	 * @type java.lang.String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取所属国家
	 * @return java.lang.String
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * 设置所属国家
	 * @param country
	 * @type java.lang.String
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * 获取所在省份
	 * @return java.lang.String
	 */
	public String getProvince() {
		return this.province;
	}
	
	/**
	 * 设置所在省份
	 * @param province
	 * @type java.lang.String
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	
	/**
	 * 获取所在城市
	 * @return java.lang.String
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * 设置所在城市
	 * @param city
	 * @type java.lang.String
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * 获取所在区域
	 * @return java.lang.String
	 */
	public String getDistrict() {
		return this.district;
	}
	
	/**
	 * 设置所在区域
	 * @param district
	 * @type java.lang.String
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	
	/**
	 * 获取详细地址
	 * @return java.lang.String
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * 设置详细地址
	 * @param address
	 * @type java.lang.String
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取用户密码,使用MD5加密
	 * @return java.lang.String
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * 设置用户密码,使用MD5加密
	 * @param password
	 * @type java.lang.String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * 获取用户头像,是否需要维护头像？
	 * @return java.lang.String
	 */
	public String getHeadImg() {
		return this.headImg;
	}
	
	/**
	 * 设置用户头像,是否需要维护头像？
	 * @param headImg
	 * @type java.lang.String
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	
	/**
	 * 获取创建时间
	 * @return java.util.Date
	 */
	public long getCreateTime() {
		return this.createTime;
	}
	
	/**
	 * 设置创建时间
	 * @param createTime
	 * @type java.util.Date
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取状态
	 * @return Integer
	 */
	public Integer getStatus() {
		return this.status;
	}
	
	/**
	 * 设置状态
	 * @param status
	 * @type Integer
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * 获取有效性,1:有效；0无效
	 * @return Integer
	 */
	public Integer getIsValid() {
		return this.isValid;
	}
	
	/**
	 * 设置有效性,1:有效；0无效
	 * @param isValid
	 * @type Integer
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	
}