package com.airmcl.air.ledger.service;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.airmcl.air.ledger.enter.GoodsLedgerRuleParaVO;
import com.airmcl.air.ledger.out.LedgerRuleVO;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.List;

public interface ApiLedgerRuleService {

	JSONArray ledgerRuleDetailList();

	JSONObject getCenterChairman(CenterChairmanParaVO vo);

	JSONObject getAgentRelation(String  mobile);
	
	void setGoodsLedgerRule(GoodsLedgerRuleParaVO vo);
}
