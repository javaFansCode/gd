package com.airmcl.basae.utils;

public  class GDConstant {
	/**
	 * 应用名称
	 */
	public static final String C_APPLICATION_NAME="GDZX";
	/**
	 * 应用ID
	 */
	public static final String C_APPLICATION_NO="MCL2018020110064508";
	/**
	 * 应用KEY
	 */
	public static final String C_APPLICATION_KEY="hm8CSakrSKFaW3nMJIbGvPuhioa9kAFlCcyCnytQLF5IjCgLLF7bwbOzuHqOvyxZ";
	
	
	/****************************************光电中心*************************************/
	
	/**
	 * 光电中心URL
	 */
	public static final String C_GDZX_URL = "http://gdzx.airmcl.com/air-bms";  
	//public static final String C_GDZX_URL = "http://47.100.96.113:28080/air-bms";  
	/**
	 * 支付
	 */
	public static final String C_GDZX_USERPAY= "/pay/api/userPay";  
	/**
	 * 支付回调
	 */
	public static final String C_GDZX_PAY_CALLBACK = "/pay/api/userPayCallback";  

	/**
	 * 实名认证回调
	 */
	public static final String C_GDZX_USER_AUTH_CALLBACK = "/userRegisterYeepay/api/userAuthCallback";  
	
	/**
	 * 验证月无忧卡
	 */
	public static final String C_GDZX_CAREFREECARD_CARDVALID = "/carefreeCard/api/CardValid";  
	
	/**
	 * 兑换会员续费卡
	 */
	public static final String C_GDZX_CAREFREECARD_CAREFREECARDEXCHANGE = "/carefreeCard/api/carefreeCardExchange";
	
	/****************************************支付中心begin*************************************/
	
	
	
	/**
	 *支付中心外网发布URL
	 */
	public static final String C_PAY_URL = "http://pay.airmcl.com/air-payment-center";  
	//
	/**
	 * 支付中心云美阿里云内网发布URL
	 */
	//public static final String C_PAY_URL = "http://10.9.4.245:38080/air-payment-center";  
	/**
	 * 用户查询
	 */
	public static final String C_PAY_USER_QUERY = "/pay/user/queryUserInfo";

	/**
	 * 获取普通用户信息
	 */
	public static final String C_PAY_USER_ORDINARY = "/pay/user/getOrdinaryUserInfo";
	
	/**
	 * 获取分账用户信息
	 */
	public static final String C_PAY_USER_LEDGER = "/pay/user/getLedgerUserInfo";
	
	/**
	 * 实名认证
	 */
	public static final String C_PAY_USER_AUTH = "/pay/user/auth";
	
	
	
	/**
	 * 用户注册钱麦接口
	 */
	public static final String C_PAY_USER_REGISTER = "/pay/user/register";
 
	/**
	 * 用户下单
	 */
	public static final String C_PAY_USER_CONSUME = "/pay/order/userConsume";

	/**
	 * 获取Token
	 */
	public static final String C_PAY_AUTH_TOKEN = "/auth/getToken";
	
	/**
	 * 分账
	 */
	public static final String C_PAY_DIVIDE_SPLIT = "/pay/divide/split";
	
	/**
	 * 商户转账
	 */
	public static final String C_PAY_TRANSFER_MERCHANTTRANSFER = "/pay/transfer/merchantTransfer";
	/****************************************支付中心end*************************************/

	/****************************************美滴滴 begin*************************************/
	
	
	/**
	 * 美滴滴
	 */
	public static final String C_MDD_URL="http://gd.api.mdd.airmcl.com/index.php/v1.0.1/";
	/**
	 * 美滴滴订单支付
	 */
	public static final String C_MDD_PAY_ORDER="OrderPay/payOrder";
	/**
	 *美滴滴订单详情
	 */
	public static final String C_MDD_ORDERSHOW="UserOrder/orderShow";
	/**
	 *美滴滴获取体验店详情
	 */
	public static final String C_MDD_BEAUTYDESC="Beauty/beautyDesc";
	
	/**
	 *美滴滴获取会员受益人
	 */
	public static final String C_MDD_USER_BENEFIC="User/benefic";
	/**
	 * 获取会员卡商品
	 */
	public static final String C_MDD_GOODS_GET_VIP_CARD_LIST="Goods/getVipCardList";
	/***
	 * 会员卡赠送
	 */
	public static final String C_MDD_USER_VIP_CARD_LIST="User/vipCardSend";
	
	/****************************************美滴滴  end*************************************/
	
	/****************************************时光部落 begin*************************************/
	/**
	 * 时光部落
	 */
	//作废public static final String C_WS_SALE_URL = "http://passport.airmcl.com/wsapi/";  
	public static final String C_WS_SALE_URL = "https://ws.airmcl.com/wsapi/"; 
 
	/**
	 *时光部落  获取指定区域运营中心主席地址
	 */
	public static final String C_WS_SALE_CENTER_CHAIRMAN="open/api/operator/user";
	/**
	 *时光部落  根据官总的手机号获取官总信息、直推官总信息和间推官总信息
	 */
	public static final String C_WS_SALE_AGENT_RELATION="open/api/user/chain";
	/**
	 * 时光部落 根据用户的uc_openid获取售姬官总
	 */
	public static final String C_WS_SALE_RELATION="open/api/user/relation";
	/****************************************时光部落end*************************************/
	
	/****************************************用户中心 begin*************************************/
	/**
	 * 用户中心url
	 */
	public static final String C_USER_URL = "http://passport.airmcl.com/"; 
	/**
	 * 用户中心的用户信息
	 */
	public static final String C_USER_URL_MEMBER="uc/api/apps/member/query";
	
	/****************************************用户中心 end*************************************/
	
  
}
