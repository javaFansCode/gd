package com.airmcl.air.activitys.dao;

import com.airmcl.air.activitys.entity.Activitys;
import com.airmcl.air.activitys.entity.ActivitysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitysMapper {
    int countByExample(ActivitysExample example);

    int deleteByExample(ActivitysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Activitys record);

    int insertSelective(Activitys record);

    List<Activitys> selectByExampleWithBLOBs(ActivitysExample example);

    List<Activitys> selectByExample(ActivitysExample example);

    Activitys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Activitys record, @Param("example") ActivitysExample example);

    int updateByExampleWithBLOBs(@Param("record") Activitys record, @Param("example") ActivitysExample example);

    int updateByExample(@Param("record") Activitys record, @Param("example") ActivitysExample example);

    int updateByPrimaryKeySelective(Activitys record);

    int updateByPrimaryKeyWithBLOBs(Activitys record);

    int updateByPrimaryKey(Activitys record);

    void insertBatch(List<Activitys> list);

    List<Activitys> selectByExampleByPage(ActivitysExample example);
}