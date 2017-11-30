package com.darly.dubbo.study.bean;


import com.darly.dubbo.framework.base.Criterion;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public class StudySearch {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public StudySearch() {
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }


    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andIdIsNull() {
            this.addCriterion("ID is null");
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("ID is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(String value) {
            this.addCriterion("ID =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(String value) {
            this.addCriterion("ID <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(String value) {
            this.addCriterion("ID >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("ID >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(String value) {
            this.addCriterion("ID <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            this.addCriterion("ID <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLike(String value) {
            this.addCriterion("ID like", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotLike(String value) {
            this.addCriterion("ID not like", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdIn(List<String> values) {
            this.addCriterion("ID in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<String> values) {
            this.addCriterion("ID not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            this.addCriterion("ID between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            this.addCriterion("ID not between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andCodeIsNull() {
            this.addCriterion("CODE is null");
            return (Criteria)this;
        }

        public Criteria andCodeIsNotNull() {
            this.addCriterion("CODE is not null");
            return (Criteria)this;
        }

        public Criteria andCodeEqualTo(String value) {
            this.addCriterion("CODE =", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            this.addCriterion("CODE <>", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThan(String value) {
            this.addCriterion("CODE >", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("CODE >=", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeLessThan(String value) {
            this.addCriterion("CODE <", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            this.addCriterion("CODE <=", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeLike(String value) {
            this.addCriterion("CODE like", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotLike(String value) {
            this.addCriterion("CODE not like", value, "code");
            return (Criteria)this;
        }

        public Criteria andCodeIn(List<String> values) {
            this.addCriterion("CODE in", values, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            this.addCriterion("CODE not in", values, "code");
            return (Criteria)this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            this.addCriterion("CODE between", value1, value2, "code");
            return (Criteria)this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            this.addCriterion("CODE not between", value1, value2, "code");
            return (Criteria)this;
        }

        public Criteria andNameIsNull() {
            this.addCriterion("NAME is null");
            return (Criteria)this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("NAME is not null");
            return (Criteria)this;
        }

        public Criteria andNameEqualTo(String value) {
            this.addCriterion("NAME =", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotEqualTo(String value) {
            this.addCriterion("NAME <>", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThan(String value) {
            this.addCriterion("NAME >", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("NAME >=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThan(String value) {
            this.addCriterion("NAME <", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("NAME <=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLike(String value) {
            this.addCriterion("NAME like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotLike(String value) {
            this.addCriterion("NAME not like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameIn(List<String> values) {
            this.addCriterion("NAME in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotIn(List<String> values) {
            this.addCriterion("NAME not in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("NAME between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("NAME not between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andRemarkIsNull() {
            this.addCriterion("REMARK is null");
            return (Criteria)this;
        }

        public Criteria andRemarkIsNotNull() {
            this.addCriterion("REMARK is not null");
            return (Criteria)this;
        }

        public Criteria andRemarkEqualTo(String value) {
            this.addCriterion("REMARK =", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("REMARK <>", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("REMARK >", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("REMARK >=", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLessThan(String value) {
            this.addCriterion("REMARK <", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("REMARK <=", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkLike(String value) {
            this.addCriterion("REMARK like", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotLike(String value) {
            this.addCriterion("REMARK not like", value, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkIn(List<String> values) {
            this.addCriterion("REMARK in", values, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("REMARK not in", values, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria)this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria)this;
        }
    }
}
