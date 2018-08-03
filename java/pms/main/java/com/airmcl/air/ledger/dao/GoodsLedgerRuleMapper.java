package com.airmcl.air.ledger.dao;

import com.airmcl.air.ledger.entity.GoodsLedgerRule;
import com.airmcl.air.ledger.entity.GoodsLedgerRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Deprecated
public interface GoodsLedgerRuleMapper {
    int countByExample(GoodsLedgerRuleExample example);

    int deleteByExample(GoodsLedgerRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(GoodsLedgerRule record);

    int insertSelective(GoodsLedgerRule record);

    List<GoodsLedgerRule> selectByExample(GoodsLedgerRuleExample example);

    GoodsLedgerRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GoodsLedgerRule record, @Param("example") GoodsLedgerRuleExample example);

    int updateByExample(@Param("record") GoodsLedgerRule record, @Param("example") GoodsLedgerRuleExample example);

    int updateByPrimaryKeySelective(GoodsLedgerRule record);

    int updateByPrimaryKey(GoodsLedgerRule record);

    void insertBatch(List<GoodsLedgerRule> list);

    List<GoodsLedgerRule> selectByExampleByPage(GoodsLedgerRuleExample example);
}