package com.airmcl.air.red.dao;

import com.airmcl.air.red.entity.Red;
import com.airmcl.air.red.entity.RedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedMapper {
    int countByExample(RedExample example);

    int deleteByExample(RedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Red record);

    int insertSelective(Red record);

    List<Red> selectByExampleWithBLOBs(RedExample example);

    List<Red> selectByExample(RedExample example);

    Red selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Red record, @Param("example") RedExample example);

    int updateByExampleWithBLOBs(@Param("record") Red record, @Param("example") RedExample example);

    int updateByExample(@Param("record") Red record, @Param("example") RedExample example);

    int updateByPrimaryKeySelective(Red record);

    int updateByPrimaryKeyWithBLOBs(Red record);

    int updateByPrimaryKey(Red record);

    void insertBatch(List<Red> list);

    List<Red> selectByExampleByPage(RedExample example);
}