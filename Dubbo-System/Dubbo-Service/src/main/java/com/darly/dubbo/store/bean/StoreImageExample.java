package com.darly.dubbo.store.bean;

import com.darly.dubbo.framework.base.Criterion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreImageExample() {
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNull() {
            addCriterion("PRODUCT_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIsNotNull() {
            addCriterion("PRODUCT_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_ID =", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_ID <>", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThan(String value) {
            addCriterion("PRODUCT_TYPE_ID >", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_ID >=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThan(String value) {
            addCriterion("PRODUCT_TYPE_ID <", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_TYPE_ID <=", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLike(String value) {
            addCriterion("PRODUCT_TYPE_ID like", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotLike(String value) {
            addCriterion("PRODUCT_TYPE_ID not like", value, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdIn(List<String> values) {
            addCriterion("PRODUCT_TYPE_ID in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotIn(List<String> values) {
            addCriterion("PRODUCT_TYPE_ID not in", values, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE_ID between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_TYPE_ID not between", value1, value2, "productTypeId");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("IMAGE_URL is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("IMAGE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("IMAGE_URL =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("IMAGE_URL <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("IMAGE_URL >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("IMAGE_URL <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_URL <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("IMAGE_URL like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("IMAGE_URL not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("IMAGE_URL in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("IMAGE_URL not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("IMAGE_URL between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("IMAGE_URL not between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageDescIsNull() {
            addCriterion("IMAGE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andImageDescIsNotNull() {
            addCriterion("IMAGE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andImageDescEqualTo(String value) {
            addCriterion("IMAGE_DESC =", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescNotEqualTo(String value) {
            addCriterion("IMAGE_DESC <>", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescGreaterThan(String value) {
            addCriterion("IMAGE_DESC >", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE_DESC >=", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescLessThan(String value) {
            addCriterion("IMAGE_DESC <", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescLessThanOrEqualTo(String value) {
            addCriterion("IMAGE_DESC <=", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescLike(String value) {
            addCriterion("IMAGE_DESC like", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescNotLike(String value) {
            addCriterion("IMAGE_DESC not like", value, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescIn(List<String> values) {
            addCriterion("IMAGE_DESC in", values, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescNotIn(List<String> values) {
            addCriterion("IMAGE_DESC not in", values, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescBetween(String value1, String value2) {
            addCriterion("IMAGE_DESC between", value1, value2, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageDescNotBetween(String value1, String value2) {
            addCriterion("IMAGE_DESC not between", value1, value2, "imageDesc");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeIsNull() {
            addCriterion("IMAGE_UPLOADTIME is null");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeIsNotNull() {
            addCriterion("IMAGE_UPLOADTIME is not null");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeEqualTo(Date value) {
            addCriterion("IMAGE_UPLOADTIME =", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeNotEqualTo(Date value) {
            addCriterion("IMAGE_UPLOADTIME <>", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeGreaterThan(Date value) {
            addCriterion("IMAGE_UPLOADTIME >", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("IMAGE_UPLOADTIME >=", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeLessThan(Date value) {
            addCriterion("IMAGE_UPLOADTIME <", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeLessThanOrEqualTo(Date value) {
            addCriterion("IMAGE_UPLOADTIME <=", value, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeIn(List<Date> values) {
            addCriterion("IMAGE_UPLOADTIME in", values, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeNotIn(List<Date> values) {
            addCriterion("IMAGE_UPLOADTIME not in", values, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeBetween(Date value1, Date value2) {
            addCriterion("IMAGE_UPLOADTIME between", value1, value2, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andImageUploadtimeNotBetween(Date value1, Date value2) {
            addCriterion("IMAGE_UPLOADTIME not between", value1, value2, "imageUploadtime");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProductTypeIdLikeInsensitive(String value) {
            addCriterion("upper(PRODUCT_TYPE_ID) like", value.toUpperCase(), "productTypeId");
            return (Criteria) this;
        }

        public Criteria andImageUrlLikeInsensitive(String value) {
            addCriterion("upper(IMAGE_URL) like", value.toUpperCase(), "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageDescLikeInsensitive(String value) {
            addCriterion("upper(IMAGE_DESC) like", value.toUpperCase(), "imageDesc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

}