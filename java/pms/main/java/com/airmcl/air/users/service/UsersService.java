package com.airmcl.air.users.service;

import com.airmcl.air.users.enter.EnterUserRelationParams;
import com.airmcl.air.users.entity.Users;
import com.airmcl.air.users.entity.UsersEditRefereeParaVO;
import com.airmcl.air.users.entity.UsersExample;
import com.airmcl.air.users.out.OutUserRelationship;
import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;

public interface UsersService extends BaseService<Users, UsersExample, Integer> {
	/**
	 * 编辑会员受益人
	 * @param record
	 * @return
	 */
    int editReferee(UsersEditRefereeParaVO record);

    /**\
     * 用户关联关系查询页
     * @param params
     */
    PageView<OutUserRelationship>  findUserRelationByPage(EnterUserRelationParams params,int pageNo,int pageSize);
}