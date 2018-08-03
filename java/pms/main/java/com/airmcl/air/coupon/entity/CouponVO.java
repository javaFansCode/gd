package com.airmcl.air.coupon.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
 
@ApiModel(value="优惠券表")
public class CouponVO extends  Coupon {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("项目id逗号隔开")
    private String serviceId;
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
   
    
}