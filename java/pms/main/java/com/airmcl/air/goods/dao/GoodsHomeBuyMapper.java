package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsHomeBuy;
import com.airmcl.air.goods.entity.GoodsHomeBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsHomeBuyMapper {
    int countByExample(GoodsHomeBuyExample example);

    int deleteByExample(GoodsHomeBuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsHomeBuy record);

    int insertSelective(GoodsHomeBuy record);

    List<GoodsHomeBuy> selectByExample(GoodsHomeBuyExample example);

    GoodsHomeBuy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsHomeBuy record, @Param("example") GoodsHomeBuyExample example);

    int updateByExample(@Param("record") GoodsHomeBuy record, @Param("example") GoodsHomeBuyExample example);

    int updateByPrimaryKeySelective(GoodsHomeBuy record);

    int updateByPrimaryKey(GoodsHomeBuy record);

    void insertBatch(List<GoodsHomeBuy> list);

    List<GoodsHomeBuy> selectByExampleByPage(GoodsHomeBuyExample example);
}