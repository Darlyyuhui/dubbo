package com.darly.dubbo.store.bean;

import com.darly.dubbo.framework.base.Criterion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StoreProductSearch {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreProductSearch() {
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

        public Criteria andProductNameIsNull() {
            addCriterion("PRODUCT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("PRODUCT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("PRODUCT_NAME =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("PRODUCT_NAME <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("PRODUCT_NAME >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("PRODUCT_NAME <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_NAME <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("PRODUCT_NAME like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("PRODUCT_NAME not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("PRODUCT_NAME in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("PRODUCT_NAME not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_NAME not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("PRODUCT_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("PRODUCT_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_PRICE =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_PRICE <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(BigDecimal value) {
            addCriterion("PRODUCT_PRICE >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_PRICE >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(BigDecimal value) {
            addCriterion("PRODUCT_PRICE <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_PRICE <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<BigDecimal> values) {
            addCriterion("PRODUCT_PRICE in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRODUCT_PRICE not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRODUCT_PRICE between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRODUCT_PRICE not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceIsNull() {
            addCriterion("PRODUCT_ORPRICE is null");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceIsNotNull() {
            addCriterion("PRODUCT_ORPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE =", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceNotEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE <>", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceGreaterThan(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE >", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE >=", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceLessThan(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE <", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRODUCT_ORPRICE <=", value, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceIn(List<BigDecimal> values) {
            addCriterion("PRODUCT_ORPRICE in", values, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceNotIn(List<BigDecimal> values) {
            addCriterion("PRODUCT_ORPRICE not in", values, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRODUCT_ORPRICE between", value1, value2, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductOrpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRODUCT_ORPRICE not between", value1, value2, "productOrprice");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNull() {
            addCriterion("PRODUCT_DESC is null");
            return (Criteria) this;
        }

        public Criteria andProductDescIsNotNull() {
            addCriterion("PRODUCT_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andProductDescEqualTo(String value) {
            addCriterion("PRODUCT_DESC =", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotEqualTo(String value) {
            addCriterion("PRODUCT_DESC <>", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThan(String value) {
            addCriterion("PRODUCT_DESC >", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_DESC >=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThan(String value) {
            addCriterion("PRODUCT_DESC <", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_DESC <=", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescLike(String value) {
            addCriterion("PRODUCT_DESC like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotLike(String value) {
            addCriterion("PRODUCT_DESC not like", value, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescIn(List<String> values) {
            addCriterion("PRODUCT_DESC in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotIn(List<String> values) {
            addCriterion("PRODUCT_DESC not in", values, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescBetween(String value1, String value2) {
            addCriterion("PRODUCT_DESC between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductDescNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_DESC not between", value1, value2, "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductImageIsNull() {
            addCriterion("PRODUCT_IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andProductImageIsNotNull() {
            addCriterion("PRODUCT_IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andProductImageEqualTo(String value) {
            addCriterion("PRODUCT_IMAGE =", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotEqualTo(String value) {
            addCriterion("PRODUCT_IMAGE <>", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageGreaterThan(String value) {
            addCriterion("PRODUCT_IMAGE >", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCT_IMAGE >=", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLessThan(String value) {
            addCriterion("PRODUCT_IMAGE <", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLessThanOrEqualTo(String value) {
            addCriterion("PRODUCT_IMAGE <=", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageLike(String value) {
            addCriterion("PRODUCT_IMAGE like", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotLike(String value) {
            addCriterion("PRODUCT_IMAGE not like", value, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageIn(List<String> values) {
            addCriterion("PRODUCT_IMAGE in", values, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotIn(List<String> values) {
            addCriterion("PRODUCT_IMAGE not in", values, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageBetween(String value1, String value2) {
            addCriterion("PRODUCT_IMAGE between", value1, value2, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductImageNotBetween(String value1, String value2) {
            addCriterion("PRODUCT_IMAGE not between", value1, value2, "productImage");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNull() {
            addCriterion("PRODUCT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andProductNumIsNotNull() {
            addCriterion("PRODUCT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumEqualTo(Integer value) {
            addCriterion("PRODUCT_NUM =", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotEqualTo(Integer value) {
            addCriterion("PRODUCT_NUM <>", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThan(Integer value) {
            addCriterion("PRODUCT_NUM >", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_NUM >=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThan(Integer value) {
            addCriterion("PRODUCT_NUM <", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_NUM <=", value, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumIn(List<Integer> values) {
            addCriterion("PRODUCT_NUM in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotIn(List<Integer> values) {
            addCriterion("PRODUCT_NUM not in", values, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_NUM between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductNumNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_NUM not between", value1, value2, "productNum");
            return (Criteria) this;
        }

        public Criteria andProductStarsIsNull() {
            addCriterion("PRODUCT_STARS is null");
            return (Criteria) this;
        }

        public Criteria andProductStarsIsNotNull() {
            addCriterion("PRODUCT_STARS is not null");
            return (Criteria) this;
        }

        public Criteria andProductStarsEqualTo(Integer value) {
            addCriterion("PRODUCT_STARS =", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsNotEqualTo(Integer value) {
            addCriterion("PRODUCT_STARS <>", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsGreaterThan(Integer value) {
            addCriterion("PRODUCT_STARS >", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_STARS >=", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsLessThan(Integer value) {
            addCriterion("PRODUCT_STARS <", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsLessThanOrEqualTo(Integer value) {
            addCriterion("PRODUCT_STARS <=", value, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsIn(List<Integer> values) {
            addCriterion("PRODUCT_STARS in", values, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsNotIn(List<Integer> values) {
            addCriterion("PRODUCT_STARS not in", values, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_STARS between", value1, value2, "productStars");
            return (Criteria) this;
        }

        public Criteria andProductStarsNotBetween(Integer value1, Integer value2) {
            addCriterion("PRODUCT_STARS not between", value1, value2, "productStars");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(PRODUCT_NAME) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andProductDescLikeInsensitive(String value) {
            addCriterion("upper(PRODUCT_DESC) like", value.toUpperCase(), "productDesc");
            return (Criteria) this;
        }

        public Criteria andProductImageLikeInsensitive(String value) {
            addCriterion("upper(PRODUCT_IMAGE) like", value.toUpperCase(), "productImage");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

}