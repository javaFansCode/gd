package com.airmcl.air.beauty.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 

@ApiModel(value="门店项目关联VO")
public class BeautyRelationsListVO extends BeautyRelations {
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("美容院名称")
    private String beautyName;
	public String getBeautyName() {
		return beautyName;
	}
	public void setBeautyName(String beautyName) {
		this.beautyName = beautyName;
	}
 
}