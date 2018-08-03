package com.airmcl.basae.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据字典
 * @author Administrator
 */
public class Dictionary {
	
	public static Map<String, String> couponUseTypeMap = new HashMap<String, String>();

	public static Map<String, String> couponStateMap = new HashMap<String, String>();
	
	static {
		 // 优惠券使用类型
		couponUseTypeMap.put("1", "满减");
		couponUseTypeMap.put("2", "现金抵扣");
		couponUseTypeMap.put("3", "直折");
		couponUseTypeMap.put("4", "满折+减额上线");
		couponUseTypeMap.put("5", "满折");
		couponUseTypeMap.put("6", "直折+减额上限");
		
		//优惠券状态
		couponStateMap.put("1", "未使用");
		couponStateMap.put("2", "已使用");
		couponStateMap.put("3", "已过期");
		
	}
	



}
