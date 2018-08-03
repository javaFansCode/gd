package com.airmcl.air.ledger.controller;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.airmcl.air.ledger.enter.GoodsLedgerRuleParaVO;
import com.airmcl.air.ledger.out.LedgerRuleVO;
import com.airmcl.air.ledger.service.ApiLedgerRuleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.els.base.core.entity.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("apiLedgerRuleApi")
public class ApiLedgerRuleController {
	
	@Resource
	protected ApiLedgerRuleService apiLedgerRuleService;

	/**
	 * 获取所有分账规则详情
	 * @return
	 */
	@RequestMapping("api/ledgerRuleDetailList")
	@ResponseBody
	public ResponseResult<JSONArray> ledgerRuleDetailList() {
        return ResponseResult.success(this.apiLedgerRuleService.ledgerRuleDetailList());
	}

	/**
	 * 获取指定区域运营中心主席
	 * @param vo
	 * @return
	 */
	@RequestMapping("api/getCenterChairman")
	@ResponseBody
	public ResponseResult<JSONObject> getCenterChairman(@RequestBody CenterChairmanParaVO vo) {
		return ResponseResult.success(this.apiLedgerRuleService.getCenterChairman(vo));
	}

	/**
	 * 根据官总的手机号获取官总信息、直推官总信息和间推官总信息
	 * @param mobile
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET , value = "api/getAgentRelation" )
	@ResponseBody
	public ResponseResult<JSONObject> getAgentRelation(@RequestParam(required=true) String  mobile) {
		return ResponseResult.success(this.apiLedgerRuleService.getAgentRelation(mobile));
	}

	@ApiIgnore
	@ApiOperation(httpMethod = "GET",consumes = "application/json", value = "根据商品与商品ID和分账规则ID设置商品与分账规则对应关系")
	@RequestMapping("api/setGoodsLedgerRule")
	@ResponseBody
	public ResponseResult<String> setGoodsLedgerRule(@RequestBody GoodsLedgerRuleParaVO vo) {
		this.apiLedgerRuleService.setGoodsLedgerRule(vo);
        return ResponseResult.success();
	}

}
