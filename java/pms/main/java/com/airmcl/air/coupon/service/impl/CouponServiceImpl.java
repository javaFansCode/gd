package com.airmcl.air.coupon.service.impl;

import com.airmcl.air.coupon.dao.CouponMapper;
import com.airmcl.air.coupon.dao.CouponServiceMapper;
import com.airmcl.air.coupon.dao.UserCouponMapper;
import com.airmcl.air.coupon.enter.EnterUserCouponParams;
import com.airmcl.air.coupon.entity.*;
import com.airmcl.air.coupon.entity.UsersCouponExample.Criteria;
import com.airmcl.air.coupon.out.OutUserCouponDetails;
import com.airmcl.air.coupon.service.CouponService;
import com.airmcl.air.service.dao.ServiceMapper;
import com.airmcl.air.service.entity.ServiceExample;
import com.airmcl.basae.utils.CouponUtils;
import com.airmcl.basae.utils.DateUtil;
import com.airmcl.basae.utils.Dictionary;
import com.airmcl.basae.utils.UserCenterHelper;
import com.airmcl.uc.base.model.AppsToken;
import com.airmcl.uc.token.UCTokenApiServiceImpl;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.utils.excel.ExcelUtils;
import com.els.base.utils.excel.TitleAndModelKey;
import com.els.base.utils.http.HttpGetClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

@Service("defaultCouponService")
public class CouponServiceImpl implements CouponService {
	@Resource
	protected CouponMapper couponMapper;
	@Resource
	protected UserCouponMapper userCouponMapper;
	@Autowired
	protected UCTokenApiServiceImpl ucTokenApiService;
	@Resource
	protected CouponServiceMapper couponServiceMapper;
	@Resource
	protected  ServiceMapper serviceMapper;
	
	@CacheEvict(value = { "coupon" }, allEntries = true)
	@Override
	public void addObj(Coupon t) {
		this.couponMapper.insertSelective(t);
	}

	@CacheEvict(value = { "coupon" }, allEntries = true)
	@Override
	public void deleteObjById(Integer id) {
		this.couponMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "coupon" }, allEntries = true)
	@Override
	public void modifyObj(Coupon t) {
		if (t.getId() == null || t.getId() == 0) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.couponMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "coupon", keyGenerator = "redisKeyGenerator")
	@Override
	public Coupon queryObjById(Integer id) {
		return this.couponMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "coupon", key = "'CouponService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<Coupon> queryAllObjByExample(CouponExample example) {
		return this.couponMapper.selectByExample(example);
	}

	@Cacheable(value = "coupon", key = "'CouponService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<Coupon> queryObjByPage(CouponExample example) {
		PageView<Coupon> pageView = example.getPageView();
		pageView.setQueryResult(this.couponMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 查询优惠券详情列表
	 * 
	 * @throws ParseException
	 * @throws IOException
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	@SuppressWarnings("null")
	@Override
	public PageView<OutUserCouponDetails> findUserCouponDetailsByParams(int pageNo, int pageSize,
			EnterUserCouponParams params) throws Exception {

		AppsToken token = ucTokenApiService.getToken();
		
		PageView<OutUserCouponDetails> resultPageView = new PageView<OutUserCouponDetails>(pageNo, pageSize);

		UsersCouponExample example = new UsersCouponExample();
		example.setOrderByClause("createtime DESC");
		example.setPageView(new PageView<UsersCoupon>(pageNo, pageSize));
		Criteria createCriteria = example.createCriteria();
		if (params.getCouponId() != null) {
			createCriteria.andIdEqualTo(params.getCouponId());
		}
		if (params.getCouponTitle() != null) {
			createCriteria.andCouponTitleLike("%" + params.getCouponTitle() + "%");
		}
		if (params.getStartcreatetime() != null && params.getEndcreatetime() != null) {
			createCriteria.andCreatetimeBetween(params.getStartcreatetime(), params.getEndcreatetime());
		}
		//使用用户中心的手机号码查询
		if (StringUtils.isNotBlank(params.getUserPhone())) {
			//先去用户中心查到用户信息 返回userid 再用userID去查
			JSONObject jsonobj = UserCenterHelper.getUserInfoByMobile(params.getUserPhone(), token);
			if (jsonobj.contains("data")){
				Object object = jsonobj.get("data");
				String openId = ((JSONObject) object).getString("openId");
				params.setUserId(openId);
				createCriteria.andUserIdEqualTo(params.getUserId());
			}else {
				resultPageView.setQueryResult(new ArrayList<OutUserCouponDetails>());
				return resultPageView ;
			}
		}
		
		List<UsersCoupon> listData = userCouponMapper.selectByExampleByPage(example);
		//需要在resultPageView设置的返回的List
		List<OutUserCouponDetails> list = new ArrayList<OutUserCouponDetails>();
		Date date = new Date(System.currentTimeMillis());
		long time = date.getTime();
		long time2 = time / 1000;
			if (listData != null || listData.size() >= 1) {
				for (UsersCoupon usersCoupon : listData) {
					OutUserCouponDetails out = new OutUserCouponDetails();
					out.setUserOpenId(usersCoupon.getUserId());
					out.setCouponTitle(usersCoupon.getCouponTitle());
					out.setCouponId(usersCoupon.getId());
					out.setCity(usersCoupon.getCity());
					out.setBeautyId(usersCoupon.getBeautyId());
					out.setServiceId(usersCoupon.getServiceId());
					out.setUseType(usersCoupon.getUseType() + "");
					out.setMoneyMax(usersCoupon.getMoneyMax() + "");
					out.setMoneyReduce(usersCoupon.getMoneyReduce() + "");
					out.setExpiryType(usersCoupon.getExpiryType());
					Long temp = System.currentTimeMillis() / 1000;
					out.setCreateTime(temp + "");
					out.setExpiresTime(usersCoupon.getExpiresTime());
					// 1，如果expiry_type是无限期 则使用状态不存在失效 3
					if (usersCoupon.getExpiryType() == 1) {
						out.setCouponStartTime(0); //无限期 优惠券开始时间默认为0
						out.setIsUse(usersCoupon.getIsUse()+"");
					} else if (usersCoupon.getExpiryType() == 2) { // 2,如果expiry_type是指定日期，当前时间大于过期时间则失效
						if ((int) time2 > usersCoupon.getExpiresTime()) { //
							out.setIsUse(new String("3"));
						} else if ((int) time2 < usersCoupon.getExpiresTime()) { // 小于过期时间
							out.setIsUse(usersCoupon.getIsUse()+"");
						}
						out.setCouponStartTime(usersCoupon.getStarttime());//设置优惠券开始时间
					}else if(usersCoupon.getExpiryType() == 3){ 		//指定天数
						if ((int) time2 > usersCoupon.getExpiresTime()) { //
							out.setIsUse(new String("3"));
						} else if ((int) time2 < usersCoupon.getExpiresTime()) { // 小于过期时间
							out.setIsUse(usersCoupon.getIsUse()+"");
						}
						//用户领券的时间  如果指定开始天数为0   在送券的时候已经计算过
						out.setCouponStartTime(usersCoupon.getStarttime());
					}
					list.add(out);
				}
				//多个userid查询用户信息
				List<String> openid = new ArrayList<String>();
				if (listData.size() == 1) {
					JSONObject jsonobj = UserCenterHelper.getUserInfoByUcOpenId(listData.get(0).getUserId(), token);
					Object object = jsonobj.get("data");
					String mobile = ((JSONObject) object).getString("mobile");
					String nickName = ((JSONObject) object).getString("nickName");
					list.get(0).setNickName(nickName);
					list.get(0).setUserPhone(mobile);
				}else {
					for (UsersCoupon lis : listData) {
						String userId = lis.getUserId();
						openid.add(userId);
					}
					JSONObject jsonObj = UserCenterHelper.getUserInfoListByUcOpenId(openid, token);
					if("ok".equals(jsonObj.get("errmsg"))) {
						//对应信息
						Map<String, List<OutUserCouponDetails>> map = new HashMap<>(list.size());
						for (OutUserCouponDetails outUserCouponDetails : list) {
							 String key = outUserCouponDetails.getUserOpenId();
							 if(map.containsKey(key)) {
								 map.get(key).add(outUserCouponDetails);
							 }else {
								 List<OutUserCouponDetails> tp = new ArrayList<>();
								 tp.add(outUserCouponDetails);
								 map.put(key, tp);
							 }
						}
						JSONArray obj = (JSONArray) jsonObj.get("data");
						for(int i=0;i<obj.length();i++) {
							JSONObject dt = (JSONObject) obj.get(i);
							String openidStr = (String) dt.get("openId"); //用户中心的openid
							if(map.containsKey(openidStr)) {
								String mobile = (String) dt.get("mobile"); //用户中心的电话号码
								String nickName = (String) dt.get("nickName"); //用户中心的昵称
								List<OutUserCouponDetails> tmpList = map.get(openidStr);
								for (OutUserCouponDetails outUserCouponDetails : tmpList) {
									outUserCouponDetails.setUserPhone(mobile);
									outUserCouponDetails.setNickName(nickName);
								}
							}
						}
					}
				}
				if (listData == null || listData.size() < 1) {
					resultPageView.setPageNo(pageNo);
					resultPageView.setPageSize(pageSize);
					resultPageView.setRowCount(0);
					List<OutUserCouponDetails> lis = new ArrayList<>();
					resultPageView.setQueryResult(lis);
					return resultPageView;
				}
				resultPageView.setPageNo(pageNo);
				resultPageView.setPageSize(pageSize);
				resultPageView.setRowCount(example.getPageView().getRowCount());
				resultPageView.setQueryResult(list);
				return resultPageView;
			}
		return null;
	}

	/**
	 * 导出功能
	 */
	@SuppressWarnings("null")
	@Override
	public WritableWorkbook exportDataToExcel(Integer couponId,String userPhone,String couponTitle,
			String startcreatetime,String endcreatetime, HttpServletResponse response)
			throws Exception {

		AppsToken token = ucTokenApiService.getToken();
		UsersCouponExample example = new UsersCouponExample();
		example.setOrderByClause("createtime DESC");
		Criteria createCriteria = example.createCriteria();
		if (couponId != null) {
			createCriteria.andIdEqualTo(couponId);
		}
		if (StringUtils.isNotBlank(couponTitle)) {
			createCriteria.andCouponTitleLike(couponTitle);
		}
		if (StringUtils.isNotBlank(startcreatetime) && StringUtils.isNotBlank(endcreatetime)) {
			createCriteria.andCreatetimeBetween(startcreatetime, endcreatetime);
		}
		
		//使用用户中心的手机号码查询
		if (StringUtils.isNotBlank(userPhone)) {
			// 先去用户中心查到用户信息 返回userid 再用userID去查
			JSONObject jsonobj = UserCenterHelper.getUserInfoByMobile(userPhone, token);
			Object object = jsonobj.get("data");
			String openId = ((JSONObject) object).getString("openId");
			createCriteria.andUserIdEqualTo(openId);
		}
		List<UsersCoupon> listData = userCouponMapper.selectByExample(example);
		List<OutUserCouponDetails> arrayList = new ArrayList<OutUserCouponDetails>();
		Date date = new Date(System.currentTimeMillis());
		long time = date.getTime();
		long time2 = time / 1000;
		if (listData != null || listData.size() >= 1) {
			for (UsersCoupon usersCoupon : listData) {
				OutUserCouponDetails out = new OutUserCouponDetails();
				out.setCouponId(usersCoupon.getCouponId());
				out.setCouponTitle(usersCoupon.getCouponTitle());
				out.setCity(usersCoupon.getCity());
				out.setBeautyId(usersCoupon.getBeautyId());
				out.setServiceId(usersCoupon.getServiceId());
				out.setUseType(Dictionary.couponUseTypeMap.get(usersCoupon.getUseType() + ""));
				// 满减
				CouponTitleVO couponTitle2 = CouponUtils.getCouponTitle(usersCoupon);
				out.setMoneyMax(couponTitle2.getTitle()); // 满减(一个字段存2个内容)
				Long temp = System.currentTimeMillis() / 1000;
				out.setCreateTime(temp + "");
				out.setExpiresTime(usersCoupon.getExpiresTime());
				if (usersCoupon.getExpiryType() == 1) {
					out.setCouponStartTime(0); //无限期 优惠券开始时间默认为0
					out.setIsUse(usersCoupon.getIsUse()+"");
				} else if (usersCoupon.getExpiryType() == 2 ) { // 2,如果expiry_type是指定日期，当前时间大于过期时间则失效
					if ((int) time2 > usersCoupon.getExpiresTime()) { //
						out.setIsUse(new String("3"));
					} else if ((int) time2 < usersCoupon.getExpiresTime()) { // 小于过期时间
						out.setIsUse(usersCoupon.getIsUse()+"");
					}
					out.setCouponStartTime(usersCoupon.getStarttime());//设置优惠券开始时间
				} else if(usersCoupon.getExpiryType() == 3){ 		//指定天数
					if ((int) time2 > usersCoupon.getExpiresTime()) { //
						out.setIsUse(new String("3"));
					} else if ((int) time2 < usersCoupon.getExpiresTime()) { // 小于过期时间
						out.setIsUse(usersCoupon.getIsUse()+"");
					}
					//用户领券的时间  如果指定开始天数为0
					out.setCouponStartTime(usersCoupon.getStarttime());
				}
				arrayList.add(out);
			}
			//多个userid查询用户信息
//			List<String> openid = new ArrayList<String>();
//			if (listData.size() == 1) { //只有一条数据的时候 去用户中心查就传一个userid 不传userid list集合
//				JSONObject jsonobj = UserCenterHelper.getUserInfoByUcOpenId(listData.get(0).getUserId(), token);
//				Object object = jsonobj.get("data");
//				String mobile = ((JSONObject) object).getString("mobile");
//				String nickName = ((JSONObject) object).getString("nickName");
//				arrayList.get(0).setNickName(nickName);
//				arrayList.get(0).setUserPhone(mobile);
//			}else {
//				for (UsersCoupon lis : listData) {
//					String userId = lis.getUserId();
//					openid.add(userId);
//				}
//				JSONObject jsonObj = UserCenterHelper.getUserInfoListByUcOpenId(openid, token);
//				if("ok".equals(jsonObj.get("errmsg"))) {
//					//对应信息
//					Map<String, List<OutUserCouponDetails>> map = new HashMap<>(arrayList.size());
//					for (OutUserCouponDetails outUserCouponDetails : arrayList) {
//						 String key = outUserCouponDetails.getUserOpenId();
//						 if(map.containsKey(key)) {
//							 map.get(key).add(outUserCouponDetails);
//						 }else {
//							 List<OutUserCouponDetails> tp = new ArrayList<>();
//							 tp.add(outUserCouponDetails);
//							 map.put(key, tp);
//						 }
//					}
//					JSONArray obj = (JSONArray) jsonObj.get("data");
//					for(int i=0;i<obj.length();i++) {
//						JSONObject dt = (JSONObject) obj.get(i);
//						String openidStr = (String) dt.get("openId"); //用户中心的openid
//						if(map.containsKey(openidStr)) {
//							String mobile = (String) dt.get("mobile"); //用户中心的电话号码
//							String nickName = (String) dt.get("nickName"); //用户中心的昵称
//							List<OutUserCouponDetails> tmpList = map.get(openidStr);
//							for (OutUserCouponDetails outUserCouponDetails : tmpList) {
//								outUserCouponDetails.setUserPhone(mobile);
//								outUserCouponDetails.setNickName(nickName);
//							}
//						}
//					}
//				}
//			}
		}
		// 导出
		OutputStream outputStream = response.getOutputStream();
		List<TitleAndModelKey> lists = new ArrayList<TitleAndModelKey>();
		TitleAndModelKey Key1 = new TitleAndModelKey();
		Key1.setColumIndex(0);
		Key1.setTitle("优惠券ID");
		Key1.setModelKey("couponId");
		lists.add(Key1);
		TitleAndModelKey Key10 = new TitleAndModelKey();
		Key10.setColumIndex(0);
		Key10.setTitle("优惠券名称");
		Key10.setModelKey("couponTitle");
		lists.add(Key10);
		TitleAndModelKey Key2 = new TitleAndModelKey();
		Key2.setColumIndex(0);
		Key2.setTitle("可用城市");
		Key2.setModelKey("city");
		lists.add(Key2);
		TitleAndModelKey Key3 = new TitleAndModelKey();
		Key3.setColumIndex(0);
		Key3.setTitle("可用门店");
		Key3.setModelKey("beautyId");
		lists.add(Key3);
		TitleAndModelKey Key4 = new TitleAndModelKey();
		Key4.setColumIndex(0);
		Key4.setTitle("可用项目");
		Key4.setModelKey("serviceId");
		lists.add(Key4);
		TitleAndModelKey Key5 = new TitleAndModelKey();
		Key5.setColumIndex(0);
		Key5.setTitle("使用类型");
		Key5.setModelKey("useType");
		lists.add(Key5);
		TitleAndModelKey Key6 = new TitleAndModelKey();
		Key6.setColumIndex(0);
		Key6.setTitle("规则详情");
		Key6.setModelKey("moneyMax");
		lists.add(Key6);
		TitleAndModelKey Key7 = new TitleAndModelKey();
		Key7.setColumIndex(0);
		Key7.setTitle("优惠券状态");
		Key7.setModelKey("isUse");
		lists.add(Key7);
		TitleAndModelKey Key8 = new TitleAndModelKey();
		Key8.setColumIndex(0);
		Key8.setTitle("创建时间");
		Key8.setModelKey("createTime");
		lists.add(Key8);
		TitleAndModelKey key9 = new TitleAndModelKey();
		key9.setColumIndex(0);
		key9.setTitle("过期时间");
		key9.setModelKey("expiresTime");
		lists.add(key9);
		WritableWorkbook exportDataToExcel = ExcelUtils.exportDataToExcel(outputStream, lists, arrayList, "sheet1", "",
				0);
		return exportDataToExcel;
	}

	@Transactional
	@Override
	public void sendCouponByHand(String mobile, String couponId) {

		if (StringUtils.isBlank(mobile)) {
			throw new CommonException("手机号码不能为空");
		}
		// 通过号码去用户中心拿到用户信息 user_id
		AppsToken token = ucTokenApiService.getToken();

		String url = "https://passport.airmcl.com/uc/api/apps/member/query?token=" + token.getToken() + "&timestamp="
				+ token.getTimestamp() + "&appId=" + token.getAppId() + "&selKey=mobile&selValue=" + mobile;
		// 发送get请求
		try {
			String str = HttpGetClient.send(url);
			ObjectMapper oMapper = new ObjectMapper();

			HashMap hMap = new HashMap<>();
			hMap = oMapper.readValue(str, HashMap.class);

			Date date = new Date();
			long time = date.getTime();
			long nowTime = time / 1000;
			HashMap Map = (HashMap) hMap.get("data");
			if (Map == null) { // 有数据
				throw new CommonException("无该用户!");
			} else {
				String userid = (String) Map.get("openId");// 用户id
				// 1,通过couponid查询所有优惠券信息
				CouponExample example = new CouponExample();
				String[] strs = couponId.split(",");

				for (String string : strs) {
					Integer couponid = Integer.parseInt(string);
					Coupon coupon = couponMapper.selectByPrimaryKey(couponid);
					//设置优惠券表的领取数
					coupon.setTeceiveTotal(coupon.getTeceiveTotal()+1);
					couponMapper.updateByPrimaryKey(coupon);
					UsersCoupon uc = new UsersCoupon();
					uc.setUserId(userid);
					uc.setCouponId(coupon.getId());
					uc.setCouponTitle(coupon.getCouponTitle());
					uc.setSendType((byte)0); // 赠送类型 0:指派 ,1:注册 ,2:好评,3兑换码',
					uc.setType(coupon.getType());
					uc.setUseType(coupon.getUseType());
					uc.setMoneyMax(coupon.getMoneyMax());
					uc.setMoneyReduce(coupon.getMoneyReduce());
					uc.setMoneyAmount(coupon.getMoneyAmount());
					if (coupon.getDiscount() == null) {
						uc.setDiscount(0F);
					} else {
						uc.setDiscount(coupon.getDiscount());
					}
					uc.setUseTime(0); // 优惠券使用时间 默认为0
					uc.setExpiryType(coupon.getExpiryType());
					if (coupon.getExpiryType() == 1) { // 无限期
						uc.setStarttime(0);
						uc.setExpiresTime(2145888000); // 过期时间 30年
					} else if (coupon.getExpiryType() == 2) { // 2指定日期 起止日期和coupon主表的起止日期是对应的
																// 因为coupon主表的expiry是可以存时间戳的也可以存天数
						uc.setStarttime(coupon.getStarttime());
						uc.setExpiresTime(coupon.getExpiry());
					} else { // 3指定天数
						Integer extime = coupon.getExpiry() * 86400;
						Integer nowt = new Long(nowTime).intValue();
						uc.setStarttime(nowt+coupon.getStarttime()*86400);
						uc.setExpiresTime(nowt + extime);
					}
					// uc.setItemType(Dictionary.USER_COUPON_ITEMTYPE_MEET); // 预约，直购，全部
					uc.setItemType((byte) 3); // 预约，直购，全部
					if (coupon.getReduceMax() == null) {
						uc.setReduceMax(new BigDecimal(0));
					} else {
						uc.setReduceMax(new BigDecimal(coupon.getReduceMax().toString()));
					}
					// uc.setIsUse(Dictionary.USER_COUPON_USESTATE_NAVER);//使用情况 未使用
					uc.setIsUse((byte) 1);// 使用情况 未使用
					uc.setIsService(coupon.getIsService());
					uc.setIsMcard(coupon.getIsMcard());
					uc.setIsVcard(coupon.getIsVcard());
					// 通过优惠券id去mdd_api_coupon_service中间表查可用项目
					CouponServiceExample csExample = new CouponServiceExample();
					csExample.createCriteria().andCouponIdEqualTo(couponid).andStateEqualTo((byte)1);
//					List<Integer> sid = new ArrayList<Integer>();
					List<com.airmcl.air.coupon.entity.CouponService> csList = couponServiceMapper.selectByExample(csExample);
					if (csList.size() > 0) {
						String serviceId ="";
						for (int i = 0; i < csList.size(); i++) {
							com.airmcl.air.coupon.entity.CouponService cst = csList.get(i);
							if (i==0) {
								serviceId = cst.getServiceId().toString();
							}else {
								serviceId = serviceId+","+cst.getServiceId().toString();
							}
						}
						uc.setServiceId(serviceId);
					} else {
						uc.setServiceId("0");
					}
					uc.setMcardId(coupon.getMcardId());
					uc.setVcardId(coupon.getVcardId());
					uc.setCity(coupon.getCity());
					uc.setBeautyId(coupon.getBeautyId());
					uc.setState(coupon.getState());
					uc.setCreatetime(String.valueOf(nowTime));
					userCouponMapper.insert(uc);
				}
			}
		} catch (IOException e) {
			throw new CommonException("查询用户信息失败！");
		}

	}

	@Transactional
	@Override
	public int saveCouponServiceDetail(CouponVO coupon) throws RuntimeException {
		int result = 0 ;
    	coupon.setState((byte)1);//状态(0:删除,1:开启,2:关闭)|
    	coupon.setCreatetime(String.valueOf( DateUtil.getTimeLong()) );
    	coupon.setUpdatetime(String.valueOf( DateUtil.getTimeLong()) );
    	coupon.setTeceiveTotal(0);//领取数
    	result = couponMapper.insertSelective(coupon);
		String serviceId = coupon.getServiceId();
		if(!StringUtils.isEmpty(serviceId)){
			String[] serviceIdAddr = serviceId.split(",");
			List<com.airmcl.air.coupon.entity.CouponService> list = new ArrayList<com.airmcl.air.coupon.entity.CouponService>(serviceIdAddr.length);
			List<Integer> values = new ArrayList<Integer>(serviceIdAddr.length);
			for (String sId : serviceIdAddr) {
				Integer serId = Integer.valueOf(sId);
				values.add(serId);
			  }
			ServiceExample example = new ServiceExample();
			example.createCriteria().andIdIn(values);
			List<com.airmcl.air.service.entity.Service> dbService = serviceMapper.selectByExample(example);
			if(dbService!=null&&dbService.size()>0){
				for (com.airmcl.air.service.entity.Service service : dbService) {
					 com.airmcl.air.coupon.entity.CouponService cService=new com.airmcl.air.coupon.entity.CouponService();
					 cService.setCouponId(coupon.getId());
		             cService.setServiceId(service.getId());
		             cService.setServiceName(service.getServiceName());
		             cService.setState((byte)1);//使用情况 0删除，1正常
		             list.add(cService);
				}
			}
			if(!list.isEmpty()){
				 couponServiceMapper.insertBatch(list);
				 result = result+serviceIdAddr.length;
			}
		}
		return result;
	}
}