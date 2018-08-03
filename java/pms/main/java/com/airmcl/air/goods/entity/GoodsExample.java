package com.airmcl.air.goods.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsExample extends AbstractExample<Goods> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Goods> pageView = new PageView<Goods>(1, 10);

    private static final long serialVersionUID = 1L;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    @Override
    public PageView<Goods> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Goods> pageView) {
        this.pageView = pageView;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        private static final long serialVersionUID = 1L;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCardNumberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumberEqualTo(String value) {
            addCriterion("card_number =", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThan(String value) {
            addCriterion("card_number >", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThan(String value) {
            addCriterion("card_number <", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberLike(String value) {
            addCriterion("card_number like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotLike(String value) {
            addCriterion("card_number not like", value, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberIn(List<String> values) {
            addCriterion("card_number in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andCardNumberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "cardNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverIsNull() {
            addCriterion("goods_cover is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverIsNotNull() {
            addCriterion("goods_cover is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverEqualTo(String value) {
            addCriterion("goods_cover =", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverNotEqualTo(String value) {
            addCriterion("goods_cover <>", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverGreaterThan(String value) {
            addCriterion("goods_cover >", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverGreaterThanOrEqualTo(String value) {
            addCriterion("goods_cover >=", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverLessThan(String value) {
            addCriterion("goods_cover <", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverLessThanOrEqualTo(String value) {
            addCriterion("goods_cover <=", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverLike(String value) {
            addCriterion("goods_cover like", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverNotLike(String value) {
            addCriterion("goods_cover not like", value, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverIn(List<String> values) {
            addCriterion("goods_cover in", values, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverNotIn(List<String> values) {
            addCriterion("goods_cover not in", values, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverBetween(String value1, String value2) {
            addCriterion("goods_cover between", value1, value2, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverNotBetween(String value1, String value2) {
            addCriterion("goods_cover not between", value1, value2, "goodsCover");
            return (Criteria) this;
        }

        public Criteria andRangeIsNull() {
            addCriterion("range is null");
            return (Criteria) this;
        }

        public Criteria andRangeIsNotNull() {
            addCriterion("range is not null");
            return (Criteria) this;
        }

        public Criteria andRangeEqualTo(String value) {
            addCriterion("range =", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotEqualTo(String value) {
            addCriterion("range <>", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThan(String value) {
            addCriterion("range >", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeGreaterThanOrEqualTo(String value) {
            addCriterion("range >=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThan(String value) {
            addCriterion("range <", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLessThanOrEqualTo(String value) {
            addCriterion("range <=", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeLike(String value) {
            addCriterion("range like", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotLike(String value) {
            addCriterion("range not like", value, "range");
            return (Criteria) this;
        }

        public Criteria andRangeIn(List<String> values) {
            addCriterion("range in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotIn(List<String> values) {
            addCriterion("range not in", values, "range");
            return (Criteria) this;
        }

        public Criteria andRangeBetween(String value1, String value2) {
            addCriterion("range between", value1, value2, "range");
            return (Criteria) this;
        }

        public Criteria andRangeNotBetween(String value1, String value2) {
            addCriterion("range not between", value1, value2, "range");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIsNull() {
            addCriterion("ledger_cycle is null");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIsNotNull() {
            addCriterion("ledger_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleEqualTo(Byte value) {
            addCriterion("ledger_cycle =", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotEqualTo(Byte value) {
            addCriterion("ledger_cycle <>", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleGreaterThan(Byte value) {
            addCriterion("ledger_cycle >", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleGreaterThanOrEqualTo(Byte value) {
            addCriterion("ledger_cycle >=", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleLessThan(Byte value) {
            addCriterion("ledger_cycle <", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleLessThanOrEqualTo(Byte value) {
            addCriterion("ledger_cycle <=", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIn(List<Byte> values) {
            addCriterion("ledger_cycle in", values, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotIn(List<Byte> values) {
            addCriterion("ledger_cycle not in", values, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleBetween(Byte value1, Byte value2) {
            addCriterion("ledger_cycle between", value1, value2, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotBetween(Byte value1, Byte value2) {
            addCriterion("ledger_cycle not between", value1, value2, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIsNull() {
            addCriterion("ledger_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIsNotNull() {
            addCriterion("ledger_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdEqualTo(String value) {
            addCriterion("ledger_rule_id =", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotEqualTo(String value) {
            addCriterion("ledger_rule_id <>", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdGreaterThan(String value) {
            addCriterion("ledger_rule_id >", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_rule_id >=", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLessThan(String value) {
            addCriterion("ledger_rule_id <", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLessThanOrEqualTo(String value) {
            addCriterion("ledger_rule_id <=", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLike(String value) {
            addCriterion("ledger_rule_id like", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotLike(String value) {
            addCriterion("ledger_rule_id not like", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIn(List<String> values) {
            addCriterion("ledger_rule_id in", values, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotIn(List<String> values) {
            addCriterion("ledger_rule_id not in", values, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdBetween(String value1, String value2) {
            addCriterion("ledger_rule_id between", value1, value2, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotBetween(String value1, String value2) {
            addCriterion("ledger_rule_id not between", value1, value2, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIsNull() {
            addCriterion("ledger_rule_name is null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIsNotNull() {
            addCriterion("ledger_rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameEqualTo(String value) {
            addCriterion("ledger_rule_name =", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotEqualTo(String value) {
            addCriterion("ledger_rule_name <>", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameGreaterThan(String value) {
            addCriterion("ledger_rule_name >", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_rule_name >=", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLessThan(String value) {
            addCriterion("ledger_rule_name <", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLessThanOrEqualTo(String value) {
            addCriterion("ledger_rule_name <=", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLike(String value) {
            addCriterion("ledger_rule_name like", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotLike(String value) {
            addCriterion("ledger_rule_name not like", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIn(List<String> values) {
            addCriterion("ledger_rule_name in", values, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotIn(List<String> values) {
            addCriterion("ledger_rule_name not in", values, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameBetween(String value1, String value2) {
            addCriterion("ledger_rule_name between", value1, value2, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotBetween(String value1, String value2) {
            addCriterion("ledger_rule_name not between", value1, value2, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeIsNull() {
            addCriterion("expiry_type is null");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeIsNotNull() {
            addCriterion("expiry_type is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeEqualTo(Byte value) {
            addCriterion("expiry_type =", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeNotEqualTo(Byte value) {
            addCriterion("expiry_type <>", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeGreaterThan(Byte value) {
            addCriterion("expiry_type >", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("expiry_type >=", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeLessThan(Byte value) {
            addCriterion("expiry_type <", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeLessThanOrEqualTo(Byte value) {
            addCriterion("expiry_type <=", value, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeIn(List<Byte> values) {
            addCriterion("expiry_type in", values, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeNotIn(List<Byte> values) {
            addCriterion("expiry_type not in", values, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeBetween(Byte value1, Byte value2) {
            addCriterion("expiry_type between", value1, value2, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("expiry_type not between", value1, value2, "expiryType");
            return (Criteria) this;
        }

        public Criteria andExpiryIsNull() {
            addCriterion("expiry is null");
            return (Criteria) this;
        }

        public Criteria andExpiryIsNotNull() {
            addCriterion("expiry is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryEqualTo(Integer value) {
            addCriterion("expiry =", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryNotEqualTo(Integer value) {
            addCriterion("expiry <>", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryGreaterThan(Integer value) {
            addCriterion("expiry >", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryGreaterThanOrEqualTo(Integer value) {
            addCriterion("expiry >=", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryLessThan(Integer value) {
            addCriterion("expiry <", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryLessThanOrEqualTo(Integer value) {
            addCriterion("expiry <=", value, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryIn(List<Integer> values) {
            addCriterion("expiry in", values, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryNotIn(List<Integer> values) {
            addCriterion("expiry not in", values, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryBetween(Integer value1, Integer value2) {
            addCriterion("expiry between", value1, value2, "expiry");
            return (Criteria) this;
        }

        public Criteria andExpiryNotBetween(Integer value1, Integer value2) {
            addCriterion("expiry not between", value1, value2, "expiry");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNull() {
            addCriterion("market_price is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("market_price is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("market_price =", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("market_price <>", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("market_price >", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price >=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("market_price <", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("market_price <=", value, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("market_price in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("market_price not in", values, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("market_price not between", value1, value2, "marketPrice");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNull() {
            addCriterion("member_price is null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIsNotNull() {
            addCriterion("member_price is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPriceEqualTo(BigDecimal value) {
            addCriterion("member_price =", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotEqualTo(BigDecimal value) {
            addCriterion("member_price <>", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThan(BigDecimal value) {
            addCriterion("member_price >", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("member_price >=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThan(BigDecimal value) {
            addCriterion("member_price <", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("member_price <=", value, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceIn(List<BigDecimal> values) {
            addCriterion("member_price in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotIn(List<BigDecimal> values) {
            addCriterion("member_price not in", values, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_price between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andMemberPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_price not between", value1, value2, "memberPrice");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseIsNull() {
            addCriterion("is_purchase is null");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseIsNotNull() {
            addCriterion("is_purchase is not null");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseEqualTo(Byte value) {
            addCriterion("is_purchase =", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseNotEqualTo(Byte value) {
            addCriterion("is_purchase <>", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseGreaterThan(Byte value) {
            addCriterion("is_purchase >", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_purchase >=", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseLessThan(Byte value) {
            addCriterion("is_purchase <", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseLessThanOrEqualTo(Byte value) {
            addCriterion("is_purchase <=", value, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseIn(List<Byte> values) {
            addCriterion("is_purchase in", values, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseNotIn(List<Byte> values) {
            addCriterion("is_purchase not in", values, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseBetween(Byte value1, Byte value2) {
            addCriterion("is_purchase between", value1, value2, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsPurchaseNotBetween(Byte value1, Byte value2) {
            addCriterion("is_purchase not between", value1, value2, "isPurchase");
            return (Criteria) this;
        }

        public Criteria andIsCouponIsNull() {
            addCriterion("is_coupon is null");
            return (Criteria) this;
        }

        public Criteria andIsCouponIsNotNull() {
            addCriterion("is_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andIsCouponEqualTo(Byte value) {
            addCriterion("is_coupon =", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponNotEqualTo(Byte value) {
            addCriterion("is_coupon <>", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponGreaterThan(Byte value) {
            addCriterion("is_coupon >", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_coupon >=", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponLessThan(Byte value) {
            addCriterion("is_coupon <", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponLessThanOrEqualTo(Byte value) {
            addCriterion("is_coupon <=", value, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponIn(List<Byte> values) {
            addCriterion("is_coupon in", values, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponNotIn(List<Byte> values) {
            addCriterion("is_coupon not in", values, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponBetween(Byte value1, Byte value2) {
            addCriterion("is_coupon between", value1, value2, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsCouponNotBetween(Byte value1, Byte value2) {
            addCriterion("is_coupon not between", value1, value2, "isCoupon");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("is_refund is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("is_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(Byte value) {
            addCriterion("is_refund =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(Byte value) {
            addCriterion("is_refund <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(Byte value) {
            addCriterion("is_refund >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_refund >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(Byte value) {
            addCriterion("is_refund <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(Byte value) {
            addCriterion("is_refund <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<Byte> values) {
            addCriterion("is_refund in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<Byte> values) {
            addCriterion("is_refund not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(Byte value1, Byte value2) {
            addCriterion("is_refund between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(Byte value1, Byte value2) {
            addCriterion("is_refund not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(Byte value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(Byte value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(Byte value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(Byte value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(Byte value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<Byte> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<Byte> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(Byte value1, Byte value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(Byte value1, Byte value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveIsNull() {
            addCriterion("is_auto_shelve is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveIsNotNull() {
            addCriterion("is_auto_shelve is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveEqualTo(Byte value) {
            addCriterion("is_auto_shelve =", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveNotEqualTo(Byte value) {
            addCriterion("is_auto_shelve <>", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveGreaterThan(Byte value) {
            addCriterion("is_auto_shelve >", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_auto_shelve >=", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveLessThan(Byte value) {
            addCriterion("is_auto_shelve <", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveLessThanOrEqualTo(Byte value) {
            addCriterion("is_auto_shelve <=", value, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveIn(List<Byte> values) {
            addCriterion("is_auto_shelve in", values, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveNotIn(List<Byte> values) {
            addCriterion("is_auto_shelve not in", values, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveBetween(Byte value1, Byte value2) {
            addCriterion("is_auto_shelve between", value1, value2, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andIsAutoShelveNotBetween(Byte value1, Byte value2) {
            addCriterion("is_auto_shelve not between", value1, value2, "isAutoShelve");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalIsNull() {
            addCriterion("purchase_total is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalIsNotNull() {
            addCriterion("purchase_total is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalEqualTo(Integer value) {
            addCriterion("purchase_total =", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalNotEqualTo(Integer value) {
            addCriterion("purchase_total <>", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalGreaterThan(Integer value) {
            addCriterion("purchase_total >", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("purchase_total >=", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalLessThan(Integer value) {
            addCriterion("purchase_total <", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalLessThanOrEqualTo(Integer value) {
            addCriterion("purchase_total <=", value, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalIn(List<Integer> values) {
            addCriterion("purchase_total in", values, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalNotIn(List<Integer> values) {
            addCriterion("purchase_total not in", values, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalBetween(Integer value1, Integer value2) {
            addCriterion("purchase_total between", value1, value2, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andPurchaseTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("purchase_total not between", value1, value2, "purchaseTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalIsNull() {
            addCriterion("comment_total is null");
            return (Criteria) this;
        }

        public Criteria andCommentTotalIsNotNull() {
            addCriterion("comment_total is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTotalEqualTo(Integer value) {
            addCriterion("comment_total =", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotEqualTo(Integer value) {
            addCriterion("comment_total <>", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalGreaterThan(Integer value) {
            addCriterion("comment_total >", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_total >=", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalLessThan(Integer value) {
            addCriterion("comment_total <", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalLessThanOrEqualTo(Integer value) {
            addCriterion("comment_total <=", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalIn(List<Integer> values) {
            addCriterion("comment_total in", values, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotIn(List<Integer> values) {
            addCriterion("comment_total not in", values, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalBetween(Integer value1, Integer value2) {
            addCriterion("comment_total between", value1, value2, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_total not between", value1, value2, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeIsNull() {
            addCriterion("openingtime is null");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeIsNotNull() {
            addCriterion("openingtime is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeEqualTo(Integer value) {
            addCriterion("openingtime =", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeNotEqualTo(Integer value) {
            addCriterion("openingtime <>", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeGreaterThan(Integer value) {
            addCriterion("openingtime >", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("openingtime >=", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeLessThan(Integer value) {
            addCriterion("openingtime <", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeLessThanOrEqualTo(Integer value) {
            addCriterion("openingtime <=", value, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeIn(List<Integer> values) {
            addCriterion("openingtime in", values, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeNotIn(List<Integer> values) {
            addCriterion("openingtime not in", values, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeBetween(Integer value1, Integer value2) {
            addCriterion("openingtime between", value1, value2, "openingtime");
            return (Criteria) this;
        }

        public Criteria andOpeningtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("openingtime not between", value1, value2, "openingtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Integer value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Integer value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Integer value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Integer value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Integer> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Integer> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Integer value1, Integer value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        private static final long serialVersionUID = 1L;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}