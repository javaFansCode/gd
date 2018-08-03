package com.airmcl.air.beautician.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BeauticianExample extends AbstractExample<Beautician> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Beautician> pageView = new PageView<Beautician>(1, 10);

    private static final long serialVersionUID = 1L;

    public BeauticianExample() {
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
    public PageView<Beautician> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Beautician> pageView) {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
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

        public Criteria andPswIsNull() {
            addCriterion("psw is null");
            return (Criteria) this;
        }

        public Criteria andPswIsNotNull() {
            addCriterion("psw is not null");
            return (Criteria) this;
        }

        public Criteria andPswEqualTo(String value) {
            addCriterion("psw =", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswNotEqualTo(String value) {
            addCriterion("psw <>", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswGreaterThan(String value) {
            addCriterion("psw >", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswGreaterThanOrEqualTo(String value) {
            addCriterion("psw >=", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswLessThan(String value) {
            addCriterion("psw <", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswLessThanOrEqualTo(String value) {
            addCriterion("psw <=", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswLike(String value) {
            addCriterion("psw like", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswNotLike(String value) {
            addCriterion("psw not like", value, "psw");
            return (Criteria) this;
        }

        public Criteria andPswIn(List<String> values) {
            addCriterion("psw in", values, "psw");
            return (Criteria) this;
        }

        public Criteria andPswNotIn(List<String> values) {
            addCriterion("psw not in", values, "psw");
            return (Criteria) this;
        }

        public Criteria andPswBetween(String value1, String value2) {
            addCriterion("psw between", value1, value2, "psw");
            return (Criteria) this;
        }

        public Criteria andPswNotBetween(String value1, String value2) {
            addCriterion("psw not between", value1, value2, "psw");
            return (Criteria) this;
        }

        public Criteria andHeadpicIsNull() {
            addCriterion("headpic is null");
            return (Criteria) this;
        }

        public Criteria andHeadpicIsNotNull() {
            addCriterion("headpic is not null");
            return (Criteria) this;
        }

        public Criteria andHeadpicEqualTo(String value) {
            addCriterion("headpic =", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotEqualTo(String value) {
            addCriterion("headpic <>", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicGreaterThan(String value) {
            addCriterion("headpic >", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicGreaterThanOrEqualTo(String value) {
            addCriterion("headpic >=", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLessThan(String value) {
            addCriterion("headpic <", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLessThanOrEqualTo(String value) {
            addCriterion("headpic <=", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicLike(String value) {
            addCriterion("headpic like", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotLike(String value) {
            addCriterion("headpic not like", value, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicIn(List<String> values) {
            addCriterion("headpic in", values, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotIn(List<String> values) {
            addCriterion("headpic not in", values, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicBetween(String value1, String value2) {
            addCriterion("headpic between", value1, value2, "headpic");
            return (Criteria) this;
        }

        public Criteria andHeadpicNotBetween(String value1, String value2) {
            addCriterion("headpic not between", value1, value2, "headpic");
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

        public Criteria andCareerTypeIsNull() {
            addCriterion("career_type is null");
            return (Criteria) this;
        }

        public Criteria andCareerTypeIsNotNull() {
            addCriterion("career_type is not null");
            return (Criteria) this;
        }

        public Criteria andCareerTypeEqualTo(Byte value) {
            addCriterion("career_type =", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotEqualTo(Byte value) {
            addCriterion("career_type <>", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeGreaterThan(Byte value) {
            addCriterion("career_type >", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("career_type >=", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeLessThan(Byte value) {
            addCriterion("career_type <", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeLessThanOrEqualTo(Byte value) {
            addCriterion("career_type <=", value, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeIn(List<Byte> values) {
            addCriterion("career_type in", values, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotIn(List<Byte> values) {
            addCriterion("career_type not in", values, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeBetween(Byte value1, Byte value2) {
            addCriterion("career_type between", value1, value2, "careerType");
            return (Criteria) this;
        }

        public Criteria andCareerTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("career_type not between", value1, value2, "careerType");
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

        public Criteria andServiceTotalIsNull() {
            addCriterion("service_total is null");
            return (Criteria) this;
        }

        public Criteria andServiceTotalIsNotNull() {
            addCriterion("service_total is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTotalEqualTo(Short value) {
            addCriterion("service_total =", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotEqualTo(Short value) {
            addCriterion("service_total <>", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalGreaterThan(Short value) {
            addCriterion("service_total >", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalGreaterThanOrEqualTo(Short value) {
            addCriterion("service_total >=", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalLessThan(Short value) {
            addCriterion("service_total <", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalLessThanOrEqualTo(Short value) {
            addCriterion("service_total <=", value, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalIn(List<Short> values) {
            addCriterion("service_total in", values, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotIn(List<Short> values) {
            addCriterion("service_total not in", values, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalBetween(Short value1, Short value2) {
            addCriterion("service_total between", value1, value2, "serviceTotal");
            return (Criteria) this;
        }

        public Criteria andServiceTotalNotBetween(Short value1, Short value2) {
            addCriterion("service_total not between", value1, value2, "serviceTotal");
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

        public Criteria andStoreScoreEqualTo(Integer value) {
            addCriterion("store_score =", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotEqualTo(Integer value) {
            addCriterion("store_score <>", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThan(Integer value) {
            addCriterion("store_score >", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_score >=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThan(Integer value) {
            addCriterion("store_score <", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreLessThanOrEqualTo(Integer value) {
            addCriterion("store_score <=", value, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreIn(List<Integer> values) {
            addCriterion("store_score in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotIn(List<Integer> values) {
            addCriterion("store_score not in", values, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreBetween(Integer value1, Integer value2) {
            addCriterion("store_score between", value1, value2, "storeScore");
            return (Criteria) this;
        }

        public Criteria andStoreScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("store_score not between", value1, value2, "storeScore");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIsNull() {
            addCriterion("good_total is null");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIsNotNull() {
            addCriterion("good_total is not null");
            return (Criteria) this;
        }

        public Criteria andGoodTotalEqualTo(Integer value) {
            addCriterion("good_total =", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotEqualTo(Integer value) {
            addCriterion("good_total <>", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalGreaterThan(Integer value) {
            addCriterion("good_total >", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("good_total >=", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalLessThan(Integer value) {
            addCriterion("good_total <", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalLessThanOrEqualTo(Integer value) {
            addCriterion("good_total <=", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIn(List<Integer> values) {
            addCriterion("good_total in", values, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotIn(List<Integer> values) {
            addCriterion("good_total not in", values, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalBetween(Integer value1, Integer value2) {
            addCriterion("good_total between", value1, value2, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("good_total not between", value1, value2, "goodTotal");
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