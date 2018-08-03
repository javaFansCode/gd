package com.airmcl.air.ledger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="分账规则明细")
@Deprecated
public class LedgerRuleDetail implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("分账规则ID")
    private String ledgerRuleId;

    @ApiModelProperty("分账类型ID")
    private String ledgerTypeId;

    @ApiModelProperty("分账类型名称")
    private String ledgerTypeName;

    @ApiModelProperty("分账比例(0到100整数)")
    private Short ledgerRatio;

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

    public String getLedgerRuleId() {
        return ledgerRuleId;
    }

    public void setLedgerRuleId(String ledgerRuleId) {
        this.ledgerRuleId = ledgerRuleId == null ? null : ledgerRuleId.trim();
    }

    public String getLedgerTypeId() {
        return ledgerTypeId;
    }

    public void setLedgerTypeId(String ledgerTypeId) {
        this.ledgerTypeId = ledgerTypeId == null ? null : ledgerTypeId.trim();
    }

    public String getLedgerTypeName() {
        return ledgerTypeName;
    }

    public void setLedgerTypeName(String ledgerTypeName) {
        this.ledgerTypeName = ledgerTypeName == null ? null : ledgerTypeName.trim();
    }

    public Short getLedgerRatio() {
        return ledgerRatio;
    }

    public void setLedgerRatio(Short ledgerRatio) {
        this.ledgerRatio = ledgerRatio;
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