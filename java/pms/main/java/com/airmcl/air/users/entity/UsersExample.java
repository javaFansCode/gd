package com.airmcl.air.users.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UsersExample extends AbstractExample<Users> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Users> pageView = new PageView<Users>(1, 10);

    private static final long serialVersionUID = 1L;

    public UsersExample() {
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
    public PageView<Users> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Users> pageView) {
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

        public Criteria andVipcardNameIsNull() {
            addCriterion("vipcard_name is null");
            return (Criteria) this;
        }

        public Criteria andVipcardNameIsNotNull() {
            addCriterion("vipcard_name is not null");
            return (Criteria) this;
        }

        public Criteria andVipcardNameEqualTo(String value) {
            addCriterion("vipcard_name =", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameNotEqualTo(String value) {
            addCriterion("vipcard_name <>", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameGreaterThan(String value) {
            addCriterion("vipcard_name >", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameGreaterThanOrEqualTo(String value) {
            addCriterion("vipcard_name >=", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameLessThan(String value) {
            addCriterion("vipcard_name <", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameLessThanOrEqualTo(String value) {
            addCriterion("vipcard_name <=", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameLike(String value) {
            addCriterion("vipcard_name like", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameNotLike(String value) {
            addCriterion("vipcard_name not like", value, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameIn(List<String> values) {
            addCriterion("vipcard_name in", values, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameNotIn(List<String> values) {
            addCriterion("vipcard_name not in", values, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameBetween(String value1, String value2) {
            addCriterion("vipcard_name between", value1, value2, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipcardNameNotBetween(String value1, String value2) {
            addCriterion("vipcard_name not between", value1, value2, "vipcardName");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeIsNull() {
            addCriterion("vip_start_time is null");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeIsNotNull() {
            addCriterion("vip_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeEqualTo(Integer value) {
            addCriterion("vip_start_time =", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeNotEqualTo(Integer value) {
            addCriterion("vip_start_time <>", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeGreaterThan(Integer value) {
            addCriterion("vip_start_time >", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_start_time >=", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeLessThan(Integer value) {
            addCriterion("vip_start_time <", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeLessThanOrEqualTo(Integer value) {
            addCriterion("vip_start_time <=", value, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeIn(List<Integer> values) {
            addCriterion("vip_start_time in", values, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeNotIn(List<Integer> values) {
            addCriterion("vip_start_time not in", values, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeBetween(Integer value1, Integer value2) {
            addCriterion("vip_start_time between", value1, value2, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipStartTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_start_time not between", value1, value2, "vipStartTime");
            return (Criteria) this;
        }

        public Criteria andVipExpireIsNull() {
            addCriterion("vip_expire is null");
            return (Criteria) this;
        }

        public Criteria andVipExpireIsNotNull() {
            addCriterion("vip_expire is not null");
            return (Criteria) this;
        }

        public Criteria andVipExpireEqualTo(Integer value) {
            addCriterion("vip_expire =", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireNotEqualTo(Integer value) {
            addCriterion("vip_expire <>", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireGreaterThan(Integer value) {
            addCriterion("vip_expire >", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_expire >=", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireLessThan(Integer value) {
            addCriterion("vip_expire <", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireLessThanOrEqualTo(Integer value) {
            addCriterion("vip_expire <=", value, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireIn(List<Integer> values) {
            addCriterion("vip_expire in", values, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireNotIn(List<Integer> values) {
            addCriterion("vip_expire not in", values, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireBetween(Integer value1, Integer value2) {
            addCriterion("vip_expire between", value1, value2, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipExpireNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_expire not between", value1, value2, "vipExpire");
            return (Criteria) this;
        }

        public Criteria andVipDayIsNull() {
            addCriterion("vip_day is null");
            return (Criteria) this;
        }

        public Criteria andVipDayIsNotNull() {
            addCriterion("vip_day is not null");
            return (Criteria) this;
        }

        public Criteria andVipDayEqualTo(Integer value) {
            addCriterion("vip_day =", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayNotEqualTo(Integer value) {
            addCriterion("vip_day <>", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayGreaterThan(Integer value) {
            addCriterion("vip_day >", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("vip_day >=", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayLessThan(Integer value) {
            addCriterion("vip_day <", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayLessThanOrEqualTo(Integer value) {
            addCriterion("vip_day <=", value, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayIn(List<Integer> values) {
            addCriterion("vip_day in", values, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayNotIn(List<Integer> values) {
            addCriterion("vip_day not in", values, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayBetween(Integer value1, Integer value2) {
            addCriterion("vip_day between", value1, value2, "vipDay");
            return (Criteria) this;
        }

        public Criteria andVipDayNotBetween(Integer value1, Integer value2) {
            addCriterion("vip_day not between", value1, value2, "vipDay");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalIsNull() {
            addCriterion("mdcard_total is null");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalIsNotNull() {
            addCriterion("mdcard_total is not null");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalEqualTo(Integer value) {
            addCriterion("mdcard_total =", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalNotEqualTo(Integer value) {
            addCriterion("mdcard_total <>", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalGreaterThan(Integer value) {
            addCriterion("mdcard_total >", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("mdcard_total >=", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalLessThan(Integer value) {
            addCriterion("mdcard_total <", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalLessThanOrEqualTo(Integer value) {
            addCriterion("mdcard_total <=", value, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalIn(List<Integer> values) {
            addCriterion("mdcard_total in", values, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalNotIn(List<Integer> values) {
            addCriterion("mdcard_total not in", values, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalBetween(Integer value1, Integer value2) {
            addCriterion("mdcard_total between", value1, value2, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andMdcardTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("mdcard_total not between", value1, value2, "mdcardTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalIsNull() {
            addCriterion("service_total is null");
            return (Criteria) this;
        }

        public Criteria andServiceTotalIsNotNull() {
            addCriterion("service_total is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTotalEqualTo(Integer value) {
            addCriterion("service_total =", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotEqualTo(Integer value) {
            addCriterion("service_total <>", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalGreaterThan(Integer value) {
            addCriterion("service_total >", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_total >=", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalLessThan(Integer value) {
            addCriterion("service_total <", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalLessThanOrEqualTo(Integer value) {
            addCriterion("service_total <=", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalIn(List<Integer> values) {
            addCriterion("service_total in", values, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotIn(List<Integer> values) {
            addCriterion("service_total not in", values, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalBetween(Integer value1, Integer value2) {
            addCriterion("service_total between", value1, value2, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("service_total not between", value1, value2, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalIsNull() {
            addCriterion("package_total is null");
            return (Criteria) this;
        }

        public Criteria andPackageTotalIsNotNull() {
            addCriterion("package_total is not null");
            return (Criteria) this;
        }

        public Criteria andPackageTotalEqualTo(Integer value) {
            addCriterion("package_total =", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalNotEqualTo(Integer value) {
            addCriterion("package_total <>", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalGreaterThan(Integer value) {
            addCriterion("package_total >", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_total >=", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalLessThan(Integer value) {
            addCriterion("package_total <", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalLessThanOrEqualTo(Integer value) {
            addCriterion("package_total <=", value, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalIn(List<Integer> values) {
            addCriterion("package_total in", values, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalNotIn(List<Integer> values) {
            addCriterion("package_total not in", values, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalBetween(Integer value1, Integer value2) {
            addCriterion("package_total between", value1, value2, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andPackageTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("package_total not between", value1, value2, "packageTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIsNull() {
            addCriterion("coupon_total is null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIsNotNull() {
            addCriterion("coupon_total is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTotalEqualTo(Integer value) {
            addCriterion("coupon_total =", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotEqualTo(Integer value) {
            addCriterion("coupon_total <>", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalGreaterThan(Integer value) {
            addCriterion("coupon_total >", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupon_total >=", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalLessThan(Integer value) {
            addCriterion("coupon_total <", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalLessThanOrEqualTo(Integer value) {
            addCriterion("coupon_total <=", value, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalIn(List<Integer> values) {
            addCriterion("coupon_total in", values, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotIn(List<Integer> values) {
            addCriterion("coupon_total not in", values, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total between", value1, value2, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andCouponTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("coupon_total not between", value1, value2, "couponTotal");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIsNull() {
            addCriterion("use_money is null");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIsNotNull() {
            addCriterion("use_money is not null");
            return (Criteria) this;
        }

        public Criteria andUseMoneyEqualTo(BigDecimal value) {
            addCriterion("use_money =", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotEqualTo(BigDecimal value) {
            addCriterion("use_money <>", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyGreaterThan(BigDecimal value) {
            addCriterion("use_money >", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("use_money >=", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyLessThan(BigDecimal value) {
            addCriterion("use_money <", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("use_money <=", value, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyIn(List<BigDecimal> values) {
            addCriterion("use_money in", values, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotIn(List<BigDecimal> values) {
            addCriterion("use_money not in", values, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_money between", value1, value2, "useMoney");
            return (Criteria) this;
        }

        public Criteria andUseMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("use_money not between", value1, value2, "useMoney");
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

        public Criteria andVipNumberIsNull() {
            addCriterion("vip_number is null");
            return (Criteria) this;
        }

        public Criteria andVipNumberIsNotNull() {
            addCriterion("vip_number is not null");
            return (Criteria) this;
        }

        public Criteria andVipNumberEqualTo(String value) {
            addCriterion("vip_number =", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotEqualTo(String value) {
            addCriterion("vip_number <>", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberGreaterThan(String value) {
            addCriterion("vip_number >", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberGreaterThanOrEqualTo(String value) {
            addCriterion("vip_number >=", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberLessThan(String value) {
            addCriterion("vip_number <", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberLessThanOrEqualTo(String value) {
            addCriterion("vip_number <=", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberLike(String value) {
            addCriterion("vip_number like", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotLike(String value) {
            addCriterion("vip_number not like", value, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberIn(List<String> values) {
            addCriterion("vip_number in", values, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotIn(List<String> values) {
            addCriterion("vip_number not in", values, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberBetween(String value1, String value2) {
            addCriterion("vip_number between", value1, value2, "vipNumber");
            return (Criteria) this;
        }

        public Criteria andVipNumberNotBetween(String value1, String value2) {
            addCriterion("vip_number not between", value1, value2, "vipNumber");
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

        public Criteria andRefereeMobileEqualTo(String value) {
            addCriterion("referee_mobile =", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotEqualTo(String value) {
            addCriterion("referee_mobile <>", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileGreaterThan(String value) {
            addCriterion("referee_mobile >", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileGreaterThanOrEqualTo(String value) {
            addCriterion("referee_mobile >=", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileLessThan(String value) {
            addCriterion("referee_mobile <", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileLessThanOrEqualTo(String value) {
            addCriterion("referee_mobile <=", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileLike(String value) {
            addCriterion("referee_mobile like", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotLike(String value) {
            addCriterion("referee_mobile not like", value, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileIn(List<String> values) {
            addCriterion("referee_mobile in", values, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotIn(List<String> values) {
            addCriterion("referee_mobile not in", values, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileBetween(String value1, String value2) {
            addCriterion("referee_mobile between", value1, value2, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeMobileNotBetween(String value1, String value2) {
            addCriterion("referee_mobile not between", value1, value2, "refereeMobile");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIsNull() {
            addCriterion("referee_id is null");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIsNotNull() {
            addCriterion("referee_id is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeIdEqualTo(String value) {
            addCriterion("referee_id =", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotEqualTo(String value) {
            addCriterion("referee_id <>", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdGreaterThan(String value) {
            addCriterion("referee_id >", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdGreaterThanOrEqualTo(String value) {
            addCriterion("referee_id >=", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLessThan(String value) {
            addCriterion("referee_id <", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLessThanOrEqualTo(String value) {
            addCriterion("referee_id <=", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdLike(String value) {
            addCriterion("referee_id like", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotLike(String value) {
            addCriterion("referee_id not like", value, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdIn(List<String> values) {
            addCriterion("referee_id in", values, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotIn(List<String> values) {
            addCriterion("referee_id not in", values, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdBetween(String value1, String value2) {
            addCriterion("referee_id between", value1, value2, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeIdNotBetween(String value1, String value2) {
            addCriterion("referee_id not between", value1, value2, "refereeId");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIsNull() {
            addCriterion("referee_name is null");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIsNotNull() {
            addCriterion("referee_name is not null");
            return (Criteria) this;
        }

        public Criteria andRefereeNameEqualTo(String value) {
            addCriterion("referee_name =", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotEqualTo(String value) {
            addCriterion("referee_name <>", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameGreaterThan(String value) {
            addCriterion("referee_name >", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameGreaterThanOrEqualTo(String value) {
            addCriterion("referee_name >=", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLessThan(String value) {
            addCriterion("referee_name <", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLessThanOrEqualTo(String value) {
            addCriterion("referee_name <=", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameLike(String value) {
            addCriterion("referee_name like", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotLike(String value) {
            addCriterion("referee_name not like", value, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameIn(List<String> values) {
            addCriterion("referee_name in", values, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotIn(List<String> values) {
            addCriterion("referee_name not in", values, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameBetween(String value1, String value2) {
            addCriterion("referee_name between", value1, value2, "refereeName");
            return (Criteria) this;
        }

        public Criteria andRefereeNameNotBetween(String value1, String value2) {
            addCriterion("referee_name not between", value1, value2, "refereeName");
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