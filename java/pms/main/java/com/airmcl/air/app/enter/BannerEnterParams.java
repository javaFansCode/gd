package com.airmcl.air.app.enter;

import java.io.Serializable;

public class BannerEnterParams implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	private String title ;
	private String tag ;
	private String islink ;
	private Integer[] cityId ;
	private String startcreatetime ;
	private String endcreatetime ;
	private Integer[] state ;
	private Integer pageNo;
	private Integer pageSize;
	
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
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getIslink() {
		return islink;
	}
	public void setIslink(String islink) {
		this.islink = islink;
	}
	public Integer[] getCityId() {
		return cityId;
	}
	public void setCityId(Integer[] cityId) {
		this.cityId = cityId;
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
	public Integer[] getState() {
		return state;
	}
	public void setState(Integer[] state) {
		this.state = state;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
