package com.airmcl.air.activitys.dao.ext;

import java.util.List;

import com.airmcl.air.activitys.entity.ActivitysBeauty;
import com.airmcl.air.activitys.entity.ActivitysBeautyVo;
import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsVo;
import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesVo;

public interface ActivitysExtMapper {
	
   List<ActivitysCouponsVo> selectActivitysCouponsVoListByActivityId(Integer activityId);
   
   List<ActivitysServicesVo> selectActivitysServicesVoListByActivityId(Integer activityId);
   
   List<ActivitysBeautyVo>selectActivitysBeautyVoListByActivitysId(Integer activityId);
   
   int updateActivitysServicesByActivityId(Integer activityId);
   
   int deleteActivitysCouponsByActivityId(Integer activityId);
   
   int deleteActivitysCouponsByIdBath(List<ActivitysCoupons> list);
   
   int updateActivitysServicesByIdBath(List<ActivitysServices> list);
   
   int updateActivitysBeautyByIdBath(List<ActivitysBeauty> list);
}
