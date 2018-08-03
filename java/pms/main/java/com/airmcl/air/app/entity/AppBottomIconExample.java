package com.airmcl.air.app.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppBottomIconExample extends AbstractExample<AppBottomIcon> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<AppBottomIcon> pageView = new PageView<AppBottomIcon>(1, 10);

    private static final long serialVersionUID = 1L;

    public AppBottomIconExample() {
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
    public PageView<AppBottomIcon> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<AppBottomIcon> pageView) {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconIsNull() {
            addCriterion("max_select_icon is null");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconIsNotNull() {
            addCriterion("max_select_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconEqualTo(String value) {
            addCriterion("max_select_icon =", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconNotEqualTo(String value) {
            addCriterion("max_select_icon <>", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconGreaterThan(String value) {
            addCriterion("max_select_icon >", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconGreaterThanOrEqualTo(String value) {
            addCriterion("max_select_icon >=", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconLessThan(String value) {
            addCriterion("max_select_icon <", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconLessThanOrEqualTo(String value) {
            addCriterion("max_select_icon <=", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconLike(String value) {
            addCriterion("max_select_icon like", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconNotLike(String value) {
            addCriterion("max_select_icon not like", value, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconIn(List<String> values) {
            addCriterion("max_select_icon in", values, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconNotIn(List<String> values) {
            addCriterion("max_select_icon not in", values, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconBetween(String value1, String value2) {
            addCriterion("max_select_icon between", value1, value2, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxSelectIconNotBetween(String value1, String value2) {
            addCriterion("max_select_icon not between", value1, value2, "maxSelectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconIsNull() {
            addCriterion("select_icon is null");
            return (Criteria) this;
        }

        public Criteria andSelectIconIsNotNull() {
            addCriterion("select_icon is not null");
            return (Criteria) this;
        }

        public Criteria andSelectIconEqualTo(String value) {
            addCriterion("select_icon =", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconNotEqualTo(String value) {
            addCriterion("select_icon <>", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconGreaterThan(String value) {
            addCriterion("select_icon >", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconGreaterThanOrEqualTo(String value) {
            addCriterion("select_icon >=", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconLessThan(String value) {
            addCriterion("select_icon <", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconLessThanOrEqualTo(String value) {
            addCriterion("select_icon <=", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconLike(String value) {
            addCriterion("select_icon like", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconNotLike(String value) {
            addCriterion("select_icon not like", value, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconIn(List<String> values) {
            addCriterion("select_icon in", values, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconNotIn(List<String> values) {
            addCriterion("select_icon not in", values, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconBetween(String value1, String value2) {
            addCriterion("select_icon between", value1, value2, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andSelectIconNotBetween(String value1, String value2) {
            addCriterion("select_icon not between", value1, value2, "selectIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconIsNull() {
            addCriterion("max_unselected_icon is null");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconIsNotNull() {
            addCriterion("max_unselected_icon is not null");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconEqualTo(String value) {
            addCriterion("max_unselected_icon =", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconNotEqualTo(String value) {
            addCriterion("max_unselected_icon <>", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconGreaterThan(String value) {
            addCriterion("max_unselected_icon >", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconGreaterThanOrEqualTo(String value) {
            addCriterion("max_unselected_icon >=", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconLessThan(String value) {
            addCriterion("max_unselected_icon <", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconLessThanOrEqualTo(String value) {
            addCriterion("max_unselected_icon <=", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconLike(String value) {
            addCriterion("max_unselected_icon like", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconNotLike(String value) {
            addCriterion("max_unselected_icon not like", value, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconIn(List<String> values) {
            addCriterion("max_unselected_icon in", values, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconNotIn(List<String> values) {
            addCriterion("max_unselected_icon not in", values, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconBetween(String value1, String value2) {
            addCriterion("max_unselected_icon between", value1, value2, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andMaxUnselectedIconNotBetween(String value1, String value2) {
            addCriterion("max_unselected_icon not between", value1, value2, "maxUnselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconIsNull() {
            addCriterion("unselected_icon is null");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconIsNotNull() {
            addCriterion("unselected_icon is not null");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconEqualTo(String value) {
            addCriterion("unselected_icon =", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconNotEqualTo(String value) {
            addCriterion("unselected_icon <>", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconGreaterThan(String value) {
            addCriterion("unselected_icon >", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconGreaterThanOrEqualTo(String value) {
            addCriterion("unselected_icon >=", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconLessThan(String value) {
            addCriterion("unselected_icon <", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconLessThanOrEqualTo(String value) {
            addCriterion("unselected_icon <=", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconLike(String value) {
            addCriterion("unselected_icon like", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconNotLike(String value) {
            addCriterion("unselected_icon not like", value, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconIn(List<String> values) {
            addCriterion("unselected_icon in", values, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconNotIn(List<String> values) {
            addCriterion("unselected_icon not in", values, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconBetween(String value1, String value2) {
            addCriterion("unselected_icon between", value1, value2, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andUnselectedIconNotBetween(String value1, String value2) {
            addCriterion("unselected_icon not between", value1, value2, "unselectedIcon");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNull() {
            addCriterion("font_color is null");
            return (Criteria) this;
        }

        public Criteria andFontColorIsNotNull() {
            addCriterion("font_color is not null");
            return (Criteria) this;
        }

        public Criteria andFontColorEqualTo(String value) {
            addCriterion("font_color =", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotEqualTo(String value) {
            addCriterion("font_color <>", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThan(String value) {
            addCriterion("font_color >", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorGreaterThanOrEqualTo(String value) {
            addCriterion("font_color >=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThan(String value) {
            addCriterion("font_color <", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLessThanOrEqualTo(String value) {
            addCriterion("font_color <=", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorLike(String value) {
            addCriterion("font_color like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotLike(String value) {
            addCriterion("font_color not like", value, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorIn(List<String> values) {
            addCriterion("font_color in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotIn(List<String> values) {
            addCriterion("font_color not in", values, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorBetween(String value1, String value2) {
            addCriterion("font_color between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andFontColorNotBetween(String value1, String value2) {
            addCriterion("font_color not between", value1, value2, "fontColor");
            return (Criteria) this;
        }

        public Criteria andIsUrlIsNull() {
            addCriterion("is_url is null");
            return (Criteria) this;
        }

        public Criteria andIsUrlIsNotNull() {
            addCriterion("is_url is not null");
            return (Criteria) this;
        }

        public Criteria andIsUrlEqualTo(Byte value) {
            addCriterion("is_url =", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlNotEqualTo(Byte value) {
            addCriterion("is_url <>", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlGreaterThan(Byte value) {
            addCriterion("is_url >", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_url >=", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlLessThan(Byte value) {
            addCriterion("is_url <", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlLessThanOrEqualTo(Byte value) {
            addCriterion("is_url <=", value, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlIn(List<Byte> values) {
            addCriterion("is_url in", values, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlNotIn(List<Byte> values) {
            addCriterion("is_url not in", values, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlBetween(Byte value1, Byte value2) {
            addCriterion("is_url between", value1, value2, "isUrl");
            return (Criteria) this;
        }

        public Criteria andIsUrlNotBetween(Byte value1, Byte value2) {
            addCriterion("is_url not between", value1, value2, "isUrl");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
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

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
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