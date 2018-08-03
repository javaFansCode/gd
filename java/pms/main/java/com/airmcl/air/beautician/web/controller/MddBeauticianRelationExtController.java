package com.airmcl.air.beautician.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.airmcl.air.beautician.service.MddBeauticianService;
import com.els.base.core.exception.CommonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airmcl.air.beautician.enter.BeauticianServiceEnterParams;
import com.airmcl.air.beautician.out.BeauticianRelationsServiceOut;
import com.airmcl.air.beautician.service.BeauticianRelationsService;
import com.els.base.core.entity.ResponseResult;

@Controller
@RequestMapping("beauticianRelationsExt")
public class MddBeauticianRelationExtController {

	@Resource
    protected BeauticianRelationsService beauticianRelationsService;

	@Resource
	protected MddBeauticianService mddBeauticianService;
	/**
	 * 获取技师关联的服务项目列表
	 * 根据技师id查询技师关系表
	 * @param enterParams
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "service/selectServiceByBeauticianId")
	@ResponseBody
	public ResponseResult<List<BeauticianRelationsServiceOut>> selectServiceByBeauticianId(
			@RequestBody BeauticianServiceEnterParams enterParams) {
		if (enterParams.getBeauticianId()== 0) {
			throw new CommonException("技师id不能为空");
		}
		if (enterParams.getBeautyId()== 0) {
			throw new CommonException("门店id不能为空");
		}
		return ResponseResult.success(this.mddBeauticianService.getBeauticianAssociationProject(enterParams));
	}
	
	/**
	 * 技师关联服务项目操作接口
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "service/goRelationshipByBeauticianAndService")
	@ResponseBody
	public ResponseResult<String> goRelationshipByBeauticianAndService(
		@RequestBody BeauticianServiceEnterParams enterParams){
		this.mddBeauticianService.inserBeauticianAssociationProject(enterParams);
		return ResponseResult.success();
	}
	

}
