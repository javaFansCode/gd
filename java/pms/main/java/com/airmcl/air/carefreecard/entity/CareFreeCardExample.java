package com.airmcl.air.carefreecard.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CareFreeCardExample extends AbstractExample<CareFreeCard> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<CareFreeCard> pageView = new PageView<CareFreeCard>(1, 10);

    private static final long serialVersionUID = 1L;

    public CareFreeCardExample() {
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
    public PageView<CareFreeCard> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<CareFreeCard> pageView) {
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

        public Criteria andCard_numberIsNull() {
            addCriterion("card_number is null");
            return (Criteria) this;
        }

        public Criteria andCard_numberIsNotNull() {
            addCriterion("card_number is not null");
            return (Criteria) this;
        }

        public Criteria andCard_numberEqualTo(String value) {
            addCriterion("card_number =", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberNotEqualTo(String value) {
            addCriterion("card_number <>", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberGreaterThan(String value) {
            addCriterion("card_number >", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberGreaterThanOrEqualTo(String value) {
            addCriterion("card_number >=", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberLessThan(String value) {
            addCriterion("card_number <", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberLessThanOrEqualTo(String value) {
            addCriterion("card_number <=", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberLike(String value) {
            addCriterion("card_number like", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberNotLike(String value) {
            addCriterion("card_number not like", value, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberIn(List<String> values) {
            addCriterion("card_number in", values, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberNotIn(List<String> values) {
            addCriterion("card_number not in", values, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberBetween(String value1, String value2) {
            addCriterion("card_number between", value1, value2, "card_number");
            return (Criteria) this;
        }

        public Criteria andCard_numberNotBetween(String value1, String value2) {
            addCriterion("card_number not between", value1, value2, "card_number");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idIsNull() {
            addCriterion("goods_card_id is null");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idIsNotNull() {
            addCriterion("goods_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idEqualTo(String value) {
            addCriterion("goods_card_id =", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idNotEqualTo(String value) {
            addCriterion("goods_card_id <>", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idGreaterThan(String value) {
            addCriterion("goods_card_id >", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idGreaterThanOrEqualTo(String value) {
            addCriterion("goods_card_id >=", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idLessThan(String value) {
            addCriterion("goods_card_id <", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idLessThanOrEqualTo(String value) {
            addCriterion("goods_card_id <=", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idLike(String value) {
            addCriterion("goods_card_id like", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idNotLike(String value) {
            addCriterion("goods_card_id not like", value, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idIn(List<String> values) {
            addCriterion("goods_card_id in", values, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idNotIn(List<String> values) {
            addCriterion("goods_card_id not in", values, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idBetween(String value1, String value2) {
            addCriterion("goods_card_id between", value1, value2, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_idNotBetween(String value1, String value2) {
            addCriterion("goods_card_id not between", value1, value2, "goods_card_id");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameIsNull() {
            addCriterion("goods_card_name is null");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameIsNotNull() {
            addCriterion("goods_card_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameEqualTo(String value) {
            addCriterion("goods_card_name =", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameNotEqualTo(String value) {
            addCriterion("goods_card_name <>", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameGreaterThan(String value) {
            addCriterion("goods_card_name >", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_card_name >=", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameLessThan(String value) {
            addCriterion("goods_card_name <", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameLessThanOrEqualTo(String value) {
            addCriterion("goods_card_name <=", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameLike(String value) {
            addCriterion("goods_card_name like", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameNotLike(String value) {
            addCriterion("goods_card_name not like", value, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameIn(List<String> values) {
            addCriterion("goods_card_name in", values, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameNotIn(List<String> values) {
            addCriterion("goods_card_name not in", values, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameBetween(String value1, String value2) {
            addCriterion("goods_card_name between", value1, value2, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andGoods_card_nameNotBetween(String value1, String value2) {
            addCriterion("goods_card_name not between", value1, value2, "goods_card_name");
            return (Criteria) this;
        }

        public Criteria andSecret_keyIsNull() {
            addCriterion("secret_key is null");
            return (Criteria) this;
        }

        public Criteria andSecret_keyIsNotNull() {
            addCriterion("secret_key is not null");
            return (Criteria) this;
        }

        public Criteria andSecret_keyEqualTo(String value) {
            addCriterion("secret_key =", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyNotEqualTo(String value) {
            addCriterion("secret_key <>", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyGreaterThan(String value) {
            addCriterion("secret_key >", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyGreaterThanOrEqualTo(String value) {
            addCriterion("secret_key >=", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyLessThan(String value) {
            addCriterion("secret_key <", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyLessThanOrEqualTo(String value) {
            addCriterion("secret_key <=", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyLike(String value) {
            addCriterion("secret_key like", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyNotLike(String value) {
            addCriterion("secret_key not like", value, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyIn(List<String> values) {
            addCriterion("secret_key in", values, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyNotIn(List<String> values) {
            addCriterion("secret_key not in", values, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyBetween(String value1, String value2) {
            addCriterion("secret_key between", value1, value2, "secret_key");
            return (Criteria) this;
        }

        public Criteria andSecret_keyNotBetween(String value1, String value2) {
            addCriterion("secret_key not between", value1, value2, "secret_key");
            return (Criteria) this;
        }

        public Criteria andAction_flagIsNull() {
            addCriterion("action_flag is null");
            return (Criteria) this;
        }

        public Criteria andAction_flagIsNotNull() {
            addCriterion("action_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAction_flagEqualTo(Byte value) {
            addCriterion("action_flag =", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagNotEqualTo(Byte value) {
            addCriterion("action_flag <>", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagGreaterThan(Byte value) {
            addCriterion("action_flag >", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagGreaterThanOrEqualTo(Byte value) {
            addCriterion("action_flag >=", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagLessThan(Byte value) {
            addCriterion("action_flag <", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagLessThanOrEqualTo(Byte value) {
            addCriterion("action_flag <=", value, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagIn(List<Byte> values) {
            addCriterion("action_flag in", values, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagNotIn(List<Byte> values) {
            addCriterion("action_flag not in", values, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagBetween(Byte value1, Byte value2) {
            addCriterion("action_flag between", value1, value2, "action_flag");
            return (Criteria) this;
        }

        public Criteria andAction_flagNotBetween(Byte value1, Byte value2) {
            addCriterion("action_flag not between", value1, value2, "action_flag");
            return (Criteria) this;
        }

        public Criteria andStore_nameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStore_nameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStore_nameEqualTo(String value) {
            addCriterion("store_name =", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameGreaterThan(String value) {
            addCriterion("store_name >", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLessThan(String value) {
            addCriterion("store_name <", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameLike(String value) {
            addCriterion("store_name like", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotLike(String value) {
            addCriterion("store_name not like", value, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameIn(List<String> values) {
            addCriterion("store_name in", values, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_nameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "store_name");
            return (Criteria) this;
        }

        public Criteria andStore_idIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStore_idIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStore_idEqualTo(String value) {
            addCriterion("store_id =", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotEqualTo(String value) {
            addCriterion("store_id <>", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThan(String value) {
            addCriterion("store_id >", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idGreaterThanOrEqualTo(String value) {
            addCriterion("store_id >=", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThan(String value) {
            addCriterion("store_id <", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idLessThanOrEqualTo(String value) {
            addCriterion("store_id <=", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idLike(String value) {
            addCriterion("store_id like", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotLike(String value) {
            addCriterion("store_id not like", value, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idIn(List<String> values) {
            addCriterion("store_id in", values, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotIn(List<String> values) {
            addCriterion("store_id not in", values, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idBetween(String value1, String value2) {
            addCriterion("store_id between", value1, value2, "store_id");
            return (Criteria) this;
        }

        public Criteria andStore_idNotBetween(String value1, String value2) {
            addCriterion("store_id not between", value1, value2, "store_id");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameEqualTo(String value) {
            addCriterion("customer_name =", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLessThan(String value) {
            addCriterion("customer_name <", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLike(String value) {
            addCriterion("customer_name like", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotLike(String value) {
            addCriterion("customer_name not like", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIn(List<String> values) {
            addCriterion("customer_name in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneIsNull() {
            addCriterion("customer_mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneIsNotNull() {
            addCriterion("customer_mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneEqualTo(String value) {
            addCriterion("customer_mobile_phone =", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneNotEqualTo(String value) {
            addCriterion("customer_mobile_phone <>", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneGreaterThan(String value) {
            addCriterion("customer_mobile_phone >", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("customer_mobile_phone >=", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneLessThan(String value) {
            addCriterion("customer_mobile_phone <", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneLessThanOrEqualTo(String value) {
            addCriterion("customer_mobile_phone <=", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneLike(String value) {
            addCriterion("customer_mobile_phone like", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneNotLike(String value) {
            addCriterion("customer_mobile_phone not like", value, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneIn(List<String> values) {
            addCriterion("customer_mobile_phone in", values, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneNotIn(List<String> values) {
            addCriterion("customer_mobile_phone not in", values, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneBetween(String value1, String value2) {
            addCriterion("customer_mobile_phone between", value1, value2, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andCustomer_mobile_phoneNotBetween(String value1, String value2) {
            addCriterion("customer_mobile_phone not between", value1, value2, "customer_mobile_phone");
            return (Criteria) this;
        }

        public Criteria andActivation_timeIsNull() {
            addCriterion("activation_time is null");
            return (Criteria) this;
        }

        public Criteria andActivation_timeIsNotNull() {
            addCriterion("activation_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivation_timeEqualTo(Date value) {
            addCriterion("activation_time =", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeNotEqualTo(Date value) {
            addCriterion("activation_time <>", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeGreaterThan(Date value) {
            addCriterion("activation_time >", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("activation_time >=", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeLessThan(Date value) {
            addCriterion("activation_time <", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeLessThanOrEqualTo(Date value) {
            addCriterion("activation_time <=", value, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeIn(List<Date> values) {
            addCriterion("activation_time in", values, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeNotIn(List<Date> values) {
            addCriterion("activation_time not in", values, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeBetween(Date value1, Date value2) {
            addCriterion("activation_time between", value1, value2, "activation_time");
            return (Criteria) this;
        }

        public Criteria andActivation_timeNotBetween(Date value1, Date value2) {
            addCriterion("activation_time not between", value1, value2, "activation_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIs_deleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "is_delete");
            return (Criteria) this;
        }

        public Criteria andIs_deleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "is_delete");
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