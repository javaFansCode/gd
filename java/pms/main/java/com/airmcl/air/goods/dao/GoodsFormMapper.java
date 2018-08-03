package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsForm;
import com.airmcl.air.goods.entity.GoodsFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsFormMapper {
    int countByExample(GoodsFormExample example);

    int deleteByExample(GoodsFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsForm record);

    int insertSelective(GoodsForm record);

    List<GoodsForm> selectByExample(GoodsFormExample example);

    GoodsForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsForm record, @Param("example") GoodsFormExample example);

    int updateByExample(@Param("record") GoodsForm record, @Param("example") GoodsFormExample example);

    int updateByPrimaryKeySelective(GoodsForm record);

    int updateByPrimaryKey(GoodsForm record);

    void insertBatch(List<GoodsForm> list);

    List<GoodsForm> selectByExampleByPage(GoodsFormExample example);
}