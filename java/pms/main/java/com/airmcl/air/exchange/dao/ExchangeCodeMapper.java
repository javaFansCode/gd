package com.airmcl.air.exchange.dao;

import com.airmcl.air.exchange.entity.ExchangeCode;
import com.airmcl.air.exchange.entity.ExchangeCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchangeCodeMapper {
    int countByExample(ExchangeCodeExample example);

    int deleteByExample(ExchangeCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeCode record);

    int insertSelective(ExchangeCode record);

    List<ExchangeCode> selectByExample(ExchangeCodeExample example);

    ExchangeCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExchangeCode record, @Param("example") ExchangeCodeExample example);

    int updateByExample(@Param("record") ExchangeCode record, @Param("example") ExchangeCodeExample example);

    int updateByPrimaryKeySelective(ExchangeCode record);

    int updateByPrimaryKey(ExchangeCode record);

    void insertBatch(List<ExchangeCode> list);

    List<ExchangeCode> selectByExampleByPage(ExchangeCodeExample example);
}