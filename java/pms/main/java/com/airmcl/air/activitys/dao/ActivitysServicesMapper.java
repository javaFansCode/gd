package com.airmcl.air.activitys.dao;

import com.airmcl.air.activitys.entity.ActivitysServices;
import com.airmcl.air.activitys.entity.ActivitysServicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitysServicesMapper {
    int countByExample(ActivitysServicesExample example);

    int deleteByExample(ActivitysServicesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitysServices record);

    int insertSelective(ActivitysServices record);

    List<ActivitysServices> selectByExample(ActivitysServicesExample example);

    ActivitysServices selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivitysServices record, @Param("example") ActivitysServicesExample example);

    int updateByExample(@Param("record") ActivitysServices record, @Param("example") ActivitysServicesExample example);

    int updateByPrimaryKeySelective(ActivitysServices record);

    int updateByPrimaryKey(ActivitysServices record);

    void insertBatch(List<ActivitysServices> list);

    List<ActivitysServices> selectByExampleByPage(ActivitysServicesExample example);
}