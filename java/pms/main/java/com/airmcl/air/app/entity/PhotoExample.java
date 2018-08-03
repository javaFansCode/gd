package com.airmcl.air.app.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhotoExample extends AbstractExample<Photo> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<Photo> pageView = new PageView<Photo>(1, 10);

    private static final long serialVersionUID = 1L;

    public PhotoExample() {
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
    public PageView<Photo> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<Photo> pageView) {
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

        public Criteria andPost_idIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPost_idIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPost_idEqualTo(Integer value) {
            addCriterion("post_id =", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotEqualTo(Integer value) {
            addCriterion("post_id <>", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idGreaterThan(Integer value) {
            addCriterion("post_id >", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("post_id >=", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idLessThan(Integer value) {
            addCriterion("post_id <", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idLessThanOrEqualTo(Integer value) {
            addCriterion("post_id <=", value, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idIn(List<Integer> values) {
            addCriterion("post_id in", values, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotIn(List<Integer> values) {
            addCriterion("post_id not in", values, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idBetween(Integer value1, Integer value2) {
            addCriterion("post_id between", value1, value2, "post_id");
            return (Criteria) this;
        }

        public Criteria andPost_idNotBetween(Integer value1, Integer value2) {
            addCriterion("post_id not between", value1, value2, "post_id");
            return (Criteria) this;
        }

        public Criteria andType_codeIsNull() {
            addCriterion("type_code is null");
            return (Criteria) this;
        }

        public Criteria andType_codeIsNotNull() {
            addCriterion("type_code is not null");
            return (Criteria) this;
        }

        public Criteria andType_codeEqualTo(String value) {
            addCriterion("type_code =", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeNotEqualTo(String value) {
            addCriterion("type_code <>", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeGreaterThan(String value) {
            addCriterion("type_code >", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeGreaterThanOrEqualTo(String value) {
            addCriterion("type_code >=", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeLessThan(String value) {
            addCriterion("type_code <", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeLessThanOrEqualTo(String value) {
            addCriterion("type_code <=", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeLike(String value) {
            addCriterion("type_code like", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeNotLike(String value) {
            addCriterion("type_code not like", value, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeIn(List<String> values) {
            addCriterion("type_code in", values, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeNotIn(List<String> values) {
            addCriterion("type_code not in", values, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeBetween(String value1, String value2) {
            addCriterion("type_code between", value1, value2, "type_code");
            return (Criteria) this;
        }

        public Criteria andType_codeNotBetween(String value1, String value2) {
            addCriterion("type_code not between", value1, value2, "type_code");
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

        public Criteria andOriginal_pathIsNull() {
            addCriterion("original_path is null");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathIsNotNull() {
            addCriterion("original_path is not null");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathEqualTo(String value) {
            addCriterion("original_path =", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathNotEqualTo(String value) {
            addCriterion("original_path <>", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathGreaterThan(String value) {
            addCriterion("original_path >", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathGreaterThanOrEqualTo(String value) {
            addCriterion("original_path >=", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathLessThan(String value) {
            addCriterion("original_path <", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathLessThanOrEqualTo(String value) {
            addCriterion("original_path <=", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathLike(String value) {
            addCriterion("original_path like", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathNotLike(String value) {
            addCriterion("original_path not like", value, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathIn(List<String> values) {
            addCriterion("original_path in", values, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathNotIn(List<String> values) {
            addCriterion("original_path not in", values, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathBetween(String value1, String value2) {
            addCriterion("original_path between", value1, value2, "original_path");
            return (Criteria) this;
        }

        public Criteria andOriginal_pathNotBetween(String value1, String value2) {
            addCriterion("original_path not between", value1, value2, "original_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathIsNull() {
            addCriterion("thumb_path is null");
            return (Criteria) this;
        }

        public Criteria andThumb_pathIsNotNull() {
            addCriterion("thumb_path is not null");
            return (Criteria) this;
        }

        public Criteria andThumb_pathEqualTo(String value) {
            addCriterion("thumb_path =", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathNotEqualTo(String value) {
            addCriterion("thumb_path <>", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathGreaterThan(String value) {
            addCriterion("thumb_path >", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_path >=", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathLessThan(String value) {
            addCriterion("thumb_path <", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathLessThanOrEqualTo(String value) {
            addCriterion("thumb_path <=", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathLike(String value) {
            addCriterion("thumb_path like", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathNotLike(String value) {
            addCriterion("thumb_path not like", value, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathIn(List<String> values) {
            addCriterion("thumb_path in", values, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathNotIn(List<String> values) {
            addCriterion("thumb_path not in", values, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathBetween(String value1, String value2) {
            addCriterion("thumb_path between", value1, value2, "thumb_path");
            return (Criteria) this;
        }

        public Criteria andThumb_pathNotBetween(String value1, String value2) {
            addCriterion("thumb_path not between", value1, value2, "thumb_path");
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

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Byte value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Byte value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Byte value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Byte value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Byte value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Byte> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Byte> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Byte value1, Byte value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
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