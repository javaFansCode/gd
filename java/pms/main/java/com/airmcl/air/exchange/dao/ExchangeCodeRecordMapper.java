package com.airmcl.air.exchange.dao;

import com.airmcl.air.exchange.entity.ExchangeCodeRecord;
import com.airmcl.air.exchange.entity.ExchangeCodeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchangeCodeRecordMapper {
    int countByExample(ExchangeCodeRecordExample example);

    int deleteByExample(ExchangeCodeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExchangeCodeRecord record);

    int insertSelective(ExchangeCodeRecord record);

    List<ExchangeCodeRecord> selectByExampleWithBLOBs(ExchangeCodeRecordExample example);

    List<ExchangeCodeRecord> selectByExample(ExchangeCodeRecordExample example);

    ExchangeCodeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExchangeCodeRecord record, @Param("example") ExchangeCodeRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") ExchangeCodeRecord record, @Param("example") ExchangeCodeRecordExample example);

    int updateByExample(@Param("record") ExchangeCodeRecord record, @Param("example") ExchangeCodeRecordExample example);

    int updateByPrimaryKeySelective(ExchangeCodeRecord record);

    int updateByPrimaryKeyWithBLOBs(ExchangeCodeRecord record);

    int updateByPrimaryKey(ExchangeCodeRecord record);

    void insertBatch(List<ExchangeCodeRecord> list);

    List<ExchangeCodeRecord> selectByExampleByPage(ExchangeCodeRecordExample example);
}