package com.airmcl.air.beautician.out;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 技师关联服务项目返回对象
 * 
 * @author Administrator
 *
 */
public class BeauticianRelationsServiceOut implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("ID")
	private Integer id;
	
	@ApiModelProperty("关联关系表id")
	private Integer relationsId;

	@ApiModelProperty("项目名称")
	private String serviceName;

	@ApiModelProperty("项目封面图")
	private String serviceCover;

	@ApiModelProperty("状态(0:删除 ,1:正常)")
	private Integer state;

	@ApiModelProperty("门店id")
	private Integer beautyId;
	
	public Integer getBeautyId() {
		return beautyId;
	}

	public void setBeautyId(Integer beautyId) {
		this.beautyId = beautyId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getServiceCover() {
		return serviceCover;
	}

	public void setServiceCover(String serviceCover) {
		this.serviceCover = serviceCover;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Integer getRelationsId() {
		return relationsId;
	}
	public void setRelationsId(Integer relationsId) {
		this.relationsId = relationsId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
