package com.airmcl.air.ledger.out;

import com.airmcl.air.ledger.entity.LedgerRuleDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "分账规则api")
@Deprecated
public class LedgerRuleVO {

    /**
     * 分账规则ID
     */
    private String ledgerRuleId;
    /**
     * 分账规则名称
     */
    private String ledgerRuleName;
    /**
     * 备注
     */
    private String ruleRemark;
    /**
     * 分账规则明细
     */
    private List<LedgerRuleDetail> ledgerRuleDetails;

    public String getLedgerRuleId() {
        return ledgerRuleId;
    }

    public void setLedgerRuleId(String ledgerRuleId) {
        this.ledgerRuleId = ledgerRuleId;
    }

    public String getLedgerRuleName() {
        return ledgerRuleName;
    }

    public void setLedgerRuleName(String ledgerRuleName) {
        this.ledgerRuleName = ledgerRuleName;
    }

    public String getRuleRemark() {
        return ruleRemark;
    }

    public void setRuleRemark(String ruleRemark) {
        this.ruleRemark = ruleRemark;
    }

    public List<LedgerRuleDetail> getLedgerRuleDetails() {
        return ledgerRuleDetails;
    }

    public void setLedgerRuleDetails(List<LedgerRuleDetail> ledgerRuleDetails) {
        this.ledgerRuleDetails = ledgerRuleDetails;
    }
}
