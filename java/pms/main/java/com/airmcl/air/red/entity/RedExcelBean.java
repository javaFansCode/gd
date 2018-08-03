package com.airmcl.air.red.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.airmcl.basae.utils.DateUtil;

public class RedExcelBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7087858630815475775L;
	private Red red;
	private Integer	id ;
	private String name ;
	private String state ;
	private String starttime;
	private String endtime;
	private String type ;
	private String createtime;

	
    public RedExcelBean(Integer id, String name, String state, String starttime, String endtime, String type,
			String createtime) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.starttime = starttime;
		this.endtime = endtime;
		this.type = type;
		this.createtime = createtime;
	}

	public RedExcelBean(Red red) {
		super();
		this.red = red;
		setId(red.getId());
		setName(red.getName());
		setState(red.getState());
		setStarttime(int2DataString(red.getStarttime()));
		setEndtime(int2DataString(red.getEndtime()));
//		setType(red.getType());
		setCreatetime(int2DataString(red.getCreatetime()));
	}
	
	public Red getRed() {
		return red;
	}
	public void setRed(Red red) {
		this.red = red;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(byte state) {
		//状态 0删除 1开启 2停用（可修改） 3停用（不可修改）
		switch (state) {
		case 0:
			this.state = "删除";
			break;
		case 1:
			this.state = "开启";
			break;
		case 2:
			this.state = "停用";
			break;
		case 3:
			this.state = "停用";
			break;
		default:
			break;
		}
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getType() {
		return "送券";
	}

	public void setType(byte type) {
		// 红包类型 1新用户红包 2老用户支付获得红包 3老用户完成获得红包 4.分享返券红包
		switch (type) {
		case 1:
			this.type = "新用户红包 ";
			break;
		case 2:
			this.type = "老用户支付获得红包";
			break;
		case 3:
			this.type = "老用户完成获得红包";
			break;
		case 4:
			this.type = "分享返券红包";
			break;
		default:
			this.type = "送券";
			break;
		}

	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	private synchronized String int2DataString(Integer time){
		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(new Long(time).longValue()*1000);
		return dateStr;
	}
	
}
