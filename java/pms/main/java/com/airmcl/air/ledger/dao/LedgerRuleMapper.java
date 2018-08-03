package com.airmcl.air.ledger.dao;

import com.airmcl.air.ledger.entity.LedgerRule;
import com.airmcl.air.ledger.entity.LedgerRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Deprecated
public interface LedgerRuleMapper {
    int countByExample(LedgerRuleExample example);

    int deleteByExample(LedgerRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(LedgerRule record);

    int insertSelective(LedgerRule record);

    List<LedgerRule> selectByExample(LedgerRuleExample example);

    LedgerRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LedgerRule record, @Param("example") LedgerRuleExample example);

    int updateByExample(@Param("record") LedgerRule record, @Param("example") LedgerRuleExample example);

    int updateByPrimaryKeySelective(LedgerRule record);

    int updateByPrimaryKey(LedgerRule record);

    void insertBatch(List<LedgerRule> list);

    List<LedgerRule> selectByExampleByPage(LedgerRuleExample example);
}