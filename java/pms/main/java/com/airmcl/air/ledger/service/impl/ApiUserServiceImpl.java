package com.airmcl.air.ledger.service.impl;

import com.airmcl.air.ledger.enter.CenterChairmanParaVO;
import com.airmcl.air.ledger.service.ApiUserService;
import com.airmcl.basae.utils.GDConstant;
import com.alibaba.fastjson.JSONObject;
import com.els.base.core.exception.CommonException;
import com.els.base.utils.http.HttpGetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @program: air-pms
 * @description:
 * @author: Mr.Chen
 * @create: 2018-06-14 11:20
 **/
@Service("defaultApiUserService")
public class ApiUserServiceImpl implements ApiUserService {

    protected Logger logger = LoggerFactory.getLogger(ApiUserServiceImpl.class);

    @Override
    public JSONObject getCenterChairman(CenterChairmanParaVO vo) {
        String urlQuery = GDConstant.C_WS_SALE_URL + GDConstant.C_WS_SALE_CENTER_CHAIRMAN + "?" + "city=" + vo.getCity()
                + "&area=" + vo.getArea();
        try {
            String zxQuery = HttpGetClient.send(urlQuery);
            JSONObject jsonObject = JSONObject.parseObject(zxQuery);
            if (jsonObject.get("item") != null) {
                return jsonObject.getJSONObject("item");
            }
        } catch (Exception e) {
            logger.error("请求异常:" + e.getMessage());
            throw new CommonException("请求异常"+e.getMessage());
        }
        return null;
    }

    @Override
    public JSONObject getAgentRelation(String mobile) {
        String urlQuery = GDConstant.C_WS_SALE_URL + GDConstant.C_WS_SALE_AGENT_RELATION + "?"
                + "chainType=belong_referrer&chainDeep=2&mobile=" + mobile;
        try {
            String zxQuery = HttpGetClient.send(urlQuery);
            JSONObject jsonObject = JSONObject.parseObject(zxQuery);
            if (jsonObject.get("item") != null) {
                return jsonObject.getJSONObject("item");
            }
        } catch (Exception e) {
            logger.error("请求异常"+e.getMessage());
            throw new CommonException("请求异常"+e.getMessage());
        }
        return null;
    }
}
