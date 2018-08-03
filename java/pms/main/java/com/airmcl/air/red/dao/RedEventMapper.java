package com.airmcl.air.red.dao;

import com.airmcl.air.red.entity.RedEvent;
import com.airmcl.air.red.entity.RedEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedEventMapper {
    int countByExample(RedEventExample example);

    int deleteByExample(RedEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedEvent record);

    int insertSelective(RedEvent record);

    List<RedEvent> selectByExample(RedEventExample example);

    RedEvent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedEvent record, @Param("example") RedEventExample example);

    int updateByExample(@Param("record") RedEvent record, @Param("example") RedEventExample example);

    int updateByPrimaryKeySelective(RedEvent record);

    int updateByPrimaryKey(RedEvent record);

    void insertBatch(List<RedEvent> list);

    List<RedEvent> selectByExampleByPage(RedEventExample example);
}