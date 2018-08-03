package com.airmcl.air.service.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ServiceExample extends AbstractExample<Service> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Service> pageView = new PageView<Service>(1, 10);

    private static final long serialVersionUID = 1L;

    public ServiceExample() {
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
    public PageView<Service> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Service> pageView) {
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

        public Criteria andBeautyIdIsNull() {
            addCriterion("beauty_id is null");
            return (Criteria) this;
        }

        public Criteria andBeautyIdIsNotNull() {
            addCriterion("beauty_id is not null");
            return (Criteria) this;
        }

        public Criteria andBeautyIdEqualTo(Integer value) {
            addCriterion("beauty_id =", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotEqualTo(Integer value) {
            addCriterion("beauty_id <>", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdGreaterThan(Integer value) {
            addCriterion("beauty_id >", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("beauty_id >=", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdLessThan(Integer value) {
            addCriterion("beauty_id <", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdLessThanOrEqualTo(Integer value) {
            addCriterion("beauty_id <=", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdIn(List<Integer> values) {
            addCriterion("beauty_id in", values, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotIn(List<Integer> values) {
            addCriterion("beauty_id not in", values, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdBetween(Integer value1, Integer value2) {
            addCriterion("beauty_id between", value1, value2, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("beauty_id not between", value1, value2, "beautyId");
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

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Byte value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Byte value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Byte value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Byte value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Byte> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Byte> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Byte value1, Byte value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticIsNull() {
            addCriterion("service_name_phonetic is null");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticIsNotNull() {
            addCriterion("service_name_phonetic is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticEqualTo(String value) {
            addCriterion("service_name_phonetic =", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticNotEqualTo(String value) {
            addCriterion("service_name_phonetic <>", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticGreaterThan(String value) {
            addCriterion("service_name_phonetic >", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticGreaterThanOrEqualTo(String value) {
            addCriterion("service_name_phonetic >=", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticLessThan(String value) {
            addCriterion("service_name_phonetic <", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticLessThanOrEqualTo(String value) {
            addCriterion("service_name_phonetic <=", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticLike(String value) {
            addCriterion("service_name_phonetic like", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticNotLike(String value) {
            addCriterion("service_name_phonetic not like", value, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticIn(List<String> values) {
            addCriterion("service_name_phonetic in", values, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticNotIn(List<String> values) {
            addCriterion("service_name_phonetic not in", values, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticBetween(String value1, String value2) {
            addCriterion("service_name_phonetic between", value1, value2, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceNamePhoneticNotBetween(String value1, String value2) {
            addCriterion("service_name_phonetic not between", value1, value2, "serviceNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleIsNull() {
            addCriterion("service_subtitle is null");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleIsNotNull() {
            addCriterion("service_subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleEqualTo(String value) {
            addCriterion("service_subtitle =", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleNotEqualTo(String value) {
            addCriterion("service_subtitle <>", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleGreaterThan(String value) {
            addCriterion("service_subtitle >", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("service_subtitle >=", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleLessThan(String value) {
            addCriterion("service_subtitle <", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleLessThanOrEqualTo(String value) {
            addCriterion("service_subtitle <=", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleLike(String value) {
            addCriterion("service_subtitle like", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleNotLike(String value) {
            addCriterion("service_subtitle not like", value, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleIn(List<String> values) {
            addCriterion("service_subtitle in", values, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleNotIn(List<String> values) {
            addCriterion("service_subtitle not in", values, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleBetween(String value1, String value2) {
            addCriterion("service_subtitle between", value1, value2, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceSubtitleNotBetween(String value1, String value2) {
            addCriterion("service_subtitle not between", value1, value2, "serviceSubtitle");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(Integer value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(Integer value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(Integer value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(Integer value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(Integer value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<Integer> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<Integer> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(Integer value1, Integer value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceCoverIsNull() {
            addCriterion("service_cover is null");
            return (Criteria) this;
        }

        public Criteria andServiceCoverIsNotNull() {
            addCriterion("service_cover is not null");
            return (Criteria) this;
        }

        public Criteria andServiceCoverEqualTo(String value) {
            addCriterion("service_cover =", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverNotEqualTo(String value) {
            addCriterion("service_cover <>", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverGreaterThan(String value) {
            addCriterion("service_cover >", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverGreaterThanOrEqualTo(String value) {
            addCriterion("service_cover >=", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverLessThan(String value) {
            addCriterion("service_cover <", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverLessThanOrEqualTo(String value) {
            addCriterion("service_cover <=", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverLike(String value) {
            addCriterion("service_cover like", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverNotLike(String value) {
            addCriterion("service_cover not like", value, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverIn(List<String> values) {
            addCriterion("service_cover in", values, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverNotIn(List<String> values) {
            addCriterion("service_cover not in", values, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverBetween(String value1, String value2) {
            addCriterion("service_cover between", value1, value2, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andServiceCoverNotBetween(String value1, String value2) {
            addCriterion("service_cover not between", value1, value2, "serviceCover");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
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

        public Criteria andRofitRatioIsNull() {
            addCriterion("rofit_ratio is null");
            return (Criteria) this;
        }

        public Criteria andRofitRatioIsNotNull() {
            addCriterion("rofit_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRofitRatioEqualTo(Float value) {
            addCriterion("rofit_ratio =", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioNotEqualTo(Float value) {
            addCriterion("rofit_ratio <>", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioGreaterThan(Float value) {
            addCriterion("rofit_ratio >", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("rofit_ratio >=", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioLessThan(Float value) {
            addCriterion("rofit_ratio <", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioLessThanOrEqualTo(Float value) {
            addCriterion("rofit_ratio <=", value, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioIn(List<Float> values) {
            addCriterion("rofit_ratio in", values, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioNotIn(List<Float> values) {
            addCriterion("rofit_ratio not in", values, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioBetween(Float value1, Float value2) {
            addCriterion("rofit_ratio between", value1, value2, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andRofitRatioNotBetween(Float value1, Float value2) {
            addCriterion("rofit_ratio not between", value1, value2, "rofitRatio");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNull() {
            addCriterion("discount_price is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIsNotNull() {
            addCriterion("discount_price is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceEqualTo(BigDecimal value) {
            addCriterion("discount_price =", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotEqualTo(BigDecimal value) {
            addCriterion("discount_price <>", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThan(BigDecimal value) {
            addCriterion("discount_price >", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price >=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThan(BigDecimal value) {
            addCriterion("discount_price <", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_price <=", value, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceIn(List<BigDecimal> values) {
            addCriterion("discount_price in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotIn(List<BigDecimal> values) {
            addCriterion("discount_price not in", values, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_price not between", value1, value2, "discountPrice");
            return (Criteria) this;
        }

        public Criteria andAppointTotalIsNull() {
            addCriterion("appoint_total is null");
            return (Criteria) this;
        }

        public Criteria andAppointTotalIsNotNull() {
            addCriterion("appoint_total is not null");
            return (Criteria) this;
        }

        public Criteria andAppointTotalEqualTo(Short value) {
            addCriterion("appoint_total =", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalNotEqualTo(Short value) {
            addCriterion("appoint_total <>", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalGreaterThan(Short value) {
            addCriterion("appoint_total >", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("appoint_total >=", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalLessThan(Short value) {
            addCriterion("appoint_total <", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalLessThanOrEqualTo(Short value) {
            addCriterion("appoint_total <=", value, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalIn(List<Short> values) {
            addCriterion("appoint_total in", values, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalNotIn(List<Short> values) {
            addCriterion("appoint_total not in", values, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalBetween(Short value1, Short value2) {
            addCriterion("appoint_total between", value1, value2, "appointTotal");
            return (Criteria) this;
        }

        public Criteria andAppointTotalNotBetween(Short value1, Short value2) {
            addCriterion("appoint_total not between", value1, value2, "appointTotal");
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

        public Criteria andCommentTotalEqualTo(Short value) {
            addCriterion("comment_total =", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotEqualTo(Short value) {
            addCriterion("comment_total <>", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalGreaterThan(Short value) {
            addCriterion("comment_total >", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("comment_total >=", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalLessThan(Short value) {
            addCriterion("comment_total <", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalLessThanOrEqualTo(Short value) {
            addCriterion("comment_total <=", value, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalIn(List<Short> values) {
            addCriterion("comment_total in", values, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotIn(List<Short> values) {
            addCriterion("comment_total not in", values, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalBetween(Short value1, Short value2) {
            addCriterion("comment_total between", value1, value2, "commentTotal");
            return (Criteria) this;
        }

        public Criteria andCommentTotalNotBetween(Short value1, Short value2) {
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

        public Criteria andSortEqualTo(Short value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsPackageIsNull() {
            addCriterion("is_package is null");
            return (Criteria) this;
        }

        public Criteria andIsPackageIsNotNull() {
            addCriterion("is_package is not null");
            return (Criteria) this;
        }

        public Criteria andIsPackageEqualTo(Byte value) {
            addCriterion("is_package =", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotEqualTo(Byte value) {
            addCriterion("is_package <>", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThan(Byte value) {
            addCriterion("is_package >", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_package >=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThan(Byte value) {
            addCriterion("is_package <", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageLessThanOrEqualTo(Byte value) {
            addCriterion("is_package <=", value, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageIn(List<Byte> values) {
            addCriterion("is_package in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotIn(List<Byte> values) {
            addCriterion("is_package not in", values, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageBetween(Byte value1, Byte value2) {
            addCriterion("is_package between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andIsPackageNotBetween(Byte value1, Byte value2) {
            addCriterion("is_package not between", value1, value2, "isPackage");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("pay_way is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(String value) {
            addCriterion("pay_way =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(String value) {
            addCriterion("pay_way <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(String value) {
            addCriterion("pay_way >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("pay_way >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(String value) {
            addCriterion("pay_way <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(String value) {
            addCriterion("pay_way <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLike(String value) {
            addCriterion("pay_way like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotLike(String value) {
            addCriterion("pay_way not like", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<String> values) {
            addCriterion("pay_way in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<String> values) {
            addCriterion("pay_way not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(String value1, String value2) {
            addCriterion("pay_way between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(String value1, String value2) {
            addCriterion("pay_way not between", value1, value2, "payWay");
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

        public Criteria andOutTimeDayIsNull() {
            addCriterion("out_time_day is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayIsNotNull() {
            addCriterion("out_time_day is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayEqualTo(Byte value) {
            addCriterion("out_time_day =", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayNotEqualTo(Byte value) {
            addCriterion("out_time_day <>", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayGreaterThan(Byte value) {
            addCriterion("out_time_day >", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayGreaterThanOrEqualTo(Byte value) {
            addCriterion("out_time_day >=", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayLessThan(Byte value) {
            addCriterion("out_time_day <", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayLessThanOrEqualTo(Byte value) {
            addCriterion("out_time_day <=", value, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayIn(List<Byte> values) {
            addCriterion("out_time_day in", values, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayNotIn(List<Byte> values) {
            addCriterion("out_time_day not in", values, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayBetween(Byte value1, Byte value2) {
            addCriterion("out_time_day between", value1, value2, "outTimeDay");
            return (Criteria) this;
        }

        public Criteria andOutTimeDayNotBetween(Byte value1, Byte value2) {
            addCriterion("out_time_day not between", value1, value2, "outTimeDay");
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
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