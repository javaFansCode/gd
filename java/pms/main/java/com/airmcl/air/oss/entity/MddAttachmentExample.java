package com.airmcl.air.oss.entity;

import com.els.base.core.entity.AbstractExample;
import com.els.base.core.entity.PageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MddAttachmentExample extends AbstractExample<MddAttachment> implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected PageView<MddAttachment> pageView = new PageView<MddAttachment>(1, 10);

    private static final long serialVersionUID = 1L;

    public MddAttachmentExample() {
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
    public PageView<MddAttachment> getPageView() {
        return pageView;
    }

    @Override
    public void setPageView(PageView<MddAttachment> pageView) {
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

        public Criteria andImagewidthIsNull() {
            addCriterion("imagewidth is null");
            return (Criteria) this;
        }

        public Criteria andImagewidthIsNotNull() {
            addCriterion("imagewidth is not null");
            return (Criteria) this;
        }

        public Criteria andImagewidthEqualTo(String value) {
            addCriterion("imagewidth =", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotEqualTo(String value) {
            addCriterion("imagewidth <>", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthGreaterThan(String value) {
            addCriterion("imagewidth >", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthGreaterThanOrEqualTo(String value) {
            addCriterion("imagewidth >=", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthLessThan(String value) {
            addCriterion("imagewidth <", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthLessThanOrEqualTo(String value) {
            addCriterion("imagewidth <=", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthLike(String value) {
            addCriterion("imagewidth like", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotLike(String value) {
            addCriterion("imagewidth not like", value, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthIn(List<String> values) {
            addCriterion("imagewidth in", values, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotIn(List<String> values) {
            addCriterion("imagewidth not in", values, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthBetween(String value1, String value2) {
            addCriterion("imagewidth between", value1, value2, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImagewidthNotBetween(String value1, String value2) {
            addCriterion("imagewidth not between", value1, value2, "imagewidth");
            return (Criteria) this;
        }

        public Criteria andImageheightIsNull() {
            addCriterion("imageheight is null");
            return (Criteria) this;
        }

        public Criteria andImageheightIsNotNull() {
            addCriterion("imageheight is not null");
            return (Criteria) this;
        }

        public Criteria andImageheightEqualTo(String value) {
            addCriterion("imageheight =", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotEqualTo(String value) {
            addCriterion("imageheight <>", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightGreaterThan(String value) {
            addCriterion("imageheight >", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightGreaterThanOrEqualTo(String value) {
            addCriterion("imageheight >=", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightLessThan(String value) {
            addCriterion("imageheight <", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightLessThanOrEqualTo(String value) {
            addCriterion("imageheight <=", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightLike(String value) {
            addCriterion("imageheight like", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotLike(String value) {
            addCriterion("imageheight not like", value, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightIn(List<String> values) {
            addCriterion("imageheight in", values, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotIn(List<String> values) {
            addCriterion("imageheight not in", values, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightBetween(String value1, String value2) {
            addCriterion("imageheight between", value1, value2, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImageheightNotBetween(String value1, String value2) {
            addCriterion("imageheight not between", value1, value2, "imageheight");
            return (Criteria) this;
        }

        public Criteria andImagetypeIsNull() {
            addCriterion("imagetype is null");
            return (Criteria) this;
        }

        public Criteria andImagetypeIsNotNull() {
            addCriterion("imagetype is not null");
            return (Criteria) this;
        }

        public Criteria andImagetypeEqualTo(String value) {
            addCriterion("imagetype =", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeNotEqualTo(String value) {
            addCriterion("imagetype <>", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeGreaterThan(String value) {
            addCriterion("imagetype >", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeGreaterThanOrEqualTo(String value) {
            addCriterion("imagetype >=", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeLessThan(String value) {
            addCriterion("imagetype <", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeLessThanOrEqualTo(String value) {
            addCriterion("imagetype <=", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeLike(String value) {
            addCriterion("imagetype like", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeNotLike(String value) {
            addCriterion("imagetype not like", value, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeIn(List<String> values) {
            addCriterion("imagetype in", values, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeNotIn(List<String> values) {
            addCriterion("imagetype not in", values, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeBetween(String value1, String value2) {
            addCriterion("imagetype between", value1, value2, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImagetypeNotBetween(String value1, String value2) {
            addCriterion("imagetype not between", value1, value2, "imagetype");
            return (Criteria) this;
        }

        public Criteria andImageframesIsNull() {
            addCriterion("imageframes is null");
            return (Criteria) this;
        }

        public Criteria andImageframesIsNotNull() {
            addCriterion("imageframes is not null");
            return (Criteria) this;
        }

        public Criteria andImageframesEqualTo(Integer value) {
            addCriterion("imageframes =", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesNotEqualTo(Integer value) {
            addCriterion("imageframes <>", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesGreaterThan(Integer value) {
            addCriterion("imageframes >", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesGreaterThanOrEqualTo(Integer value) {
            addCriterion("imageframes >=", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesLessThan(Integer value) {
            addCriterion("imageframes <", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesLessThanOrEqualTo(Integer value) {
            addCriterion("imageframes <=", value, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesIn(List<Integer> values) {
            addCriterion("imageframes in", values, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesNotIn(List<Integer> values) {
            addCriterion("imageframes not in", values, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesBetween(Integer value1, Integer value2) {
            addCriterion("imageframes between", value1, value2, "imageframes");
            return (Criteria) this;
        }

        public Criteria andImageframesNotBetween(Integer value1, Integer value2) {
            addCriterion("imageframes not between", value1, value2, "imageframes");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNull() {
            addCriterion("filesize is null");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNotNull() {
            addCriterion("filesize is not null");
            return (Criteria) this;
        }

        public Criteria andFilesizeEqualTo(Integer value) {
            addCriterion("filesize =", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotEqualTo(Integer value) {
            addCriterion("filesize <>", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThan(Integer value) {
            addCriterion("filesize >", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("filesize >=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThan(Integer value) {
            addCriterion("filesize <", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThanOrEqualTo(Integer value) {
            addCriterion("filesize <=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeIn(List<Integer> values) {
            addCriterion("filesize in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotIn(List<Integer> values) {
            addCriterion("filesize not in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeBetween(Integer value1, Integer value2) {
            addCriterion("filesize between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotBetween(Integer value1, Integer value2) {
            addCriterion("filesize not between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andMimetypeIsNull() {
            addCriterion("mimetype is null");
            return (Criteria) this;
        }

        public Criteria andMimetypeIsNotNull() {
            addCriterion("mimetype is not null");
            return (Criteria) this;
        }

        public Criteria andMimetypeEqualTo(String value) {
            addCriterion("mimetype =", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotEqualTo(String value) {
            addCriterion("mimetype <>", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeGreaterThan(String value) {
            addCriterion("mimetype >", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeGreaterThanOrEqualTo(String value) {
            addCriterion("mimetype >=", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLessThan(String value) {
            addCriterion("mimetype <", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLessThanOrEqualTo(String value) {
            addCriterion("mimetype <=", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeLike(String value) {
            addCriterion("mimetype like", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotLike(String value) {
            addCriterion("mimetype not like", value, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeIn(List<String> values) {
            addCriterion("mimetype in", values, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotIn(List<String> values) {
            addCriterion("mimetype not in", values, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeBetween(String value1, String value2) {
            addCriterion("mimetype between", value1, value2, "mimetype");
            return (Criteria) this;
        }

        public Criteria andMimetypeNotBetween(String value1, String value2) {
            addCriterion("mimetype not between", value1, value2, "mimetype");
            return (Criteria) this;
        }

        public Criteria andExtparamIsNull() {
            addCriterion("extparam is null");
            return (Criteria) this;
        }

        public Criteria andExtparamIsNotNull() {
            addCriterion("extparam is not null");
            return (Criteria) this;
        }

        public Criteria andExtparamEqualTo(String value) {
            addCriterion("extparam =", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamNotEqualTo(String value) {
            addCriterion("extparam <>", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamGreaterThan(String value) {
            addCriterion("extparam >", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamGreaterThanOrEqualTo(String value) {
            addCriterion("extparam >=", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamLessThan(String value) {
            addCriterion("extparam <", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamLessThanOrEqualTo(String value) {
            addCriterion("extparam <=", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamLike(String value) {
            addCriterion("extparam like", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamNotLike(String value) {
            addCriterion("extparam not like", value, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamIn(List<String> values) {
            addCriterion("extparam in", values, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamNotIn(List<String> values) {
            addCriterion("extparam not in", values, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamBetween(String value1, String value2) {
            addCriterion("extparam between", value1, value2, "extparam");
            return (Criteria) this;
        }

        public Criteria andExtparamNotBetween(String value1, String value2) {
            addCriterion("extparam not between", value1, value2, "extparam");
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

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Integer value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Integer value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Integer value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Integer value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Integer> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Integer> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Integer value1, Integer value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNull() {
            addCriterion("uploadtime is null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIsNotNull() {
            addCriterion("uploadtime is not null");
            return (Criteria) this;
        }

        public Criteria andUploadtimeEqualTo(Integer value) {
            addCriterion("uploadtime =", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotEqualTo(Integer value) {
            addCriterion("uploadtime <>", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThan(Integer value) {
            addCriterion("uploadtime >", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("uploadtime >=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThan(Integer value) {
            addCriterion("uploadtime <", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeLessThanOrEqualTo(Integer value) {
            addCriterion("uploadtime <=", value, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeIn(List<Integer> values) {
            addCriterion("uploadtime in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotIn(List<Integer> values) {
            addCriterion("uploadtime not in", values, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeBetween(Integer value1, Integer value2) {
            addCriterion("uploadtime between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andUploadtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("uploadtime not between", value1, value2, "uploadtime");
            return (Criteria) this;
        }

        public Criteria andStorageIsNull() {
            addCriterion("`storage` is null");
            return (Criteria) this;
        }

        public Criteria andStorageIsNotNull() {
            addCriterion("`storage` is not null");
            return (Criteria) this;
        }

        public Criteria andStorageEqualTo(String value) {
            addCriterion("`storage` =", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotEqualTo(String value) {
            addCriterion("`storage` <>", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageGreaterThan(String value) {
            addCriterion("`storage` >", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageGreaterThanOrEqualTo(String value) {
            addCriterion("`storage` >=", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageLessThan(String value) {
            addCriterion("`storage` <", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageLessThanOrEqualTo(String value) {
            addCriterion("`storage` <=", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageLike(String value) {
            addCriterion("`storage` like", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotLike(String value) {
            addCriterion("`storage` not like", value, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageIn(List<String> values) {
            addCriterion("`storage` in", values, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotIn(List<String> values) {
            addCriterion("`storage` not in", values, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageBetween(String value1, String value2) {
            addCriterion("`storage` between", value1, value2, "storage");
            return (Criteria) this;
        }

        public Criteria andStorageNotBetween(String value1, String value2) {
            addCriterion("`storage` not between", value1, value2, "storage");
            return (Criteria) this;
        }

        public Criteria andImagemodelIsNull() {
            addCriterion("imagemodel is null");
            return (Criteria) this;
        }

        public Criteria andImagemodelIsNotNull() {
            addCriterion("imagemodel is not null");
            return (Criteria) this;
        }

        public Criteria andImagemodelEqualTo(String value) {
            addCriterion("imagemodel =", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelNotEqualTo(String value) {
            addCriterion("imagemodel <>", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelGreaterThan(String value) {
            addCriterion("imagemodel >", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelGreaterThanOrEqualTo(String value) {
            addCriterion("imagemodel >=", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelLessThan(String value) {
            addCriterion("imagemodel <", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelLessThanOrEqualTo(String value) {
            addCriterion("imagemodel <=", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelLike(String value) {
            addCriterion("imagemodel like", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelNotLike(String value) {
            addCriterion("imagemodel not like", value, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelIn(List<String> values) {
            addCriterion("imagemodel in", values, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelNotIn(List<String> values) {
            addCriterion("imagemodel not in", values, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelBetween(String value1, String value2) {
            addCriterion("imagemodel between", value1, value2, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andImagemodelNotBetween(String value1, String value2) {
            addCriterion("imagemodel not between", value1, value2, "imagemodel");
            return (Criteria) this;
        }

        public Criteria andBucketIsNull() {
            addCriterion("bucket is null");
            return (Criteria) this;
        }

        public Criteria andBucketIsNotNull() {
            addCriterion("bucket is not null");
            return (Criteria) this;
        }

        public Criteria andBucketEqualTo(String value) {
            addCriterion("bucket =", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketNotEqualTo(String value) {
            addCriterion("bucket <>", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketGreaterThan(String value) {
            addCriterion("bucket >", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketGreaterThanOrEqualTo(String value) {
            addCriterion("bucket >=", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketLessThan(String value) {
            addCriterion("bucket <", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketLessThanOrEqualTo(String value) {
            addCriterion("bucket <=", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketLike(String value) {
            addCriterion("bucket like", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketNotLike(String value) {
            addCriterion("bucket not like", value, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketIn(List<String> values) {
            addCriterion("bucket in", values, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketNotIn(List<String> values) {
            addCriterion("bucket not in", values, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketBetween(String value1, String value2) {
            addCriterion("bucket between", value1, value2, "bucket");
            return (Criteria) this;
        }

        public Criteria andBucketNotBetween(String value1, String value2) {
            addCriterion("bucket not between", value1, value2, "bucket");
            return (Criteria) this;
        }

        public Criteria andSha1IsNull() {
            addCriterion("sha1 is null");
            return (Criteria) this;
        }

        public Criteria andSha1IsNotNull() {
            addCriterion("sha1 is not null");
            return (Criteria) this;
        }

        public Criteria andSha1EqualTo(String value) {
            addCriterion("sha1 =", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1NotEqualTo(String value) {
            addCriterion("sha1 <>", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1GreaterThan(String value) {
            addCriterion("sha1 >", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1GreaterThanOrEqualTo(String value) {
            addCriterion("sha1 >=", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1LessThan(String value) {
            addCriterion("sha1 <", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1LessThanOrEqualTo(String value) {
            addCriterion("sha1 <=", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1Like(String value) {
            addCriterion("sha1 like", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1NotLike(String value) {
            addCriterion("sha1 not like", value, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1In(List<String> values) {
            addCriterion("sha1 in", values, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1NotIn(List<String> values) {
            addCriterion("sha1 not in", values, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1Between(String value1, String value2) {
            addCriterion("sha1 between", value1, value2, "sha1");
            return (Criteria) this;
        }

        public Criteria andSha1NotBetween(String value1, String value2) {
            addCriterion("sha1 not between", value1, value2, "sha1");
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