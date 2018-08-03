package com.airmcl.air.ledger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@Deprecated
@ApiModel(value="分账规则")
public class LedgerRule implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("备注")
    private String ruleRemark;

    @ApiModelProperty("分账规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("是否删除（0：否 1：是）")
    private Boolean isDelete;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRuleRemark() {
        return ruleRemark;
    }

    public void setRuleRemark(String ruleRemark) {
        this.ruleRemark = ruleRemark == null ? null : ruleRemark.trim();
    }

    public String getLedgerRuleName() {
        return ledgerRuleName;
    }

    public void setLedgerRuleName(String ledgerRuleName) {
        this.ledgerRuleName = ledgerRuleName == null ? null : ledgerRuleName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}