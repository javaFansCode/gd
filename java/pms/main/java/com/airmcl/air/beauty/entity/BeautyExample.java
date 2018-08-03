package com.airmcl.air.beauty.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeautyExample extends AbstractExample<Beauty> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Beauty> pageView = new PageView<Beauty>(1, 10);

    private static final long serialVersionUID = 1L;

    public BeautyExample() {
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
    public PageView<Beauty> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Beauty> pageView) {
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

        public Criteria andBeautyCoverIsNull() {
            addCriterion("beauty_cover is null");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverIsNotNull() {
            addCriterion("beauty_cover is not null");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverEqualTo(String value) {
            addCriterion("beauty_cover =", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverNotEqualTo(String value) {
            addCriterion("beauty_cover <>", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverGreaterThan(String value) {
            addCriterion("beauty_cover >", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverGreaterThanOrEqualTo(String value) {
            addCriterion("beauty_cover >=", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverLessThan(String value) {
            addCriterion("beauty_cover <", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverLessThanOrEqualTo(String value) {
            addCriterion("beauty_cover <=", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverLike(String value) {
            addCriterion("beauty_cover like", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverNotLike(String value) {
            addCriterion("beauty_cover not like", value, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverIn(List<String> values) {
            addCriterion("beauty_cover in", values, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverNotIn(List<String> values) {
            addCriterion("beauty_cover not in", values, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverBetween(String value1, String value2) {
            addCriterion("beauty_cover between", value1, value2, "beautyCover");
            return (Criteria) this;
        }

        public Criteria andBeautyCoverNotBetween(String value1, String value2) {
            addCriterion("beauty_cover not between", value1, value2, "beautyCover");
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

        public Criteria andBeautyNamePhoneticIsNull() {
            addCriterion("beauty_name_phonetic is null");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticIsNotNull() {
            addCriterion("beauty_name_phonetic is not null");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticEqualTo(String value) {
            addCriterion("beauty_name_phonetic =", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticNotEqualTo(String value) {
            addCriterion("beauty_name_phonetic <>", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticGreaterThan(String value) {
            addCriterion("beauty_name_phonetic >", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticGreaterThanOrEqualTo(String value) {
            addCriterion("beauty_name_phonetic >=", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticLessThan(String value) {
            addCriterion("beauty_name_phonetic <", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticLessThanOrEqualTo(String value) {
            addCriterion("beauty_name_phonetic <=", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticLike(String value) {
            addCriterion("beauty_name_phonetic like", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticNotLike(String value) {
            addCriterion("beauty_name_phonetic not like", value, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticIn(List<String> values) {
            addCriterion("beauty_name_phonetic in", values, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticNotIn(List<String> values) {
            addCriterion("beauty_name_phonetic not in", values, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticBetween(String value1, String value2) {
            addCriterion("beauty_name_phonetic between", value1, value2, "beautyNamePhonetic");
            return (Criteria) this;
        }

        public Criteria andBeautyNamePhoneticNotBetween(String value1, String value2) {
            addCriterion("beauty_name_phonetic not between", value1, value2, "beautyNamePhonetic");
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

        public Criteria andIndustryTypeIsNull() {
            addCriterion("industry_type is null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIsNotNull() {
            addCriterion("industry_type is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeEqualTo(Byte value) {
            addCriterion("industry_type =", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotEqualTo(Byte value) {
            addCriterion("industry_type <>", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThan(Byte value) {
            addCriterion("industry_type >", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("industry_type >=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThan(Byte value) {
            addCriterion("industry_type <", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeLessThanOrEqualTo(Byte value) {
            addCriterion("industry_type <=", value, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeIn(List<Byte> values) {
            addCriterion("industry_type in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotIn(List<Byte> values) {
            addCriterion("industry_type not in", values, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeBetween(Byte value1, Byte value2) {
            addCriterion("industry_type between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andIndustryTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("industry_type not between", value1, value2, "industryType");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
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

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(Integer value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(Integer value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(Integer value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(Integer value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(Integer value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(Integer value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<Integer> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<Integer> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(Integer value1, Integer value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(Integer value1, Integer value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andStreetIsNull() {
            addCriterion("street is null");
            return (Criteria) this;
        }

        public Criteria andStreetIsNotNull() {
            addCriterion("street is not null");
            return (Criteria) this;
        }

        public Criteria andStreetEqualTo(Integer value) {
            addCriterion("street =", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotEqualTo(Integer value) {
            addCriterion("street <>", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThan(Integer value) {
            addCriterion("street >", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetGreaterThanOrEqualTo(Integer value) {
            addCriterion("street >=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThan(Integer value) {
            addCriterion("street <", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetLessThanOrEqualTo(Integer value) {
            addCriterion("street <=", value, "street");
            return (Criteria) this;
        }

        public Criteria andStreetIn(List<Integer> values) {
            addCriterion("street in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotIn(List<Integer> values) {
            addCriterion("street not in", values, "street");
            return (Criteria) this;
        }

        public Criteria andStreetBetween(Integer value1, Integer value2) {
            addCriterion("street between", value1, value2, "street");
            return (Criteria) this;
        }

        public Criteria andStreetNotBetween(Integer value1, Integer value2) {
            addCriterion("street not between", value1, value2, "street");
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

        public Criteria andProfessionalScoreIsNull() {
            addCriterion("professional_score is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreIsNotNull() {
            addCriterion("professional_score is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreEqualTo(Integer value) {
            addCriterion("professional_score =", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreNotEqualTo(Integer value) {
            addCriterion("professional_score <>", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreGreaterThan(Integer value) {
            addCriterion("professional_score >", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("professional_score >=", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreLessThan(Integer value) {
            addCriterion("professional_score <", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("professional_score <=", value, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreIn(List<Integer> values) {
            addCriterion("professional_score in", values, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreNotIn(List<Integer> values) {
            addCriterion("professional_score not in", values, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreBetween(Integer value1, Integer value2) {
            addCriterion("professional_score between", value1, value2, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andProfessionalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("professional_score not between", value1, value2, "professionalScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreIsNull() {
            addCriterion("punctuality_score is null");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreIsNotNull() {
            addCriterion("punctuality_score is not null");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreEqualTo(Integer value) {
            addCriterion("punctuality_score =", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreNotEqualTo(Integer value) {
            addCriterion("punctuality_score <>", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreGreaterThan(Integer value) {
            addCriterion("punctuality_score >", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("punctuality_score >=", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreLessThan(Integer value) {
            addCriterion("punctuality_score <", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreLessThanOrEqualTo(Integer value) {
            addCriterion("punctuality_score <=", value, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreIn(List<Integer> values) {
            addCriterion("punctuality_score in", values, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreNotIn(List<Integer> values) {
            addCriterion("punctuality_score not in", values, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreBetween(Integer value1, Integer value2) {
            addCriterion("punctuality_score between", value1, value2, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andPunctualityScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("punctuality_score not between", value1, value2, "punctualityScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreIsNull() {
            addCriterion("communicate_score is null");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreIsNotNull() {
            addCriterion("communicate_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreEqualTo(Integer value) {
            addCriterion("communicate_score =", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreNotEqualTo(Integer value) {
            addCriterion("communicate_score <>", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreGreaterThan(Integer value) {
            addCriterion("communicate_score >", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("communicate_score >=", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreLessThan(Integer value) {
            addCriterion("communicate_score <", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreLessThanOrEqualTo(Integer value) {
            addCriterion("communicate_score <=", value, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreIn(List<Integer> values) {
            addCriterion("communicate_score in", values, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreNotIn(List<Integer> values) {
            addCriterion("communicate_score not in", values, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreBetween(Integer value1, Integer value2) {
            addCriterion("communicate_score between", value1, value2, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andCommunicateScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("communicate_score not between", value1, value2, "communicateScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIsNull() {
            addCriterion("store_score is null");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIsNotNull() {
            addCriterion("store_score is not null");
            return (Criteria) this;
        }

        public Criteria andStoreScoreEqualTo(Short value) {
            addCriterion("store_score =", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotEqualTo(Short value) {
            addCriterion("store_score <>", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThan(Short value) {
            addCriterion("store_score >", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThanOrEqualTo(Short value) {
            addCriterion("store_score >=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThan(Short value) {
            addCriterion("store_score <", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThanOrEqualTo(Short value) {
            addCriterion("store_score <=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIn(List<Short> values) {
            addCriterion("store_score in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotIn(List<Short> values) {
            addCriterion("store_score not in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreBetween(Short value1, Short value2) {
            addCriterion("store_score between", value1, value2, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotBetween(Short value1, Short value2) {
            addCriterion("store_score not between", value1, value2, "storeScore");
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

        public Criteria andServiceTimeEqualTo(String value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(String value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(String value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(String value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(String value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(String value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLike(String value) {
            addCriterion("service_time like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotLike(String value) {
            addCriterion("service_time not like", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<String> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<String> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(String value1, String value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(String value1, String value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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