package com.airmcl.air.beauty.dao;

import com.airmcl.air.beauty.entity.BeautyRelations;
import com.airmcl.air.beauty.entity.BeautyRelationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeautyRelationsMapper {
    int countByExample(BeautyRelationsExample example);

    int deleteByExample(BeautyRelationsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeautyRelations record);

    int insertSelective(BeautyRelations record);

    List<BeautyRelations> selectByExample(BeautyRelationsExample example);

    BeautyRelations selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeautyRelations record, @Param("example") BeautyRelationsExample example);

    int updateByExample(@Param("record") BeautyRelations record, @Param("example") BeautyRelationsExample example);

    int updateByPrimaryKeySelective(BeautyRelations record);

    int updateByPrimaryKey(BeautyRelations record);

    void insertBatch(List<BeautyRelations> list);

    List<BeautyRelations> selectByExampleByPage(BeautyRelationsExample example);
}