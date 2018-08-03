package com.airmcl.air.order.dao;

import com.airmcl.air.order.entity.LaunchLedger;
import com.airmcl.air.order.entity.LaunchLedgerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaunchLedgerMapper {
    int countByExample(LaunchLedgerExample example);

    int deleteByExample(LaunchLedgerExample example);

    int deleteByPrimaryKey(String id);

    int insert(LaunchLedger record);

    int insertSelective(LaunchLedger record);

    List<LaunchLedger> selectByExample(LaunchLedgerExample example);

    LaunchLedger selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LaunchLedger record, @Param("example") LaunchLedgerExample example);

    int updateByExample(@Param("record") LaunchLedger record, @Param("example") LaunchLedgerExample example);

    int updateByPrimaryKeySelective(LaunchLedger record);

    int updateByPrimaryKey(LaunchLedger record);

    void insertBatch(List<LaunchLedger> list);

    List<LaunchLedger> selectByExampleByPage(LaunchLedgerExample example);
}