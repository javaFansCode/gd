package com.airmcl.air.activitys.dao;

import com.airmcl.air.activitys.entity.ActivitysCoupons;
import com.airmcl.air.activitys.entity.ActivitysCouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitysCouponsMapper {
    int countByExample(ActivitysCouponsExample example);

    int deleteByExample(ActivitysCouponsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitysCoupons record);

    int insertSelective(ActivitysCoupons record);

    List<ActivitysCoupons> selectByExample(ActivitysCouponsExample example);

    ActivitysCoupons selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivitysCoupons record, @Param("example") ActivitysCouponsExample example);

    int updateByExample(@Param("record") ActivitysCoupons record, @Param("example") ActivitysCouponsExample example);

    int updateByPrimaryKeySelective(ActivitysCoupons record);

    int updateByPrimaryKey(ActivitysCoupons record);

    void insertBatch(List<ActivitysCoupons> list);

    List<ActivitysCoupons> selectByExampleByPage(ActivitysCouponsExample example);
}