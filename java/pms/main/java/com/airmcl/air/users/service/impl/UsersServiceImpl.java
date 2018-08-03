package com.airmcl.air.users.service.impl;

import com.airmcl.air.users.dao.UsersMapper;
import com.airmcl.air.users.dao.ext.UserRelationshipExtMapper;
import com.airmcl.air.users.dao.ext.UsersExtMapper;
import com.airmcl.air.users.enter.EnterUserRelationParams;
import com.airmcl.air.users.entity.Users;
import com.airmcl.air.users.entity.UsersEditRefereeParaVO;
import com.airmcl.air.users.entity.UsersExample;
import com.airmcl.air.users.out.OutUserRelationship;
import com.airmcl.air.users.service.UsersService;
import com.airmcl.basae.utils.UserCenterHelper;
import com.airmcl.uc.base.model.AppsToken;
import com.airmcl.uc.token.UCTokenApiServiceImpl;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.els.base.core.entity.PageView;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("defaultUsersService")
public class UsersServiceImpl implements UsersService {
	@Resource
	protected UsersMapper usersMapper;
	@Resource
	protected UsersExtMapper usersExtMapper;
	@Resource
	protected UserRelationshipExtMapper userRelationshipExtMapper;
	@Autowired
	protected UCTokenApiServiceImpl ucTokenApiService;

	@CacheEvict(value = { "users" }, allEntries = true)
	@Override
	public void addObj(Users t) {
		this.usersMapper.insertSelective(t);
	}

	@CacheEvict(value = { "users" }, allEntries = true)
	@Override
	public void deleteObjById(Integer id) {
		this.usersMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "users" }, allEntries = true)
	@Override
	public void modifyObj(Users t) {
		if (t.getId() == null || t.getId() == 0) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.usersMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "users", keyGenerator = "redisKeyGenerator")
	@Override
	public Users queryObjById(Integer id) {
		return this.usersMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "users", key = "'UsersService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<Users> queryAllObjByExample(UsersExample example) {
		return this.usersMapper.selectByExample(example);
	}

	@Cacheable(value = "users", key = "'UsersService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<Users> queryObjByPage(UsersExample example) {
		PageView<Users> pageView = example.getPageView();
		pageView.setQueryResult(this.usersMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 编辑会员受益人
	 * 
	 * @param record
	 * @return
	 */
	public int editReferee(UsersEditRefereeParaVO record) {
		return usersExtMapper.editReferee(record);
	}

	/**
	 * \ 用户关联关系查询页
	 * 
	 * @param params
	 */
	@Override
	public PageView<OutUserRelationship> findUserRelationByPage(EnterUserRelationParams params, int pageNo,
			int pageSize) {
		AppsToken token = ucTokenApiService.getToken();
		PageView<OutUserRelationship> resultPageView = new PageView<OutUserRelationship>(pageNo, pageSize);
		// 分页数据
		params.setPageNo((pageNo - 1) * pageSize);
		params.setPageSize(pageSize);
		if (StringUtils.isNotBlank(params.getUserPhone())) {
			//先去用户中心查到用户信息 返回userid 再用userID去查
			JSONObject jsonobj = UserCenterHelper.getUserInfoByMobile(params.getUserPhone(), token);
			if(jsonobj.contains("data")){
				Object object = jsonobj.get("data");
				String openId = ((JSONObject) object).getString("openId");
				params.setUserId(openId);
			}else{
				List<OutUserRelationship> list = new ArrayList<>();
				resultPageView.setQueryResult(list);
				return  resultPageView;
			}
		}
		
		List<OutUserRelationship> listData = userRelationshipExtMapper.findfindUserRelationList(params);
		// 判断是否是会员
		for (OutUserRelationship outrs : listData) {
			Integer state = outrs.getState(); // 关联状态:1未注册 2.已注册',
			if (state == 1) {
				outrs.setUserType("普通用户");
			} else {
				// 如果注册了 那么去user表判断会员卡到期时间
				Integer vipExpire = outrs.getVipExpire();
				Date date = new Date();
				long time = date.getTime();
				long nowTime = time / 1000;
				//如果在user表里有vip卡的编号 表明是会员  
				if (StringUtils.isNotBlank(outrs.getVipNumber())) { 
					if (vipExpire > Integer.valueOf(nowTime + "")) {
						outrs.setUserType("时光姬会员");
					} else if (vipExpire <= Integer.valueOf(nowTime + "")) {
						outrs.setUserType("普通用户");
					}	
				}else {
					outrs.setUserType("普通用户");
				}
			}
		}
		// 多个userid查询用户信息
		List<String> openid = new ArrayList<String>();
		if (listData.size() == 1) { // 如果只有单个则用另一个调用户中心的方法
			JSONObject jsonobj = UserCenterHelper.getUserInfoByUcOpenId(listData.get(0).getUserId(), token);
				Object object = jsonobj.get("data");
				if (object!=null){
				String mobile = ((JSONObject) object).getString("mobile");
				String nickName = ((JSONObject) object).getString("nickName");
				listData.get(0).setVipcardName(nickName);
				listData.get(0).setRefereePhone(mobile);}
		} else {
			for (OutUserRelationship lis : listData) {
				String userId = lis.getUserId();
				openid.add(userId);
			}
			JSONObject jsonObj = UserCenterHelper.getUserInfoListByUcOpenId(openid, token);
			if ("ok".equals(jsonObj.get("errmsg"))) {
				// 对应信息
				Map<String, List<OutUserRelationship>> map = new HashMap<>(listData.size());
				for (OutUserRelationship outUserRelationship : listData) {
					String key = outUserRelationship.getUserId();
					if (map.containsKey(key)) {
						map.get(key).add(outUserRelationship);
					} else {
						List<OutUserRelationship> tp = new ArrayList<>();
						tp.add(outUserRelationship);
						map.put(key, tp);
					}
				}
				JSONArray obj = (JSONArray) jsonObj.get("data");
				for (int i = 0; i < obj.length(); i++) {
					JSONObject dt = (JSONObject) obj.get(i);
					String openidStr = (String) dt.get("openId"); // 用户中心的openid
					if (map.containsKey(openidStr)) {
						String mobile = (String) dt.get("mobile"); // 用户中心的电话号码
						String nickName = (String) dt.get("nickName"); // 用户中心的昵称
						List<OutUserRelationship> tmpList = map.get(openidStr);
						for (OutUserRelationship outUserRelationship : tmpList) {
							outUserRelationship.setRefereePhone(mobile);
							outUserRelationship.setVipcardName(nickName);
						}
					}
				}
			}
		}
		if (listData == null || listData.size() < 1) {
			resultPageView.setPageNo(pageNo);
			resultPageView.setPageSize(pageSize);
			resultPageView.setRowCount(0);
			List<OutUserRelationship> list = new ArrayList<>();
			resultPageView.setQueryResult(list);
			return resultPageView;
		}
		// 总条数
		Integer count = this.userRelationshipExtMapper.countUserRelation(params);
		// 数据总记录数
		resultPageView.setPageNo(pageNo);
		resultPageView.setPageSize(pageSize);
		resultPageView.setRowCount(count);
		resultPageView.setQueryResult(listData);

		return resultPageView;
	}
}