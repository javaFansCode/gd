package com.airmcl.air.ledger.service;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.alibaba.fastjson.JSONObject;

public interface ApiUserService {
    /**
     * 获取指定区域运营中心主席
     * @param vo
     * @return
     */
    JSONObject getCenterChairman(CenterChairmanParaVO vo);

    /**
     * 根据官总的手机号获取官总信息、直推官总信息和间推官总信息
     * @param mobile
     * @return
     */
    JSONObject getAgentRelation(String  mobile);
}
