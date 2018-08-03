package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsAutoShelve;
import com.airmcl.air.goods.entity.GoodsAutoShelveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAutoShelveMapper {
    int countByExample(GoodsAutoShelveExample example);

    int deleteByExample(GoodsAutoShelveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsAutoShelve record);

    int insertSelective(GoodsAutoShelve record);

    List<GoodsAutoShelve> selectByExample(GoodsAutoShelveExample example);

    GoodsAutoShelve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsAutoShelve record, @Param("example") GoodsAutoShelveExample example);

    int updateByExample(@Param("record") GoodsAutoShelve record, @Param("example") GoodsAutoShelveExample example);

    int updateByPrimaryKeySelective(GoodsAutoShelve record);

    int updateByPrimaryKey(GoodsAutoShelve record);

    void insertBatch(List<GoodsAutoShelve> list);

    List<GoodsAutoShelve> selectByExampleByPage(GoodsAutoShelveExample example);
}