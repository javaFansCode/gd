package com.airmcl.basae.utils;

/**
 * @program: air-pms
 * @description: 第三方url
 * @author: Mr.Chen
 * @create: 2018-07-23 15:39
 **/
public class ThirdPartyURL {

    /**
     * 分账平台-->测试环境
     */
    public final static String LEDGER_TEST_URL = "http://gdzx.airmcl.com/air-bms/";

    /**
     * 分账平台-->正式环境
     */
    public final static String LEDGER_FORMAL_URL = "http://gdzx.airmcl.com/air-bms/";

    /**
     * 获取所有分账规则类型
     */
    public final static String GET_LEDGER_RULE_API = "ledgerRuleApi/api/ledgerRuleDetailList";



    /**
     * 时光部落-->测试环境
     */
    public final static String SGBL_TEST_URL = "https://ws.airmcl.com/wsapi/";

    /**
     * 时光部落-->正式环境
     */
    public final static String SGBL_FORMAL_URL = "";

    /**
     *时光部落-->获取指定区域运营中心主席地址
     */
    public static final String SGBL_GET_TEGION_CHAIRMAN="open/api/operator/user";

    /**
     *时光部落-->根据官总的手机号获取官总信息、直推官总信息和间推官总信息
     */
    public static final String SGBL_GET_AUTHORITYINFO_BY_MOBLIE="open/api/user/chain";













}
