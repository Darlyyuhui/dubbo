package com.darly.dubbo.lucene.bean;

import java.util.ArrayList;
import java.util.List;

public class SystemLuceneSearch {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemLuceneSearch() {
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

        public Criteria andLucenekeyIsNull() {
            addCriterion("LUCENEKEY is null");
            return (Criteria) this;
        }

        public Criteria andLucenekeyIsNotNull() {
            addCriterion("LUCENEKEY is not null");
            return (Criteria) this;
        }

        public Criteria andLucenekeyEqualTo(String value) {
            addCriterion("LUCENEKEY =", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyNotEqualTo(String value) {
            addCriterion("LUCENEKEY <>", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyGreaterThan(String value) {
            addCriterion("LUCENEKEY >", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyGreaterThanOrEqualTo(String value) {
            addCriterion("LUCENEKEY >=", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyLessThan(String value) {
            addCriterion("LUCENEKEY <", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyLessThanOrEqualTo(String value) {
            addCriterion("LUCENEKEY <=", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyLike(String value) {
            addCriterion("LUCENEKEY like", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyNotLike(String value) {
            addCriterion("LUCENEKEY not like", value, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyIn(List<String> values) {
            addCriterion("LUCENEKEY in", values, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyNotIn(List<String> values) {
            addCriterion("LUCENEKEY not in", values, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyBetween(String value1, String value2) {
            addCriterion("LUCENEKEY between", value1, value2, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenekeyNotBetween(String value1, String value2) {
            addCriterion("LUCENEKEY not between", value1, value2, "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenevalueIsNull() {
            addCriterion("LUCENEVALUE is null");
            return (Criteria) this;
        }

        public Criteria andLucenevalueIsNotNull() {
            addCriterion("LUCENEVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andLucenevalueEqualTo(String value) {
            addCriterion("LUCENEVALUE =", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueNotEqualTo(String value) {
            addCriterion("LUCENEVALUE <>", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueGreaterThan(String value) {
            addCriterion("LUCENEVALUE >", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueGreaterThanOrEqualTo(String value) {
            addCriterion("LUCENEVALUE >=", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueLessThan(String value) {
            addCriterion("LUCENEVALUE <", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueLessThanOrEqualTo(String value) {
            addCriterion("LUCENEVALUE <=", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueLike(String value) {
            addCriterion("LUCENEVALUE like", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueNotLike(String value) {
            addCriterion("LUCENEVALUE not like", value, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueIn(List<String> values) {
            addCriterion("LUCENEVALUE in", values, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueNotIn(List<String> values) {
            addCriterion("LUCENEVALUE not in", values, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueBetween(String value1, String value2) {
            addCriterion("LUCENEVALUE between", value1, value2, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLucenevalueNotBetween(String value1, String value2) {
            addCriterion("LUCENEVALUE not between", value1, value2, "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLuceneurlIsNull() {
            addCriterion("LUCENEURL is null");
            return (Criteria) this;
        }

        public Criteria andLuceneurlIsNotNull() {
            addCriterion("LUCENEURL is not null");
            return (Criteria) this;
        }

        public Criteria andLuceneurlEqualTo(String value) {
            addCriterion("LUCENEURL =", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlNotEqualTo(String value) {
            addCriterion("LUCENEURL <>", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlGreaterThan(String value) {
            addCriterion("LUCENEURL >", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlGreaterThanOrEqualTo(String value) {
            addCriterion("LUCENEURL >=", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlLessThan(String value) {
            addCriterion("LUCENEURL <", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlLessThanOrEqualTo(String value) {
            addCriterion("LUCENEURL <=", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlLike(String value) {
            addCriterion("LUCENEURL like", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlNotLike(String value) {
            addCriterion("LUCENEURL not like", value, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlIn(List<String> values) {
            addCriterion("LUCENEURL in", values, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlNotIn(List<String> values) {
            addCriterion("LUCENEURL not in", values, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlBetween(String value1, String value2) {
            addCriterion("LUCENEURL between", value1, value2, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andLuceneurlNotBetween(String value1, String value2) {
            addCriterion("LUCENEURL not between", value1, value2, "luceneurl");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andLucenekeyLikeInsensitive(String value) {
            addCriterion("upper(LUCENEKEY) like", value.toUpperCase(), "lucenekey");
            return (Criteria) this;
        }

        public Criteria andLucenevalueLikeInsensitive(String value) {
            addCriterion("upper(LUCENEVALUE) like", value.toUpperCase(), "lucenevalue");
            return (Criteria) this;
        }

        public Criteria andLuceneurlLikeInsensitive(String value) {
            addCriterion("upper(LUCENEURL) like", value.toUpperCase(), "luceneurl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

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