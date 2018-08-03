package com.airmcl.air.app.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
/**
 * 栏目，项目返回实体类
 * @author Administrator
 */
public class IndexOutColumnAndModel  extends IndexColumn implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty("服务项目名称")
    private String  serviceName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
    
    

}
