package com.airmcl.air.beauty.dao;

import com.airmcl.air.beauty.entity.BeautyProfit;
import com.airmcl.air.beauty.entity.BeautyProfitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeautyProfitMapper {
    int countByExample(BeautyProfitExample example);

    int deleteByExample(BeautyProfitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeautyProfit record);

    int insertSelective(BeautyProfit record);

    List<BeautyProfit> selectByExample(BeautyProfitExample example);

    BeautyProfit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeautyProfit record, @Param("example") BeautyProfitExample example);

    int updateByExample(@Param("record") BeautyProfit record, @Param("example") BeautyProfitExample example);

    int updateByPrimaryKeySelective(BeautyProfit record);

    int updateByPrimaryKey(BeautyProfit record);

    void insertBatch(List<BeautyProfit> list);

    List<BeautyProfit> selectByExampleByPage(BeautyProfitExample example);
}