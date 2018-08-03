package com.airmcl.air.goods.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.scheduler.service.CouponJobService;
import com.els.base.core.entity.ResponseResult;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("testController")
public class TestController {

	@Resource
	protected CouponJobService couponJobService;
	
	@ApiOperation(httpMethod = "GET", value = "获取所有无忧卡列表")
	@RequestMapping(method = RequestMethod.GET, value = "service/test")
	@ResponseBody
	public ResponseResult<String> test() {
		int result = couponJobService.batchUpdateCouponState();
		return ResponseResult.success(result+"");
	}
}
