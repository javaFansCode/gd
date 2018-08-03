package com.airmcl.air.users.enter;

import java.io.Serializable;
/**
 * 用户关系列表查询模块 条件查询入参实体
 * @author Administrator
 *
 */
public class EnterUserRelationParams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userId ; 
	private String userPhone;	//用户手机号码  
	private String nickName;
	private String startcreatetime;
	private String endcreatetime;
	private String vipcardName ; //推荐人昵称
	private Integer pageNo ;
	private Integer pageSize ;
	
	public String getVipcardName() {
		return vipcardName;
	}
	public void setVipcardName(String vipcardName) {
		this.vipcardName = vipcardName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStartcreatetime() {
		return startcreatetime;
	}
	public void setStartcreatetime(String startcreatetime) {
		this.startcreatetime = startcreatetime;
	}
	public String getEndcreatetime() {
		return endcreatetime;
	}
	public void setEndcreatetime(String endcreatetime) {
		this.endcreatetime = endcreatetime;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
