package com.airmcl.air.goods.dao;

import com.airmcl.air.goods.entity.GoodsExtend;
import com.airmcl.air.goods.entity.GoodsExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsExtendMapper {
    int countByExample(GoodsExtendExample example);

    int deleteByExample(GoodsExtendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsExtend record);

    int insertSelective(GoodsExtend record);

    List<GoodsExtend> selectByExampleWithBLOBs(GoodsExtendExample example);

    List<GoodsExtend> selectByExample(GoodsExtendExample example);

    GoodsExtend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsExtend record, @Param("example") GoodsExtendExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsExtend record, @Param("example") GoodsExtendExample example);

    int updateByExample(@Param("record") GoodsExtend record, @Param("example") GoodsExtendExample example);

    int updateByPrimaryKeySelective(GoodsExtend record);

    int updateByPrimaryKeyWithBLOBs(GoodsExtend record);

    int updateByPrimaryKey(GoodsExtend record);

    void insertBatch(List<GoodsExtend> list);

    List<GoodsExtend> selectByExampleByPage(GoodsExtendExample example);
}