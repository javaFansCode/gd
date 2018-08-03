package com.airmcl.air.beautician.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeauticianExperienceExample extends AbstractExample<BeauticianExperience> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<BeauticianExperience> pageView = new PageView<BeauticianExperience>(1, 10);

    private static final long serialVersionUID = 1L;

    public BeauticianExperienceExample() {
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
    public PageView<BeauticianExperience> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<BeauticianExperience> pageView) {
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

        public Criteria andBtIdIsNull() {
            addCriterion("bt_id is null");
            return (Criteria) this;
        }

        public Criteria andBtIdIsNotNull() {
            addCriterion("bt_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtIdEqualTo(Integer value) {
            addCriterion("bt_id =", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotEqualTo(Integer value) {
            addCriterion("bt_id <>", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThan(Integer value) {
            addCriterion("bt_id >", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bt_id >=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThan(Integer value) {
            addCriterion("bt_id <", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThanOrEqualTo(Integer value) {
            addCriterion("bt_id <=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdIn(List<Integer> values) {
            addCriterion("bt_id in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotIn(List<Integer> values) {
            addCriterion("bt_id not in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdBetween(Integer value1, Integer value2) {
            addCriterion("bt_id between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bt_id not between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Integer value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Integer value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Integer value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Integer value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Integer value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Integer> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Integer> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Integer value1, Integer value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Integer value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Integer value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Integer value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Integer value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Integer value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Integer> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Integer> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Integer value1, Integer value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andBeautyNameIsNull() {
            addCriterion("beauty_name is null");
            return (Criteria) this;
        }

        public Criteria andBeautyNameIsNotNull() {
            addCriterion("beauty_name is not null");
            return (Criteria) this;
        }

        public Criteria andBeautyNameEqualTo(String value) {
            addCriterion("beauty_name =", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameNotEqualTo(String value) {
            addCriterion("beauty_name <>", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameGreaterThan(String value) {
            addCriterion("beauty_name >", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameGreaterThanOrEqualTo(String value) {
            addCriterion("beauty_name >=", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameLessThan(String value) {
            addCriterion("beauty_name <", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameLessThanOrEqualTo(String value) {
            addCriterion("beauty_name <=", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameLike(String value) {
            addCriterion("beauty_name like", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameNotLike(String value) {
            addCriterion("beauty_name not like", value, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameIn(List<String> values) {
            addCriterion("beauty_name in", values, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameNotIn(List<String> values) {
            addCriterion("beauty_name not in", values, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameBetween(String value1, String value2) {
            addCriterion("beauty_name between", value1, value2, "beautyName");
            return (Criteria) this;
        }

        public Criteria andBeautyNameNotBetween(String value1, String value2) {
            addCriterion("beauty_name not between", value1, value2, "beautyName");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdIsNull() {
            addCriterion("job_title_id is null");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdIsNotNull() {
            addCriterion("job_title_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdEqualTo(Integer value) {
            addCriterion("job_title_id =", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdNotEqualTo(Integer value) {
            addCriterion("job_title_id <>", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdGreaterThan(Integer value) {
            addCriterion("job_title_id >", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_title_id >=", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdLessThan(Integer value) {
            addCriterion("job_title_id <", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdLessThanOrEqualTo(Integer value) {
            addCriterion("job_title_id <=", value, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdIn(List<Integer> values) {
            addCriterion("job_title_id in", values, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdNotIn(List<Integer> values) {
            addCriterion("job_title_id not in", values, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdBetween(Integer value1, Integer value2) {
            addCriterion("job_title_id between", value1, value2, "jobTitleId");
            return (Criteria) this;
        }

        public Criteria andJobTitleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("job_title_id not between", value1, value2, "jobTitleId");
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