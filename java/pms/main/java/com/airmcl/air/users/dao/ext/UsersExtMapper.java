package com.airmcl.air.users.dao.ext;

import com.airmcl.air.users.entity.UsersEditRefereeParaVO;
 
public interface UsersExtMapper {
	/**
	 * 编辑会员受益人
	 * @param record
	 * @return
	 */
    int editReferee(UsersEditRefereeParaVO record);
}