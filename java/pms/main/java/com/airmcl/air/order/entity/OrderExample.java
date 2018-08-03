package com.airmcl.air.order.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderExample extends AbstractExample<Order> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Order> pageView = new PageView<Order>(1, 10);

    private static final long serialVersionUID = 1L;

    public OrderExample() {
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
    public PageView<Order> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Order> pageView) {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNull() {
            addCriterion("order_number is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIsNotNull() {
            addCriterion("order_number is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumberEqualTo(String value) {
            addCriterion("order_number =", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotEqualTo(String value) {
            addCriterion("order_number <>", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThan(String value) {
            addCriterion("order_number >", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberGreaterThanOrEqualTo(String value) {
            addCriterion("order_number >=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThan(String value) {
            addCriterion("order_number <", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLessThanOrEqualTo(String value) {
            addCriterion("order_number <=", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberLike(String value) {
            addCriterion("order_number like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotLike(String value) {
            addCriterion("order_number not like", value, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberIn(List<String> values) {
            addCriterion("order_number in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotIn(List<String> values) {
            addCriterion("order_number not in", values, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberBetween(String value1, String value2) {
            addCriterion("order_number between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andOrderNumberNotBetween(String value1, String value2) {
            addCriterion("order_number not between", value1, value2, "orderNumber");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(String value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(String value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(String value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(String value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(String value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(String value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLike(String value) {
            addCriterion("service_id like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotLike(String value) {
            addCriterion("service_id not like", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<String> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<String> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(String value1, String value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(String value1, String value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
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

        public Criteria andServiceTimeEqualTo(Short value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(Short value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(Short value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(Short value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(Short value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(Short value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<Short> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<Short> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(Short value1, Short value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(Short value1, Short value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(Integer value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(Integer value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(Integer value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(Integer value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<Integer> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<Integer> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdIsNull() {
            addCriterion("month_card_id is null");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdIsNotNull() {
            addCriterion("month_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdEqualTo(Integer value) {
            addCriterion("month_card_id =", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdNotEqualTo(Integer value) {
            addCriterion("month_card_id <>", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdGreaterThan(Integer value) {
            addCriterion("month_card_id >", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_card_id >=", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdLessThan(Integer value) {
            addCriterion("month_card_id <", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("month_card_id <=", value, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdIn(List<Integer> values) {
            addCriterion("month_card_id in", values, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdNotIn(List<Integer> values) {
            addCriterion("month_card_id not in", values, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdBetween(Integer value1, Integer value2) {
            addCriterion("month_card_id between", value1, value2, "monthCardId");
            return (Criteria) this;
        }

        public Criteria andMonthCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("month_card_id not between", value1, value2, "monthCardId");
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

        public Criteria andBtNameIsNull() {
            addCriterion("bt_name is null");
            return (Criteria) this;
        }

        public Criteria andBtNameIsNotNull() {
            addCriterion("bt_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtNameEqualTo(String value) {
            addCriterion("bt_name =", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotEqualTo(String value) {
            addCriterion("bt_name <>", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameGreaterThan(String value) {
            addCriterion("bt_name >", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameGreaterThanOrEqualTo(String value) {
            addCriterion("bt_name >=", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLessThan(String value) {
            addCriterion("bt_name <", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLessThanOrEqualTo(String value) {
            addCriterion("bt_name <=", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameLike(String value) {
            addCriterion("bt_name like", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotLike(String value) {
            addCriterion("bt_name not like", value, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameIn(List<String> values) {
            addCriterion("bt_name in", values, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotIn(List<String> values) {
            addCriterion("bt_name not in", values, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameBetween(String value1, String value2) {
            addCriterion("bt_name between", value1, value2, "btName");
            return (Criteria) this;
        }

        public Criteria andBtNameNotBetween(String value1, String value2) {
            addCriterion("bt_name not between", value1, value2, "btName");
            return (Criteria) this;
        }

        public Criteria andBtMobileIsNull() {
            addCriterion("bt_mobile is null");
            return (Criteria) this;
        }

        public Criteria andBtMobileIsNotNull() {
            addCriterion("bt_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andBtMobileEqualTo(String value) {
            addCriterion("bt_mobile =", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileNotEqualTo(String value) {
            addCriterion("bt_mobile <>", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileGreaterThan(String value) {
            addCriterion("bt_mobile >", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileGreaterThanOrEqualTo(String value) {
            addCriterion("bt_mobile >=", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileLessThan(String value) {
            addCriterion("bt_mobile <", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileLessThanOrEqualTo(String value) {
            addCriterion("bt_mobile <=", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileLike(String value) {
            addCriterion("bt_mobile like", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileNotLike(String value) {
            addCriterion("bt_mobile not like", value, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileIn(List<String> values) {
            addCriterion("bt_mobile in", values, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileNotIn(List<String> values) {
            addCriterion("bt_mobile not in", values, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileBetween(String value1, String value2) {
            addCriterion("bt_mobile between", value1, value2, "btMobile");
            return (Criteria) this;
        }

        public Criteria andBtMobileNotBetween(String value1, String value2) {
            addCriterion("bt_mobile not between", value1, value2, "btMobile");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileIsNull() {
            addCriterion("referee_mobile is null");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileIsNotNull() {
            addCriterion("referee_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileEqualTo(Integer value) {
            addCriterion("referee_mobile =", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotEqualTo(Integer value) {
            addCriterion("referee_mobile <>", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileGreaterThan(Integer value) {
            addCriterion("referee_mobile >", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileGreaterThanOrEqualTo(Integer value) {
            addCriterion("referee_mobile >=", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileLessThan(Integer value) {
            addCriterion("referee_mobile <", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileLessThanOrEqualTo(Integer value) {
            addCriterion("referee_mobile <=", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileIn(List<Integer> values) {
            addCriterion("referee_mobile in", values, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotIn(List<Integer> values) {
            addCriterion("referee_mobile not in", values, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileBetween(Integer value1, Integer value2) {
            addCriterion("referee_mobile between", value1, value2, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotBetween(Integer value1, Integer value2) {
            addCriterion("referee_mobile not between", value1, value2, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andChangePriceIsNull() {
            addCriterion("change_price is null");
            return (Criteria) this;
        }

        public Criteria andChangePriceIsNotNull() {
            addCriterion("change_price is not null");
            return (Criteria) this;
        }

        public Criteria andChangePriceEqualTo(BigDecimal value) {
            addCriterion("change_price =", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceNotEqualTo(BigDecimal value) {
            addCriterion("change_price <>", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceGreaterThan(BigDecimal value) {
            addCriterion("change_price >", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("change_price >=", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceLessThan(BigDecimal value) {
            addCriterion("change_price <", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("change_price <=", value, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceIn(List<BigDecimal> values) {
            addCriterion("change_price in", values, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceNotIn(List<BigDecimal> values) {
            addCriterion("change_price not in", values, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_price between", value1, value2, "changePrice");
            return (Criteria) this;
        }

        public Criteria andChangePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change_price not between", value1, value2, "changePrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNull() {
            addCriterion("actual_price is null");
            return (Criteria) this;
        }

        public Criteria andActualPriceIsNotNull() {
            addCriterion("actual_price is not null");
            return (Criteria) this;
        }

        public Criteria andActualPriceEqualTo(BigDecimal value) {
            addCriterion("actual_price =", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotEqualTo(BigDecimal value) {
            addCriterion("actual_price <>", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThan(BigDecimal value) {
            addCriterion("actual_price >", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_price >=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThan(BigDecimal value) {
            addCriterion("actual_price <", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_price <=", value, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceIn(List<BigDecimal> values) {
            addCriterion("actual_price in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotIn(List<BigDecimal> values) {
            addCriterion("actual_price not in", values, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_price between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andActualPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_price not between", value1, value2, "actualPrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceIsNull() {
            addCriterion("reduce_price is null");
            return (Criteria) this;
        }

        public Criteria andReducePriceIsNotNull() {
            addCriterion("reduce_price is not null");
            return (Criteria) this;
        }

        public Criteria andReducePriceEqualTo(BigDecimal value) {
            addCriterion("reduce_price =", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceNotEqualTo(BigDecimal value) {
            addCriterion("reduce_price <>", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceGreaterThan(BigDecimal value) {
            addCriterion("reduce_price >", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reduce_price >=", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceLessThan(BigDecimal value) {
            addCriterion("reduce_price <", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reduce_price <=", value, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceIn(List<BigDecimal> values) {
            addCriterion("reduce_price in", values, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceNotIn(List<BigDecimal> values) {
            addCriterion("reduce_price not in", values, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduce_price between", value1, value2, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andReducePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduce_price not between", value1, value2, "reducePrice");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageIsNull() {
            addCriterion("is_user_package is null");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageIsNotNull() {
            addCriterion("is_user_package is not null");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageEqualTo(Byte value) {
            addCriterion("is_user_package =", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageNotEqualTo(Byte value) {
            addCriterion("is_user_package <>", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageGreaterThan(Byte value) {
            addCriterion("is_user_package >", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_user_package >=", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageLessThan(Byte value) {
            addCriterion("is_user_package <", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageLessThanOrEqualTo(Byte value) {
            addCriterion("is_user_package <=", value, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageIn(List<Byte> values) {
            addCriterion("is_user_package in", values, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageNotIn(List<Byte> values) {
            addCriterion("is_user_package not in", values, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageBetween(Byte value1, Byte value2) {
            addCriterion("is_user_package between", value1, value2, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andIsUserPackageNotBetween(Byte value1, Byte value2) {
            addCriterion("is_user_package not between", value1, value2, "isUserPackage");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Byte value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Byte value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Byte value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Byte value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Byte> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Byte> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeIsNull() {
            addCriterion("order_industry_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeIsNotNull() {
            addCriterion("order_industry_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeEqualTo(Byte value) {
            addCriterion("order_industry_type =", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeNotEqualTo(Byte value) {
            addCriterion("order_industry_type <>", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeGreaterThan(Byte value) {
            addCriterion("order_industry_type >", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_industry_type >=", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeLessThan(Byte value) {
            addCriterion("order_industry_type <", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_industry_type <=", value, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeIn(List<Byte> values) {
            addCriterion("order_industry_type in", values, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeNotIn(List<Byte> values) {
            addCriterion("order_industry_type not in", values, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_industry_type between", value1, value2, "orderIndustryType");
            return (Criteria) this;
        }

        public Criteria andOrderIndustryTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_industry_type not between", value1, value2, "orderIndustryType");
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

        public Criteria andPayWayIsNull() {
            addCriterion("pay_way is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(Byte value) {
            addCriterion("pay_way =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(Byte value) {
            addCriterion("pay_way <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(Byte value) {
            addCriterion("pay_way >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("pay_way >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(Byte value) {
            addCriterion("pay_way <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(Byte value) {
            addCriterion("pay_way <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<Byte> values) {
            addCriterion("pay_way in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<Byte> values) {
            addCriterion("pay_way not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(Byte value1, Byte value2) {
            addCriterion("pay_way between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(Byte value1, Byte value2) {
            addCriterion("pay_way not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIsNull() {
            addCriterion("service_start_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIsNotNull() {
            addCriterion("service_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeEqualTo(Integer value) {
            addCriterion("service_start_time =", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotEqualTo(Integer value) {
            addCriterion("service_start_time <>", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeGreaterThan(Integer value) {
            addCriterion("service_start_time >", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_start_time >=", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeLessThan(Integer value) {
            addCriterion("service_start_time <", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("service_start_time <=", value, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeIn(List<Integer> values) {
            addCriterion("service_start_time in", values, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotIn(List<Integer> values) {
            addCriterion("service_start_time not in", values, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("service_start_time between", value1, value2, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_start_time not between", value1, value2, "serviceStartTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIsNull() {
            addCriterion("service_end_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIsNotNull() {
            addCriterion("service_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeEqualTo(Integer value) {
            addCriterion("service_end_time =", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotEqualTo(Integer value) {
            addCriterion("service_end_time <>", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeGreaterThan(Integer value) {
            addCriterion("service_end_time >", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_end_time >=", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeLessThan(Integer value) {
            addCriterion("service_end_time <", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeLessThanOrEqualTo(Integer value) {
            addCriterion("service_end_time <=", value, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeIn(List<Integer> values) {
            addCriterion("service_end_time in", values, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotIn(List<Integer> values) {
            addCriterion("service_end_time not in", values, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeBetween(Integer value1, Integer value2) {
            addCriterion("service_end_time between", value1, value2, "serviceEndTime");
            return (Criteria) this;
        }

        public Criteria andServiceEndTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("service_end_time not between", value1, value2, "serviceEndTime");
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

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Integer value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Integer value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Integer value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Integer value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Integer value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Integer> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Integer> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Integer value1, Integer value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIsNull() {
            addCriterion("reserve_time is null");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIsNotNull() {
            addCriterion("reserve_time is not null");
            return (Criteria) this;
        }

        public Criteria andReserveTimeEqualTo(Integer value) {
            addCriterion("reserve_time =", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotEqualTo(Integer value) {
            addCriterion("reserve_time <>", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeGreaterThan(Integer value) {
            addCriterion("reserve_time >", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("reserve_time >=", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeLessThan(Integer value) {
            addCriterion("reserve_time <", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeLessThanOrEqualTo(Integer value) {
            addCriterion("reserve_time <=", value, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeIn(List<Integer> values) {
            addCriterion("reserve_time in", values, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotIn(List<Integer> values) {
            addCriterion("reserve_time not in", values, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeBetween(Integer value1, Integer value2) {
            addCriterion("reserve_time between", value1, value2, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andReserveTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("reserve_time not between", value1, value2, "reserveTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Integer value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Integer value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Integer value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Integer value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Integer> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Integer> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Integer value1, Integer value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayIsNull() {
            addCriterion("buy_pay_way is null");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayIsNotNull() {
            addCriterion("buy_pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayEqualTo(String value) {
            addCriterion("buy_pay_way =", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayNotEqualTo(String value) {
            addCriterion("buy_pay_way <>", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayGreaterThan(String value) {
            addCriterion("buy_pay_way >", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayGreaterThanOrEqualTo(String value) {
            addCriterion("buy_pay_way >=", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayLessThan(String value) {
            addCriterion("buy_pay_way <", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayLessThanOrEqualTo(String value) {
            addCriterion("buy_pay_way <=", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayLike(String value) {
            addCriterion("buy_pay_way like", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayNotLike(String value) {
            addCriterion("buy_pay_way not like", value, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayIn(List<String> values) {
            addCriterion("buy_pay_way in", values, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayNotIn(List<String> values) {
            addCriterion("buy_pay_way not in", values, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayBetween(String value1, String value2) {
            addCriterion("buy_pay_way between", value1, value2, "buyPayWay");
            return (Criteria) this;
        }

        public Criteria andBuyPayWayNotBetween(String value1, String value2) {
            addCriterion("buy_pay_way not between", value1, value2, "buyPayWay");
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

        public Criteria andIscommentIsNull() {
            addCriterion("iscomment is null");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNotNull() {
            addCriterion("iscomment is not null");
            return (Criteria) this;
        }

        public Criteria andIscommentEqualTo(Byte value) {
            addCriterion("iscomment =", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotEqualTo(Byte value) {
            addCriterion("iscomment <>", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThan(Byte value) {
            addCriterion("iscomment >", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThanOrEqualTo(Byte value) {
            addCriterion("iscomment >=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThan(Byte value) {
            addCriterion("iscomment <", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThanOrEqualTo(Byte value) {
            addCriterion("iscomment <=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentIn(List<Byte> values) {
            addCriterion("iscomment in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotIn(List<Byte> values) {
            addCriterion("iscomment not in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentBetween(Byte value1, Byte value2) {
            addCriterion("iscomment between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotBetween(Byte value1, Byte value2) {
            addCriterion("iscomment not between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNull() {
            addCriterion("isreply is null");
            return (Criteria) this;
        }

        public Criteria andIsreplyIsNotNull() {
            addCriterion("isreply is not null");
            return (Criteria) this;
        }

        public Criteria andIsreplyEqualTo(Byte value) {
            addCriterion("isreply =", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotEqualTo(Byte value) {
            addCriterion("isreply <>", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThan(Byte value) {
            addCriterion("isreply >", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyGreaterThanOrEqualTo(Byte value) {
            addCriterion("isreply >=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThan(Byte value) {
            addCriterion("isreply <", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyLessThanOrEqualTo(Byte value) {
            addCriterion("isreply <=", value, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyIn(List<Byte> values) {
            addCriterion("isreply in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotIn(List<Byte> values) {
            addCriterion("isreply not in", values, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyBetween(Byte value1, Byte value2) {
            addCriterion("isreply between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andIsreplyNotBetween(Byte value1, Byte value2) {
            addCriterion("isreply not between", value1, value2, "isreply");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(Byte value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(Byte value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(Byte value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(Byte value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(Byte value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<Byte> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<Byte> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(Byte value1, Byte value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(Byte value1, Byte value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
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