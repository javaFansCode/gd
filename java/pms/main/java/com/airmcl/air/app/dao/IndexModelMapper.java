package com.airmcl.air.app.dao;

import com.airmcl.air.app.entity.IndexModel;
import com.airmcl.air.app.entity.IndexModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexModelMapper {
    int countByExample(IndexModelExample example);

    int deleteByExample(IndexModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IndexModel record);

    int insertSelective(IndexModel record);

    List<IndexModel> selectByExampleWithBLOBs(IndexModelExample example);

    List<IndexModel> selectByExample(IndexModelExample example);

    IndexModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IndexModel record, @Param("example") IndexModelExample example);

    int updateByExampleWithBLOBs(@Param("record") IndexModel record, @Param("example") IndexModelExample example);

    int updateByExample(@Param("record") IndexModel record, @Param("example") IndexModelExample example);

    int updateByPrimaryKeySelective(IndexModel record);

    int updateByPrimaryKeyWithBLOBs(IndexModel record);

    int updateByPrimaryKey(IndexModel record);

    void insertBatch(List<IndexModel> list);

    List<IndexModel> selectByExampleByPage(IndexModelExample example);

    int updateStateByIds(@Param("ids") int[] ids);
}