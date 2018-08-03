package com.airmcl.air.activitys.dao;

import com.airmcl.air.activitys.entity.ActivitysBeauty;
import com.airmcl.air.activitys.entity.ActivitysBeautyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitysBeautyMapper {
    int countByExample(ActivitysBeautyExample example);

    int deleteByExample(ActivitysBeautyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivitysBeauty record);

    int insertSelective(ActivitysBeauty record);

    List<ActivitysBeauty> selectByExample(ActivitysBeautyExample example);

    ActivitysBeauty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivitysBeauty record, @Param("example") ActivitysBeautyExample example);

    int updateByExample(@Param("record") ActivitysBeauty record, @Param("example") ActivitysBeautyExample example);

    int updateByPrimaryKeySelective(ActivitysBeauty record);

    int updateByPrimaryKey(ActivitysBeauty record);

    void insertBatch(List<ActivitysBeauty> list);

    List<ActivitysBeauty> selectByExampleByPage(ActivitysBeautyExample example);
}