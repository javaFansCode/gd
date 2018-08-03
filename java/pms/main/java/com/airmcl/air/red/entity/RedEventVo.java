package com.airmcl.air.red.entity;

import java.util.List;

public class RedEventVo extends RedEvent {
	private static final long serialVersionUID = -8867366975762317855L;
    List<RedEventGiftVo> redEventGiftVoList;
	public List<RedEventGiftVo> getRedEventGiftVoList() {
		return redEventGiftVoList;
	}
	public void setRedEventGiftVoList(List<RedEventGiftVo> redEventGiftVoList) {
		this.redEventGiftVoList = redEventGiftVoList;
	}
    
}
