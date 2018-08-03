package com.airmcl.air.app.dao;

import com.airmcl.air.app.entity.IndexColumn;
import com.airmcl.air.app.entity.IndexColumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexColumnMapper {
    int countByExample(IndexColumnExample example);

    int deleteByExample(IndexColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexColumn record);

    int insertSelective(IndexColumn record);

    List<IndexColumn> selectByExample(IndexColumnExample example);

    IndexColumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexColumn record, @Param("example") IndexColumnExample example);

    int updateByExample(@Param("record") IndexColumn record, @Param("example") IndexColumnExample example);

    int updateByPrimaryKeySelective(IndexColumn record);

    int updateByPrimaryKey(IndexColumn record);

    void insertBatch(List<IndexColumn> list);

    List<IndexColumn> selectByExampleByPage(IndexColumnExample example);

    int updateStateByIds(@Param("ids") int[] ids);
}