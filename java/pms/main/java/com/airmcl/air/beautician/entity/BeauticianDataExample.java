package com.airmcl.air.beautician.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BeauticianDataExample extends AbstractExample<BeauticianData> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<BeauticianData> pageView = new PageView<BeauticianData>(1, 10);

    private static final long serialVersionUID = 1L;

    public BeauticianDataExample() {
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
    public PageView<BeauticianData> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<BeauticianData> pageView) {
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

        public Criteria andDatetimeIsNull() {
            addCriterion("datetime is null");
            return (Criteria) this;
        }

        public Criteria andDatetimeIsNotNull() {
            addCriterion("datetime is not null");
            return (Criteria) this;
        }

        public Criteria andDatetimeEqualTo(Integer value) {
            addCriterion("datetime =", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotEqualTo(Integer value) {
            addCriterion("datetime <>", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThan(Integer value) {
            addCriterion("datetime >", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("datetime >=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThan(Integer value) {
            addCriterion("datetime <", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("datetime <=", value, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeIn(List<Integer> values) {
            addCriterion("datetime in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotIn(List<Integer> values) {
            addCriterion("datetime not in", values, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeBetween(Integer value1, Integer value2) {
            addCriterion("datetime between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andDatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("datetime not between", value1, value2, "datetime");
            return (Criteria) this;
        }

        public Criteria andStreamIsNull() {
            addCriterion("stream is null");
            return (Criteria) this;
        }

        public Criteria andStreamIsNotNull() {
            addCriterion("stream is not null");
            return (Criteria) this;
        }

        public Criteria andStreamEqualTo(BigDecimal value) {
            addCriterion("stream =", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamNotEqualTo(BigDecimal value) {
            addCriterion("stream <>", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamGreaterThan(BigDecimal value) {
            addCriterion("stream >", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stream >=", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamLessThan(BigDecimal value) {
            addCriterion("stream <", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stream <=", value, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamIn(List<BigDecimal> values) {
            addCriterion("stream in", values, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamNotIn(List<BigDecimal> values) {
            addCriterion("stream not in", values, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stream between", value1, value2, "stream");
            return (Criteria) this;
        }

        public Criteria andStreamNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stream not between", value1, value2, "stream");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(BigDecimal value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(BigDecimal value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(BigDecimal value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(BigDecimal value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<BigDecimal> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<BigDecimal> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andServiceuserIsNull() {
            addCriterion("serviceUser is null");
            return (Criteria) this;
        }

        public Criteria andServiceuserIsNotNull() {
            addCriterion("serviceUser is not null");
            return (Criteria) this;
        }

        public Criteria andServiceuserEqualTo(Integer value) {
            addCriterion("serviceUser =", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserNotEqualTo(Integer value) {
            addCriterion("serviceUser <>", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserGreaterThan(Integer value) {
            addCriterion("serviceUser >", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("serviceUser >=", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserLessThan(Integer value) {
            addCriterion("serviceUser <", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserLessThanOrEqualTo(Integer value) {
            addCriterion("serviceUser <=", value, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserIn(List<Integer> values) {
            addCriterion("serviceUser in", values, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserNotIn(List<Integer> values) {
            addCriterion("serviceUser not in", values, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserBetween(Integer value1, Integer value2) {
            addCriterion("serviceUser between", value1, value2, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andServiceuserNotBetween(Integer value1, Integer value2) {
            addCriterion("serviceUser not between", value1, value2, "serviceuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserIsNull() {
            addCriterion("assignUser is null");
            return (Criteria) this;
        }

        public Criteria andAssignuserIsNotNull() {
            addCriterion("assignUser is not null");
            return (Criteria) this;
        }

        public Criteria andAssignuserEqualTo(Integer value) {
            addCriterion("assignUser =", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserNotEqualTo(Integer value) {
            addCriterion("assignUser <>", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserGreaterThan(Integer value) {
            addCriterion("assignUser >", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("assignUser >=", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserLessThan(Integer value) {
            addCriterion("assignUser <", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserLessThanOrEqualTo(Integer value) {
            addCriterion("assignUser <=", value, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserIn(List<Integer> values) {
            addCriterion("assignUser in", values, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserNotIn(List<Integer> values) {
            addCriterion("assignUser not in", values, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserBetween(Integer value1, Integer value2) {
            addCriterion("assignUser between", value1, value2, "assignuser");
            return (Criteria) this;
        }

        public Criteria andAssignuserNotBetween(Integer value1, Integer value2) {
            addCriterion("assignUser not between", value1, value2, "assignuser");
            return (Criteria) this;
        }

        public Criteria andContentserviceIsNull() {
            addCriterion("contentService is null");
            return (Criteria) this;
        }

        public Criteria andContentserviceIsNotNull() {
            addCriterion("contentService is not null");
            return (Criteria) this;
        }

        public Criteria andContentserviceEqualTo(Integer value) {
            addCriterion("contentService =", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceNotEqualTo(Integer value) {
            addCriterion("contentService <>", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceGreaterThan(Integer value) {
            addCriterion("contentService >", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceGreaterThanOrEqualTo(Integer value) {
            addCriterion("contentService >=", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceLessThan(Integer value) {
            addCriterion("contentService <", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceLessThanOrEqualTo(Integer value) {
            addCriterion("contentService <=", value, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceIn(List<Integer> values) {
            addCriterion("contentService in", values, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceNotIn(List<Integer> values) {
            addCriterion("contentService not in", values, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceBetween(Integer value1, Integer value2) {
            addCriterion("contentService between", value1, value2, "contentservice");
            return (Criteria) this;
        }

        public Criteria andContentserviceNotBetween(Integer value1, Integer value2) {
            addCriterion("contentService not between", value1, value2, "contentservice");
            return (Criteria) this;
        }

        public Criteria andAllorderIsNull() {
            addCriterion("allOrder is null");
            return (Criteria) this;
        }

        public Criteria andAllorderIsNotNull() {
            addCriterion("allOrder is not null");
            return (Criteria) this;
        }

        public Criteria andAllorderEqualTo(Integer value) {
            addCriterion("allOrder =", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderNotEqualTo(Integer value) {
            addCriterion("allOrder <>", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderGreaterThan(Integer value) {
            addCriterion("allOrder >", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("allOrder >=", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderLessThan(Integer value) {
            addCriterion("allOrder <", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderLessThanOrEqualTo(Integer value) {
            addCriterion("allOrder <=", value, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderIn(List<Integer> values) {
            addCriterion("allOrder in", values, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderNotIn(List<Integer> values) {
            addCriterion("allOrder not in", values, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderBetween(Integer value1, Integer value2) {
            addCriterion("allOrder between", value1, value2, "allorder");
            return (Criteria) this;
        }

        public Criteria andAllorderNotBetween(Integer value1, Integer value2) {
            addCriterion("allOrder not between", value1, value2, "allorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderIsNull() {
            addCriterion("finishOrder is null");
            return (Criteria) this;
        }

        public Criteria andFinishorderIsNotNull() {
            addCriterion("finishOrder is not null");
            return (Criteria) this;
        }

        public Criteria andFinishorderEqualTo(Integer value) {
            addCriterion("finishOrder =", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderNotEqualTo(Integer value) {
            addCriterion("finishOrder <>", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderGreaterThan(Integer value) {
            addCriterion("finishOrder >", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("finishOrder >=", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderLessThan(Integer value) {
            addCriterion("finishOrder <", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderLessThanOrEqualTo(Integer value) {
            addCriterion("finishOrder <=", value, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderIn(List<Integer> values) {
            addCriterion("finishOrder in", values, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderNotIn(List<Integer> values) {
            addCriterion("finishOrder not in", values, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderBetween(Integer value1, Integer value2) {
            addCriterion("finishOrder between", value1, value2, "finishorder");
            return (Criteria) this;
        }

        public Criteria andFinishorderNotBetween(Integer value1, Integer value2) {
            addCriterion("finishOrder not between", value1, value2, "finishorder");
            return (Criteria) this;
        }

        public Criteria andPendorderIsNull() {
            addCriterion("pendOrder is null");
            return (Criteria) this;
        }

        public Criteria andPendorderIsNotNull() {
            addCriterion("pendOrder is not null");
            return (Criteria) this;
        }

        public Criteria andPendorderEqualTo(Integer value) {
            addCriterion("pendOrder =", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderNotEqualTo(Integer value) {
            addCriterion("pendOrder <>", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderGreaterThan(Integer value) {
            addCriterion("pendOrder >", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("pendOrder >=", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderLessThan(Integer value) {
            addCriterion("pendOrder <", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderLessThanOrEqualTo(Integer value) {
            addCriterion("pendOrder <=", value, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderIn(List<Integer> values) {
            addCriterion("pendOrder in", values, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderNotIn(List<Integer> values) {
            addCriterion("pendOrder not in", values, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderBetween(Integer value1, Integer value2) {
            addCriterion("pendOrder between", value1, value2, "pendorder");
            return (Criteria) this;
        }

        public Criteria andPendorderNotBetween(Integer value1, Integer value2) {
            addCriterion("pendOrder not between", value1, value2, "pendorder");
            return (Criteria) this;
        }

        public Criteria andAlipayIsNull() {
            addCriterion("alipay is null");
            return (Criteria) this;
        }

        public Criteria andAlipayIsNotNull() {
            addCriterion("alipay is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayEqualTo(String value) {
            addCriterion("alipay =", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotEqualTo(String value) {
            addCriterion("alipay <>", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayGreaterThan(String value) {
            addCriterion("alipay >", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayGreaterThanOrEqualTo(String value) {
            addCriterion("alipay >=", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLessThan(String value) {
            addCriterion("alipay <", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLessThanOrEqualTo(String value) {
            addCriterion("alipay <=", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayLike(String value) {
            addCriterion("alipay like", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotLike(String value) {
            addCriterion("alipay not like", value, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayIn(List<String> values) {
            addCriterion("alipay in", values, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotIn(List<String> values) {
            addCriterion("alipay not in", values, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayBetween(String value1, String value2) {
            addCriterion("alipay between", value1, value2, "alipay");
            return (Criteria) this;
        }

        public Criteria andAlipayNotBetween(String value1, String value2) {
            addCriterion("alipay not between", value1, value2, "alipay");
            return (Criteria) this;
        }

        public Criteria andWxpayIsNull() {
            addCriterion("wxpay is null");
            return (Criteria) this;
        }

        public Criteria andWxpayIsNotNull() {
            addCriterion("wxpay is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayEqualTo(String value) {
            addCriterion("wxpay =", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayNotEqualTo(String value) {
            addCriterion("wxpay <>", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayGreaterThan(String value) {
            addCriterion("wxpay >", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayGreaterThanOrEqualTo(String value) {
            addCriterion("wxpay >=", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayLessThan(String value) {
            addCriterion("wxpay <", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayLessThanOrEqualTo(String value) {
            addCriterion("wxpay <=", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayLike(String value) {
            addCriterion("wxpay like", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayNotLike(String value) {
            addCriterion("wxpay not like", value, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayIn(List<String> values) {
            addCriterion("wxpay in", values, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayNotIn(List<String> values) {
            addCriterion("wxpay not in", values, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayBetween(String value1, String value2) {
            addCriterion("wxpay between", value1, value2, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWxpayNotBetween(String value1, String value2) {
            addCriterion("wxpay not between", value1, value2, "wxpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayIsNull() {
            addCriterion("walletpay is null");
            return (Criteria) this;
        }

        public Criteria andWalletpayIsNotNull() {
            addCriterion("walletpay is not null");
            return (Criteria) this;
        }

        public Criteria andWalletpayEqualTo(String value) {
            addCriterion("walletpay =", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayNotEqualTo(String value) {
            addCriterion("walletpay <>", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayGreaterThan(String value) {
            addCriterion("walletpay >", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayGreaterThanOrEqualTo(String value) {
            addCriterion("walletpay >=", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayLessThan(String value) {
            addCriterion("walletpay <", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayLessThanOrEqualTo(String value) {
            addCriterion("walletpay <=", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayLike(String value) {
            addCriterion("walletpay like", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayNotLike(String value) {
            addCriterion("walletpay not like", value, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayIn(List<String> values) {
            addCriterion("walletpay in", values, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayNotIn(List<String> values) {
            addCriterion("walletpay not in", values, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayBetween(String value1, String value2) {
            addCriterion("walletpay between", value1, value2, "walletpay");
            return (Criteria) this;
        }

        public Criteria andWalletpayNotBetween(String value1, String value2) {
            addCriterion("walletpay not between", value1, value2, "walletpay");
            return (Criteria) this;
        }

        public Criteria andPackagepayIsNull() {
            addCriterion("packagepay is null");
            return (Criteria) this;
        }

        public Criteria andPackagepayIsNotNull() {
            addCriterion("packagepay is not null");
            return (Criteria) this;
        }

        public Criteria andPackagepayEqualTo(String value) {
            addCriterion("packagepay =", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayNotEqualTo(String value) {
            addCriterion("packagepay <>", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayGreaterThan(String value) {
            addCriterion("packagepay >", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayGreaterThanOrEqualTo(String value) {
            addCriterion("packagepay >=", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayLessThan(String value) {
            addCriterion("packagepay <", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayLessThanOrEqualTo(String value) {
            addCriterion("packagepay <=", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayLike(String value) {
            addCriterion("packagepay like", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayNotLike(String value) {
            addCriterion("packagepay not like", value, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayIn(List<String> values) {
            addCriterion("packagepay in", values, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayNotIn(List<String> values) {
            addCriterion("packagepay not in", values, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayBetween(String value1, String value2) {
            addCriterion("packagepay between", value1, value2, "packagepay");
            return (Criteria) this;
        }

        public Criteria andPackagepayNotBetween(String value1, String value2) {
            addCriterion("packagepay not between", value1, value2, "packagepay");
            return (Criteria) this;
        }

        public Criteria andAllcommentIsNull() {
            addCriterion("allComment is null");
            return (Criteria) this;
        }

        public Criteria andAllcommentIsNotNull() {
            addCriterion("allComment is not null");
            return (Criteria) this;
        }

        public Criteria andAllcommentEqualTo(Integer value) {
            addCriterion("allComment =", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentNotEqualTo(Integer value) {
            addCriterion("allComment <>", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentGreaterThan(Integer value) {
            addCriterion("allComment >", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("allComment >=", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentLessThan(Integer value) {
            addCriterion("allComment <", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentLessThanOrEqualTo(Integer value) {
            addCriterion("allComment <=", value, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentIn(List<Integer> values) {
            addCriterion("allComment in", values, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentNotIn(List<Integer> values) {
            addCriterion("allComment not in", values, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentBetween(Integer value1, Integer value2) {
            addCriterion("allComment between", value1, value2, "allcomment");
            return (Criteria) this;
        }

        public Criteria andAllcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("allComment not between", value1, value2, "allcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentIsNull() {
            addCriterion("goodComment is null");
            return (Criteria) this;
        }

        public Criteria andGoodcommentIsNotNull() {
            addCriterion("goodComment is not null");
            return (Criteria) this;
        }

        public Criteria andGoodcommentEqualTo(Integer value) {
            addCriterion("goodComment =", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentNotEqualTo(Integer value) {
            addCriterion("goodComment <>", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentGreaterThan(Integer value) {
            addCriterion("goodComment >", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodComment >=", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentLessThan(Integer value) {
            addCriterion("goodComment <", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentLessThanOrEqualTo(Integer value) {
            addCriterion("goodComment <=", value, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentIn(List<Integer> values) {
            addCriterion("goodComment in", values, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentNotIn(List<Integer> values) {
            addCriterion("goodComment not in", values, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentBetween(Integer value1, Integer value2) {
            addCriterion("goodComment between", value1, value2, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andGoodcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("goodComment not between", value1, value2, "goodcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentIsNull() {
            addCriterion("mediumComment is null");
            return (Criteria) this;
        }

        public Criteria andMediumcommentIsNotNull() {
            addCriterion("mediumComment is not null");
            return (Criteria) this;
        }

        public Criteria andMediumcommentEqualTo(Integer value) {
            addCriterion("mediumComment =", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentNotEqualTo(Integer value) {
            addCriterion("mediumComment <>", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentGreaterThan(Integer value) {
            addCriterion("mediumComment >", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("mediumComment >=", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentLessThan(Integer value) {
            addCriterion("mediumComment <", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentLessThanOrEqualTo(Integer value) {
            addCriterion("mediumComment <=", value, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentIn(List<Integer> values) {
            addCriterion("mediumComment in", values, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentNotIn(List<Integer> values) {
            addCriterion("mediumComment not in", values, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentBetween(Integer value1, Integer value2) {
            addCriterion("mediumComment between", value1, value2, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andMediumcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("mediumComment not between", value1, value2, "mediumcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentIsNull() {
            addCriterion("badComment is null");
            return (Criteria) this;
        }

        public Criteria andBadcommentIsNotNull() {
            addCriterion("badComment is not null");
            return (Criteria) this;
        }

        public Criteria andBadcommentEqualTo(Integer value) {
            addCriterion("badComment =", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentNotEqualTo(Integer value) {
            addCriterion("badComment <>", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentGreaterThan(Integer value) {
            addCriterion("badComment >", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("badComment >=", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentLessThan(Integer value) {
            addCriterion("badComment <", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentLessThanOrEqualTo(Integer value) {
            addCriterion("badComment <=", value, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentIn(List<Integer> values) {
            addCriterion("badComment in", values, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentNotIn(List<Integer> values) {
            addCriterion("badComment not in", values, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentBetween(Integer value1, Integer value2) {
            addCriterion("badComment between", value1, value2, "badcomment");
            return (Criteria) this;
        }

        public Criteria andBadcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("badComment not between", value1, value2, "badcomment");
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

        public Criteria andCouponpayIsNull() {
            addCriterion("couponpay is null");
            return (Criteria) this;
        }

        public Criteria andCouponpayIsNotNull() {
            addCriterion("couponpay is not null");
            return (Criteria) this;
        }

        public Criteria andCouponpayEqualTo(String value) {
            addCriterion("couponpay =", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayNotEqualTo(String value) {
            addCriterion("couponpay <>", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayGreaterThan(String value) {
            addCriterion("couponpay >", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayGreaterThanOrEqualTo(String value) {
            addCriterion("couponpay >=", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayLessThan(String value) {
            addCriterion("couponpay <", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayLessThanOrEqualTo(String value) {
            addCriterion("couponpay <=", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayLike(String value) {
            addCriterion("couponpay like", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayNotLike(String value) {
            addCriterion("couponpay not like", value, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayIn(List<String> values) {
            addCriterion("couponpay in", values, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayNotIn(List<String> values) {
            addCriterion("couponpay not in", values, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayBetween(String value1, String value2) {
            addCriterion("couponpay between", value1, value2, "couponpay");
            return (Criteria) this;
        }

        public Criteria andCouponpayNotBetween(String value1, String value2) {
            addCriterion("couponpay not between", value1, value2, "couponpay");
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