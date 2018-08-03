package com.airmcl.air.ledger.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Deprecated
public class LedgerRuleDetailExample extends AbstractExample<LedgerRuleDetail> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<LedgerRuleDetail> pageView = new PageView<LedgerRuleDetail>(1, 10);

    private static final long serialVersionUID = 1L;

    public LedgerRuleDetailExample() {
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
    public PageView<LedgerRuleDetail> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<LedgerRuleDetail> pageView) {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andLedgerTypeIdIsNull() {
            addCriterion("ledger_type_id is null");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdIsNotNull() {
            addCriterion("ledger_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdEqualTo(String value) {
            addCriterion("ledger_type_id =", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdNotEqualTo(String value) {
            addCriterion("ledger_type_id <>", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdGreaterThan(String value) {
            addCriterion("ledger_type_id >", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_type_id >=", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdLessThan(String value) {
            addCriterion("ledger_type_id <", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdLessThanOrEqualTo(String value) {
            addCriterion("ledger_type_id <=", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdLike(String value) {
            addCriterion("ledger_type_id like", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdNotLike(String value) {
            addCriterion("ledger_type_id not like", value, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdIn(List<String> values) {
            addCriterion("ledger_type_id in", values, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdNotIn(List<String> values) {
            addCriterion("ledger_type_id not in", values, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdBetween(String value1, String value2) {
            addCriterion("ledger_type_id between", value1, value2, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeIdNotBetween(String value1, String value2) {
            addCriterion("ledger_type_id not between", value1, value2, "ledgerTypeId");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameIsNull() {
            addCriterion("ledger_type_name is null");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameIsNotNull() {
            addCriterion("ledger_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameEqualTo(String value) {
            addCriterion("ledger_type_name =", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameNotEqualTo(String value) {
            addCriterion("ledger_type_name <>", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameGreaterThan(String value) {
            addCriterion("ledger_type_name >", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("ledger_type_name >=", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameLessThan(String value) {
            addCriterion("ledger_type_name <", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameLessThanOrEqualTo(String value) {
            addCriterion("ledger_type_name <=", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameLike(String value) {
            addCriterion("ledger_type_name like", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameNotLike(String value) {
            addCriterion("ledger_type_name not like", value, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameIn(List<String> values) {
            addCriterion("ledger_type_name in", values, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameNotIn(List<String> values) {
            addCriterion("ledger_type_name not in", values, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameBetween(String value1, String value2) {
            addCriterion("ledger_type_name between", value1, value2, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerTypeNameNotBetween(String value1, String value2) {
            addCriterion("ledger_type_name not between", value1, value2, "ledgerTypeName");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioIsNull() {
            addCriterion("ledger_ratio is null");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioIsNotNull() {
            addCriterion("ledger_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioEqualTo(Short value) {
            addCriterion("ledger_ratio =", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioNotEqualTo(Short value) {
            addCriterion("ledger_ratio <>", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioGreaterThan(Short value) {
            addCriterion("ledger_ratio >", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioGreaterThanOrEqualTo(Short value) {
            addCriterion("ledger_ratio >=", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioLessThan(Short value) {
            addCriterion("ledger_ratio <", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioLessThanOrEqualTo(Short value) {
            addCriterion("ledger_ratio <=", value, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioIn(List<Short> values) {
            addCriterion("ledger_ratio in", values, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioNotIn(List<Short> values) {
            addCriterion("ledger_ratio not in", values, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioBetween(Short value1, Short value2) {
            addCriterion("ledger_ratio between", value1, value2, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andLedgerRatioNotBetween(Short value1, Short value2) {
            addCriterion("ledger_ratio not between", value1, value2, "ledgerRatio");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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