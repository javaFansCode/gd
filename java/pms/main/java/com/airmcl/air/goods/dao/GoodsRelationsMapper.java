package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsRelations;
import com.airmcl.air.goods.entity.GoodsRelationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsRelationsMapper {
    int countByExample(GoodsRelationsExample example);

    int deleteByExample(GoodsRelationsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsRelations record);

    int insertSelective(GoodsRelations record);

    List<GoodsRelations> selectByExample(GoodsRelationsExample example);

    GoodsRelations selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsRelations record, @Param("example") GoodsRelationsExample example);

    int updateByExample(@Param("record") GoodsRelations record, @Param("example") GoodsRelationsExample example);

    int updateByPrimaryKeySelective(GoodsRelations record);

    int updateByPrimaryKey(GoodsRelations record);

    void insertBatch(List<GoodsRelations> list);

    List<GoodsRelations> selectByExampleByPage(GoodsRelationsExample example);
}