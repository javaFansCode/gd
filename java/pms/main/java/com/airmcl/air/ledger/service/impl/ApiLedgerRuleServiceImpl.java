package com.airmcl.air.ledger.service.impl;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.airmcl.air.ledger.enter.GoodsLedgerRuleParaVO;
import com.airmcl.air.ledger.out.LedgerRuleVO;
import com.airmcl.air.ledger.service.ApiLedgerRuleService;
import com.airmcl.basae.utils.GDConstant;
import com.airmcl.basae.utils.ThirdPartyURL;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.els.base.core.exception.CommonException;
import com.els.base.utils.http.HttpGetClient;
import com.els.base.utils.http.HttpPostClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.OMGVMCID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: air-pms
 * @description:
 * @author: Mr.Chen
 * @create: 2018-07-23 15:39
 **/
@Service("defaultApiLedgerRuleService")
public class ApiLedgerRuleServiceImpl implements ApiLedgerRuleService {

	protected Logger logger = LoggerFactory.getLogger(ApiLedgerRuleServiceImpl.class);
	
	@Override
	public JSONArray ledgerRuleDetailList(){
		logger.debug("___________ApiLedgerRuleServiceImpl-->ledgerRuleDetailList state  run()***************");
		JSONObject resultJson = new JSONObject();
		JSONArray resultA = new JSONArray();
		String url = ThirdPartyURL.LEDGER_TEST_URL + ThirdPartyURL.GET_LEDGER_RULE_API;
		HashMap jsonMap = new HashMap<>();
		ObjectMapper oMapper = new ObjectMapper();
		try {
			String result = HttpPostClient.send(url);
			resultJson = JSON.parseObject(result);
			logger.debug("----url=【"+url+"】 return param【"+result+"】");
			if(!("200".equals(resultJson.getString("status")))){
				logger.debug(resultJson.getString("msg"));
				throw new CommonException(resultJson.getString("msg"));
			}
			resultA = resultJson.getJSONArray("data");
		} catch (IOException e) {
			logger.error("接口调用出错。"+e.getMessage());
			e.printStackTrace();
		}
		logger.debug("___________ApiLedgerRuleServiceImpl-->ledgerRuleDetailList end  run()***************");
		//获取分账规则
		return resultA;
	}

	@Override
	public JSONObject getCenterChairman(CenterChairmanParaVO vo) {
		logger.debug("___________ApiLedgerRuleServiceImpl-->getCenterChairman state  run()***************");
		logger.debug("___________input param :【"+vo.toString()+"】");
		JSONObject json = new JSONObject();
		JSONObject resultJson = new JSONObject();
		String url = ThirdPartyURL.SGBL_TEST_URL + ThirdPartyURL.SGBL_GET_TEGION_CHAIRMAN+"?city"+vo.getCity()
				+"&area="+vo.getArea();
		try {
			String result = HttpPostClient.send(url);
			resultJson = JSON.parseObject(result);
			logger.debug("----url=【"+url+"】 return param【"+result+"】");
			if (resultJson.get("item") != null) {
				json = resultJson.getJSONObject("item");
			}
		} catch (IOException e) {
			logger.error("接口调用出错。"+e.getMessage());
			e.printStackTrace();
			throw new CommonException("接口调用出错。"+e.getMessage());
		}
		logger.debug("___________ApiLedgerRuleServiceImpl-->getCenterChairman end  run()***************");
		return json;
	}

	@Override
	public JSONObject getAgentRelation(String mobile) {
		logger.debug("___________ApiLedgerRuleServiceImpl-->getAgentRelation state  run()***************");
		logger.debug("___________input param :【mobile="+mobile+"】");
		JSONObject json = new JSONObject();
		JSONObject resultJson = new JSONObject();

		String url = ThirdPartyURL.SGBL_TEST_URL + ThirdPartyURL.SGBL_GET_AUTHORITYINFO_BY_MOBLIE
				+"?chainType=belong_referrer&chainDeep=2&mobile=" + mobile;
		try {
			String result = HttpPostClient.send(url);
			resultJson = JSON.parseObject(result);
			logger.debug("----url=【"+url+"】 return param【"+result+"】");
			if (resultJson.get("item") != null) {
				json = resultJson.getJSONObject("item");
			}
		} catch (IOException e) {
			logger.error("接口调用出错。"+e.getMessage());
			e.printStackTrace();
			throw new CommonException("接口调用出错。"+e.getMessage());
		}
		logger.debug("___________ApiLedgerRuleServiceImpl-->getCenterChairman end  run()***************");
		return json;
	}

	@Override
	public void setGoodsLedgerRule(GoodsLedgerRuleParaVO vo) {

	}
}
