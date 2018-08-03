package com.airmcl.air.ledger.dao;

import com.airmcl.air.ledger.entity.LedgerRuleDetail;
import com.airmcl.air.ledger.entity.LedgerRuleDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Deprecated
public interface LedgerRuleDetailMapper {
    int countByExample(LedgerRuleDetailExample example);

    int deleteByExample(LedgerRuleDetailExample example);

    int deleteByPrimaryKey(String id);

    int insert(LedgerRuleDetail record);

    int insertSelective(LedgerRuleDetail record);

    List<LedgerRuleDetail> selectByExample(LedgerRuleDetailExample example);

    LedgerRuleDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LedgerRuleDetail record, @Param("example") LedgerRuleDetailExample example);

    int updateByExample(@Param("record") LedgerRuleDetail record, @Param("example") LedgerRuleDetailExample example);

    int updateByPrimaryKeySelective(LedgerRuleDetail record);

    int updateByPrimaryKey(LedgerRuleDetail record);

    void insertBatch(List<LedgerRuleDetail> list);

    List<LedgerRuleDetail> selectByExampleByPage(LedgerRuleDetailExample example);
}