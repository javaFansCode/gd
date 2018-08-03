package com.airmcl.air.ledger.enter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Deprecated
@ApiModel(value="商品与分账规则对应关系参数")
public class GoodsLedgerRuleParaVO {
    @ApiModelProperty("分账规则ID")
    private String ledgerRuleId;

    @ApiModelProperty("分账规则名称")
    private String ledgerRuleName;

    @ApiModelProperty("商品ID")
    private String goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

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

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
