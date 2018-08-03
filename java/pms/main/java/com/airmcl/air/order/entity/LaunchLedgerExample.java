package com.airmcl.air.order.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LaunchLedgerExample extends AbstractExample<LaunchLedger> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<LaunchLedger> pageView = new PageView<LaunchLedger>(1, 10);

    private static final long serialVersionUID = 1L;

    public LaunchLedgerExample() {
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
    public PageView<LaunchLedger> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<LaunchLedger> pageView) {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("orderId =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("orderId >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("orderId <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("orderId like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("orderId not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("orderId in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("orderNo is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("orderNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("orderNo =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("orderNo <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("orderNo >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("orderNo >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("orderNo <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("orderNo <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("orderNo like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("orderNo not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("orderNo in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("orderNo not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("orderNo between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("orderNo not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdIsNull() {
            addCriterion("userUcOpenId is null");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdIsNotNull() {
            addCriterion("userUcOpenId is not null");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdEqualTo(String value) {
            addCriterion("userUcOpenId =", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdNotEqualTo(String value) {
            addCriterion("userUcOpenId <>", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdGreaterThan(String value) {
            addCriterion("userUcOpenId >", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("userUcOpenId >=", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdLessThan(String value) {
            addCriterion("userUcOpenId <", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdLessThanOrEqualTo(String value) {
            addCriterion("userUcOpenId <=", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdLike(String value) {
            addCriterion("userUcOpenId like", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdNotLike(String value) {
            addCriterion("userUcOpenId not like", value, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdIn(List<String> values) {
            addCriterion("userUcOpenId in", values, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdNotIn(List<String> values) {
            addCriterion("userUcOpenId not in", values, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdBetween(String value1, String value2) {
            addCriterion("userUcOpenId between", value1, value2, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserUcOpenIdNotBetween(String value1, String value2) {
            addCriterion("userUcOpenId not between", value1, value2, "userUcOpenId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("userName =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("userName <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("userName >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("userName <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("userName like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("userName not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("userName in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("userName not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("userMobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("userMobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("userMobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("userMobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("userMobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("userMobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("userMobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("userMobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("userMobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("userMobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("userMobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("userMobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("userMobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("userMobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(String value) {
            addCriterion("storeId =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(String value) {
            addCriterion("storeId <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(String value) {
            addCriterion("storeId >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("storeId >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(String value) {
            addCriterion("storeId <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(String value) {
            addCriterion("storeId <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLike(String value) {
            addCriterion("storeId like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotLike(String value) {
            addCriterion("storeId not like", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<String> values) {
            addCriterion("storeId in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<String> values) {
            addCriterion("storeId not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(String value1, String value2) {
            addCriterion("storeId between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(String value1, String value2) {
            addCriterion("storeId not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("storeName is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("storeName =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("storeName <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("storeName >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("storeName >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("storeName <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("storeName <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("storeName like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("storeName not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("storeName in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("storeName not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("storeName between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("storeName not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoIsNull() {
            addCriterion("orderPayRequestNo is null");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoIsNotNull() {
            addCriterion("orderPayRequestNo is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoEqualTo(String value) {
            addCriterion("orderPayRequestNo =", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoNotEqualTo(String value) {
            addCriterion("orderPayRequestNo <>", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoGreaterThan(String value) {
            addCriterion("orderPayRequestNo >", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoGreaterThanOrEqualTo(String value) {
            addCriterion("orderPayRequestNo >=", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoLessThan(String value) {
            addCriterion("orderPayRequestNo <", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoLessThanOrEqualTo(String value) {
            addCriterion("orderPayRequestNo <=", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoLike(String value) {
            addCriterion("orderPayRequestNo like", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoNotLike(String value) {
            addCriterion("orderPayRequestNo not like", value, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoIn(List<String> values) {
            addCriterion("orderPayRequestNo in", values, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoNotIn(List<String> values) {
            addCriterion("orderPayRequestNo not in", values, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoBetween(String value1, String value2) {
            addCriterion("orderPayRequestNo between", value1, value2, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andOrderPayRequestNoNotBetween(String value1, String value2) {
            addCriterion("orderPayRequestNo not between", value1, value2, "orderPayRequestNo");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountIsNull() {
            addCriterion("ledgerAmount is null");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountIsNotNull() {
            addCriterion("ledgerAmount is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountEqualTo(String value) {
            addCriterion("ledgerAmount =", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountNotEqualTo(String value) {
            addCriterion("ledgerAmount <>", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountGreaterThan(String value) {
            addCriterion("ledgerAmount >", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountGreaterThanOrEqualTo(String value) {
            addCriterion("ledgerAmount >=", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountLessThan(String value) {
            addCriterion("ledgerAmount <", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountLessThanOrEqualTo(String value) {
            addCriterion("ledgerAmount <=", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountLike(String value) {
            addCriterion("ledgerAmount like", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountNotLike(String value) {
            addCriterion("ledgerAmount not like", value, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountIn(List<String> values) {
            addCriterion("ledgerAmount in", values, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountNotIn(List<String> values) {
            addCriterion("ledgerAmount not in", values, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountBetween(String value1, String value2) {
            addCriterion("ledgerAmount between", value1, value2, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerAmountNotBetween(String value1, String value2) {
            addCriterion("ledgerAmount not between", value1, value2, "ledgerAmount");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIsNull() {
            addCriterion("ledgerRuleId is null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIsNotNull() {
            addCriterion("ledgerRuleId is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdEqualTo(String value) {
            addCriterion("ledgerRuleId =", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotEqualTo(String value) {
            addCriterion("ledgerRuleId <>", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdGreaterThan(String value) {
            addCriterion("ledgerRuleId >", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ledgerRuleId >=", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLessThan(String value) {
            addCriterion("ledgerRuleId <", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLessThanOrEqualTo(String value) {
            addCriterion("ledgerRuleId <=", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdLike(String value) {
            addCriterion("ledgerRuleId like", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotLike(String value) {
            addCriterion("ledgerRuleId not like", value, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdIn(List<String> values) {
            addCriterion("ledgerRuleId in", values, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotIn(List<String> values) {
            addCriterion("ledgerRuleId not in", values, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdBetween(String value1, String value2) {
            addCriterion("ledgerRuleId between", value1, value2, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleIdNotBetween(String value1, String value2) {
            addCriterion("ledgerRuleId not between", value1, value2, "ledgerRuleId");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIsNull() {
            addCriterion("ledgerRuleName is null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIsNotNull() {
            addCriterion("ledgerRuleName is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameEqualTo(String value) {
            addCriterion("ledgerRuleName =", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotEqualTo(String value) {
            addCriterion("ledgerRuleName <>", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameGreaterThan(String value) {
            addCriterion("ledgerRuleName >", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ledgerRuleName >=", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLessThan(String value) {
            addCriterion("ledgerRuleName <", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLessThanOrEqualTo(String value) {
            addCriterion("ledgerRuleName <=", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameLike(String value) {
            addCriterion("ledgerRuleName like", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotLike(String value) {
            addCriterion("ledgerRuleName not like", value, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameIn(List<String> values) {
            addCriterion("ledgerRuleName in", values, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotIn(List<String> values) {
            addCriterion("ledgerRuleName not in", values, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameBetween(String value1, String value2) {
            addCriterion("ledgerRuleName between", value1, value2, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andLedgerRuleNameNotBetween(String value1, String value2) {
            addCriterion("ledgerRuleName not between", value1, value2, "ledgerRuleName");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("productId is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("productId is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("productId =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("productId <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("productId >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("productId >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("productId <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("productId <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("productId like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("productId not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("productId in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("productId not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("productId between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("productId not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("productName is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("productName is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("productName =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("productName <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("productName >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("productName >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("productName <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("productName <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("productName like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("productName not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("productName in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("productName not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("productName between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("productName not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIsNull() {
            addCriterion("ledgerCycle is null");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIsNotNull() {
            addCriterion("ledgerCycle is not null");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleEqualTo(Integer value) {
            addCriterion("ledgerCycle =", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotEqualTo(Integer value) {
            addCriterion("ledgerCycle <>", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleGreaterThan(Integer value) {
            addCriterion("ledgerCycle >", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("ledgerCycle >=", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleLessThan(Integer value) {
            addCriterion("ledgerCycle <", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleLessThanOrEqualTo(Integer value) {
            addCriterion("ledgerCycle <=", value, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleIn(List<Integer> values) {
            addCriterion("ledgerCycle in", values, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotIn(List<Integer> values) {
            addCriterion("ledgerCycle not in", values, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleBetween(Integer value1, Integer value2) {
            addCriterion("ledgerCycle between", value1, value2, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andLedgerCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("ledgerCycle not between", value1, value2, "ledgerCycle");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIsNull() {
            addCriterion("applicationNo is null");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIsNotNull() {
            addCriterion("applicationNo is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationNoEqualTo(String value) {
            addCriterion("applicationNo =", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotEqualTo(String value) {
            addCriterion("applicationNo <>", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoGreaterThan(String value) {
            addCriterion("applicationNo >", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoGreaterThanOrEqualTo(String value) {
            addCriterion("applicationNo >=", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLessThan(String value) {
            addCriterion("applicationNo <", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLessThanOrEqualTo(String value) {
            addCriterion("applicationNo <=", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoLike(String value) {
            addCriterion("applicationNo like", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotLike(String value) {
            addCriterion("applicationNo not like", value, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoIn(List<String> values) {
            addCriterion("applicationNo in", values, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotIn(List<String> values) {
            addCriterion("applicationNo not in", values, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoBetween(String value1, String value2) {
            addCriterion("applicationNo between", value1, value2, "applicationNo");
            return (Criteria) this;
        }

        public Criteria andApplicationNoNotBetween(String value1, String value2) {
            addCriterion("applicationNo not between", value1, value2, "applicationNo");
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