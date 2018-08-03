package com.airmcl.air.apiuc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value="用户中心api")
@Controller
@RequestMapping("apiuc")
public class ApiUCController {
//	
//	Logger logger = LoggerFactory.getLogger(ApiUCController.class); 
//	@Autowired 
//	UCTokenApiServiceImpl impl;
//
//    @RequestMapping(method = RequestMethod.GET, value = "service/findAll" )
//    @ResponseBody
//    public ResponseResult<List<Users>> findAll() {
//    
//        //List<Users> list=this.usersService.queryAllObjByExample(example);
//        	return ResponseResult.success(list);
//    }
//
//    /**
//	 * 获取用户信息
//	 * @param mobile
//	 * @param type
//	 * @return
//	 */
//	public ResponseResult<List<MemberManager>>   getMember(String mobile,String type){
//		
// 
//		    AppsToken token=impl.getToken();
//	 
//		    String url =  GDConstant.C_USER_URL+GDConstant.C_USER_URL_MEMBER;
//			
//			HashMap<String, Object> params=new HashMap<String, Object>();
//			params.put("token", token.getToken());//给钱麦传递的订单金额和需支付金额是一致的。
//			params.put("timestamp", token.getTimestamp());
//			params.put("appId", token.getAppId());
//			if(type.equals("mobile"))
//			{
//				params.put("selKey", "mobile");
//			}else if(type.equals("openid")) {
//				params.put("selKey", "openid");
//			}
//			params.put("selValue", mobile); 
// 
//			
//	 
//			String  resultMsg=HttpClentYM.httpPostFromData(url, params);
//			ObjectMapper oMapper=new ObjectMapper();
//			@SuppressWarnings("rawtypes")
//			HashMap hMap=new HashMap<>();
//			try {
//				hMap = oMapper.readValue(resultMsg, HashMap.class);
//			} catch ( Exception e1) {
//				 
//				e1.printStackTrace();
//			} 
//			if(Integer.parseInt(hMap.get("errcode").toString()) ==0)
//			{
//				if(hMap.get("data")!=null)
//				{
//					MemberManager mm=new MemberManager();
//					 try {
//						//BeanUtils.copyProperties(mm, hMap.get("data"));
//					} catch ( Exception e) {
//						logger.error(e.getMessage());
//					}  
//					 jResult.setData(mm);
//					 jResult.setMsg(HttpStatusCodeEnum.HTTP_SUCCESS.getDesc());
//					 jResult.setStatus(HttpStatusCodeEnum.HTTP_SUCCESS.getCode());
//					 return jResult;
//				}else{
//					jResult.setMsg(HttpStatusCodeEnum.HTTP_NOT_FOUND.getDesc());
//					jResult.setStatus(HttpStatusCodeEnum.HTTP_NOT_FOUND.getCode());
//					jResult.setData(null);
//				}
//			}else{
//				jResult.setMsg(hMap.get("errmsg").toString());
//				jResult.setStatus(hMap.get("errcode").toString());
//				jResult.setData(null);
//			}
//			ResponseResult.success(jResult);
//	}
}