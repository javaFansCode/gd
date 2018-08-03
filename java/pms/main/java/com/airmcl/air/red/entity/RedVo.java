package com.airmcl.air.red.entity;

import java.util.ArrayList;
import java.util.List;

public class RedVo {
     private Red red;
     
     private List<RedEventVo> redEventVoList = new ArrayList<>();

	 public Red getRed() {
		return red;
	 }

	public void setRed(Red red) {
		this.red = red;
	 }

	public List<RedEventVo> getRedEventVoList() {
		return redEventVoList;
	 }

	public void setRedEventVoList(List<RedEventVo> redEventVoList) {
		this.redEventVoList = redEventVoList;
	}
     
}
