package com.airmcl.air.users.dao.ext;

import java.util.List;

import com.airmcl.air.users.enter.EnterUserRelationParams;
import com.airmcl.air.users.out.OutUserRelationship;

public interface UserRelationshipExtMapper {

	List<OutUserRelationship> findfindUserRelationList(EnterUserRelationParams params);
	
	Integer countUserRelation(EnterUserRelationParams params);

}
