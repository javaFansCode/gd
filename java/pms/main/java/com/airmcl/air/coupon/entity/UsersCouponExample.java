package com.airmcl.air.coupon.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UsersCouponExample extends AbstractExample<UsersCoupon> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<UsersCoupon> pageView = new PageView<UsersCoupon>(1, 10);

    private static final long serialVersionUID = 1L;

    public UsersCouponExample() {
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
    public PageView<UsersCoupon> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<UsersCoupon> pageView) {
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

        public Criteria andCouponTitleIsNull() {
            addCriterion("coupon_title is null");
            return (Criteria) this;
        }

        public Criteria andCouponTitleIsNotNull() {
            addCriterion("coupon_title is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTitleEqualTo(String value) {
            addCriterion("coupon_title =", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotEqualTo(String value) {
            addCriterion("coupon_title <>", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleGreaterThan(String value) {
            addCriterion("coupon_title >", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_title >=", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLessThan(String value) {
            addCriterion("coupon_title <", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLessThanOrEqualTo(String value) {
            addCriterion("coupon_title <=", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLike(String value) {
            addCriterion("coupon_title like", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotLike(String value) {
            addCriterion("coupon_title not like", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleIn(List<String> values) {
            addCriterion("coupon_title in", values, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotIn(List<String> values) {
            addCriterion("coupon_title not in", values, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleBetween(String value1, String value2) {
            addCriterion("coupon_title between", value1, value2, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotBetween(String value1, String value2) {
            addCriterion("coupon_title not between", value1, value2, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("send_type is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("send_type is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Byte value) {
            addCriterion("send_type =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Byte value) {
            addCriterion("send_type <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Byte value) {
            addCriterion("send_type >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("send_type >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Byte value) {
            addCriterion("send_type <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Byte value) {
            addCriterion("send_type <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Byte> values) {
            addCriterion("send_type in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Byte> values) {
            addCriterion("send_type not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Byte value1, Byte value2) {
            addCriterion("send_type between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("send_type not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(Byte value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(Byte value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(Byte value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(Byte value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(Byte value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<Byte> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<Byte> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(Byte value1, Byte value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("use_type not between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxIsNull() {
            addCriterion("money_max is null");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxIsNotNull() {
            addCriterion("money_max is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxEqualTo(BigDecimal value) {
            addCriterion("money_max =", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxNotEqualTo(BigDecimal value) {
            addCriterion("money_max <>", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxGreaterThan(BigDecimal value) {
            addCriterion("money_max >", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_max >=", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxLessThan(BigDecimal value) {
            addCriterion("money_max <", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_max <=", value, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxIn(List<BigDecimal> values) {
            addCriterion("money_max in", values, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxNotIn(List<BigDecimal> values) {
            addCriterion("money_max not in", values, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_max between", value1, value2, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_max not between", value1, value2, "moneyMax");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceIsNull() {
            addCriterion("money_reduce is null");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceIsNotNull() {
            addCriterion("money_reduce is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceEqualTo(BigDecimal value) {
            addCriterion("money_reduce =", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceNotEqualTo(BigDecimal value) {
            addCriterion("money_reduce <>", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceGreaterThan(BigDecimal value) {
            addCriterion("money_reduce >", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_reduce >=", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceLessThan(BigDecimal value) {
            addCriterion("money_reduce <", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_reduce <=", value, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceIn(List<BigDecimal> values) {
            addCriterion("money_reduce in", values, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceNotIn(List<BigDecimal> values) {
            addCriterion("money_reduce not in", values, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_reduce between", value1, value2, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyReduceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_reduce not between", value1, value2, "moneyReduce");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIsNull() {
            addCriterion("money_amount is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIsNotNull() {
            addCriterion("money_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountEqualTo(BigDecimal value) {
            addCriterion("money_amount =", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotEqualTo(BigDecimal value) {
            addCriterion("money_amount <>", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThan(BigDecimal value) {
            addCriterion("money_amount >", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money_amount >=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThan(BigDecimal value) {
            addCriterion("money_amount <", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money_amount <=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIn(List<BigDecimal> values) {
            addCriterion("money_amount in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotIn(List<BigDecimal> values) {
            addCriterion("money_amount not in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_amount between", value1, value2, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money_amount not between", value1, value2, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Float value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Float value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Float value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Float value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Float value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Float> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Float> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Float value1, Float value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Float value1, Float value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNull() {
            addCriterion("use_time is null");
            return (Criteria) this;
        }

        public Criteria andUseTimeIsNotNull() {
            addCriterion("use_time is not null");
            return (Criteria) this;
        }

        public Criteria andUseTimeEqualTo(Integer value) {
            addCriterion("use_time =", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotEqualTo(Integer value) {
            addCriterion("use_time <>", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThan(Integer value) {
            addCriterion("use_time >", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_time >=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThan(Integer value) {
            addCriterion("use_time <", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeLessThanOrEqualTo(Integer value) {
            addCriterion("use_time <=", value, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeIn(List<Integer> values) {
            addCriterion("use_time in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotIn(List<Integer> values) {
            addCriterion("use_time not in", values, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeBetween(Integer value1, Integer value2) {
            addCriterion("use_time between", value1, value2, "useTime");
            return (Criteria) this;
        }

        public Criteria andUseTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("use_time not between", value1, value2, "useTime");
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

        public Criteria andExpiresTimeIsNull() {
            addCriterion("expires_time is null");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeIsNotNull() {
            addCriterion("expires_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeEqualTo(Integer value) {
            addCriterion("expires_time =", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeNotEqualTo(Integer value) {
            addCriterion("expires_time <>", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeGreaterThan(Integer value) {
            addCriterion("expires_time >", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expires_time >=", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeLessThan(Integer value) {
            addCriterion("expires_time <", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expires_time <=", value, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeIn(List<Integer> values) {
            addCriterion("expires_time in", values, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeNotIn(List<Integer> values) {
            addCriterion("expires_time not in", values, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeBetween(Integer value1, Integer value2) {
            addCriterion("expires_time between", value1, value2, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andExpiresTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expires_time not between", value1, value2, "expiresTime");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(Byte value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(Byte value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(Byte value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(Byte value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(Byte value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<Byte> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<Byte> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(Byte value1, Byte value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andReduceMaxIsNull() {
            addCriterion("reduce_max is null");
            return (Criteria) this;
        }

        public Criteria andReduceMaxIsNotNull() {
            addCriterion("reduce_max is not null");
            return (Criteria) this;
        }

        public Criteria andReduceMaxEqualTo(BigDecimal value) {
            addCriterion("reduce_max =", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxNotEqualTo(BigDecimal value) {
            addCriterion("reduce_max <>", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxGreaterThan(BigDecimal value) {
            addCriterion("reduce_max >", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reduce_max >=", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxLessThan(BigDecimal value) {
            addCriterion("reduce_max <", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reduce_max <=", value, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxIn(List<BigDecimal> values) {
            addCriterion("reduce_max in", values, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxNotIn(List<BigDecimal> values) {
            addCriterion("reduce_max not in", values, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduce_max between", value1, value2, "reduceMax");
            return (Criteria) this;
        }

        public Criteria andReduceMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduce_max not between", value1, value2, "reduceMax");
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

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(Byte value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(Byte value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(Byte value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(Byte value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(Byte value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<Byte> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<Byte> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(Byte value1, Byte value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(Byte value1, Byte value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsServiceIsNull() {
            addCriterion("is_service is null");
            return (Criteria) this;
        }

        public Criteria andIsServiceIsNotNull() {
            addCriterion("is_service is not null");
            return (Criteria) this;
        }

        public Criteria andIsServiceEqualTo(Byte value) {
            addCriterion("is_service =", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceNotEqualTo(Byte value) {
            addCriterion("is_service <>", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceGreaterThan(Byte value) {
            addCriterion("is_service >", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_service >=", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceLessThan(Byte value) {
            addCriterion("is_service <", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceLessThanOrEqualTo(Byte value) {
            addCriterion("is_service <=", value, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceIn(List<Byte> values) {
            addCriterion("is_service in", values, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceNotIn(List<Byte> values) {
            addCriterion("is_service not in", values, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceBetween(Byte value1, Byte value2) {
            addCriterion("is_service between", value1, value2, "isService");
            return (Criteria) this;
        }

        public Criteria andIsServiceNotBetween(Byte value1, Byte value2) {
            addCriterion("is_service not between", value1, value2, "isService");
            return (Criteria) this;
        }

        public Criteria andIsMcardIsNull() {
            addCriterion("is_mcard is null");
            return (Criteria) this;
        }

        public Criteria andIsMcardIsNotNull() {
            addCriterion("is_mcard is not null");
            return (Criteria) this;
        }

        public Criteria andIsMcardEqualTo(Byte value) {
            addCriterion("is_mcard =", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardNotEqualTo(Byte value) {
            addCriterion("is_mcard <>", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardGreaterThan(Byte value) {
            addCriterion("is_mcard >", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_mcard >=", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardLessThan(Byte value) {
            addCriterion("is_mcard <", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardLessThanOrEqualTo(Byte value) {
            addCriterion("is_mcard <=", value, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardIn(List<Byte> values) {
            addCriterion("is_mcard in", values, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardNotIn(List<Byte> values) {
            addCriterion("is_mcard not in", values, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardBetween(Byte value1, Byte value2) {
            addCriterion("is_mcard between", value1, value2, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsMcardNotBetween(Byte value1, Byte value2) {
            addCriterion("is_mcard not between", value1, value2, "isMcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardIsNull() {
            addCriterion("is_vcard is null");
            return (Criteria) this;
        }

        public Criteria andIsVcardIsNotNull() {
            addCriterion("is_vcard is not null");
            return (Criteria) this;
        }

        public Criteria andIsVcardEqualTo(Byte value) {
            addCriterion("is_vcard =", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardNotEqualTo(Byte value) {
            addCriterion("is_vcard <>", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardGreaterThan(Byte value) {
            addCriterion("is_vcard >", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_vcard >=", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardLessThan(Byte value) {
            addCriterion("is_vcard <", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardLessThanOrEqualTo(Byte value) {
            addCriterion("is_vcard <=", value, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardIn(List<Byte> values) {
            addCriterion("is_vcard in", values, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardNotIn(List<Byte> values) {
            addCriterion("is_vcard not in", values, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardBetween(Byte value1, Byte value2) {
            addCriterion("is_vcard between", value1, value2, "isVcard");
            return (Criteria) this;
        }

        public Criteria andIsVcardNotBetween(Byte value1, Byte value2) {
            addCriterion("is_vcard not between", value1, value2, "isVcard");
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

        public Criteria andMcardIdIsNull() {
            addCriterion("mcard_id is null");
            return (Criteria) this;
        }

        public Criteria andMcardIdIsNotNull() {
            addCriterion("mcard_id is not null");
            return (Criteria) this;
        }

        public Criteria andMcardIdEqualTo(String value) {
            addCriterion("mcard_id =", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdNotEqualTo(String value) {
            addCriterion("mcard_id <>", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdGreaterThan(String value) {
            addCriterion("mcard_id >", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdGreaterThanOrEqualTo(String value) {
            addCriterion("mcard_id >=", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdLessThan(String value) {
            addCriterion("mcard_id <", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdLessThanOrEqualTo(String value) {
            addCriterion("mcard_id <=", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdLike(String value) {
            addCriterion("mcard_id like", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdNotLike(String value) {
            addCriterion("mcard_id not like", value, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdIn(List<String> values) {
            addCriterion("mcard_id in", values, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdNotIn(List<String> values) {
            addCriterion("mcard_id not in", values, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdBetween(String value1, String value2) {
            addCriterion("mcard_id between", value1, value2, "mcardId");
            return (Criteria) this;
        }

        public Criteria andMcardIdNotBetween(String value1, String value2) {
            addCriterion("mcard_id not between", value1, value2, "mcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdIsNull() {
            addCriterion("vcard_id is null");
            return (Criteria) this;
        }

        public Criteria andVcardIdIsNotNull() {
            addCriterion("vcard_id is not null");
            return (Criteria) this;
        }

        public Criteria andVcardIdEqualTo(String value) {
            addCriterion("vcard_id =", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdNotEqualTo(String value) {
            addCriterion("vcard_id <>", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdGreaterThan(String value) {
            addCriterion("vcard_id >", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdGreaterThanOrEqualTo(String value) {
            addCriterion("vcard_id >=", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdLessThan(String value) {
            addCriterion("vcard_id <", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdLessThanOrEqualTo(String value) {
            addCriterion("vcard_id <=", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdLike(String value) {
            addCriterion("vcard_id like", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdNotLike(String value) {
            addCriterion("vcard_id not like", value, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdIn(List<String> values) {
            addCriterion("vcard_id in", values, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdNotIn(List<String> values) {
            addCriterion("vcard_id not in", values, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdBetween(String value1, String value2) {
            addCriterion("vcard_id between", value1, value2, "vcardId");
            return (Criteria) this;
        }

        public Criteria andVcardIdNotBetween(String value1, String value2) {
            addCriterion("vcard_id not between", value1, value2, "vcardId");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andBeautyIdEqualTo(String value) {
            addCriterion("beauty_id =", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotEqualTo(String value) {
            addCriterion("beauty_id <>", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdGreaterThan(String value) {
            addCriterion("beauty_id >", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdGreaterThanOrEqualTo(String value) {
            addCriterion("beauty_id >=", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdLessThan(String value) {
            addCriterion("beauty_id <", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdLessThanOrEqualTo(String value) {
            addCriterion("beauty_id <=", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdLike(String value) {
            addCriterion("beauty_id like", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotLike(String value) {
            addCriterion("beauty_id not like", value, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdIn(List<String> values) {
            addCriterion("beauty_id in", values, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotIn(List<String> values) {
            addCriterion("beauty_id not in", values, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdBetween(String value1, String value2) {
            addCriterion("beauty_id between", value1, value2, "beautyId");
            return (Criteria) this;
        }

        public Criteria andBeautyIdNotBetween(String value1, String value2) {
            addCriterion("beauty_id not between", value1, value2, "beautyId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("`state` not between", value1, value2, "state");
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