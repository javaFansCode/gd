package com.airmcl.air.app.entity;

import java.io.Serializable;

/**
 * 栏目，项目查询条件实体类
 * @author Administrator
 */
public class IndexEnterColumnAndModelParams implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id ;
	private String title ;
	private Integer type[];
	private Integer cityId[];
	private Integer startUpdateTime;
	private Integer endUpdateTime;
	private Integer	startCreateTime;
	private Integer	endCreateTime;
	private Integer state[] ;
	private Integer pageNo ;
	private Integer pageSize ;
	
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
	public Integer[] getType() {
		return type;
	}
	public void setType(Integer[] type) {
		this.type = type;
	}
	public Integer[] getCityId() {
		return cityId;
	}
	public void setCityId(Integer[] cityId) {
		this.cityId = cityId;
	}
	public Integer getStartUpdateTime() {
		return startUpdateTime;
	}
	public void setStartUpdateTime(Integer startUpdateTime) {
		this.startUpdateTime = startUpdateTime;
	}
	public Integer getEndUpdateTime() {
		return endUpdateTime;
	}
	public void setEndUpdateTime(Integer endUpdateTime) {
		this.endUpdateTime = endUpdateTime;
	}
	public Integer getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(Integer startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public Integer getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(Integer endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	public Integer[] getState() {
		return state;
	}
	public void setState(Integer[] state) {
		this.state = state;
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
	
}
