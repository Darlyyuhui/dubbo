package com.darly.dubbo.security.system.bean;



import com.darly.dubbo.framework.base.Criterion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 10:07
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class SystemLogSearch {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public SystemLogSearch() {
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

        public Criteria andOperatorIdIsNull() {
            this.addCriterion("OPERATOR_ID is null");
            return (Criteria)this;
        }

        public Criteria andOperatorIdIsNotNull() {
            this.addCriterion("OPERATOR_ID is not null");
            return (Criteria)this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            this.addCriterion("OPERATOR_ID =", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            this.addCriterion("OPERATOR_ID <>", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            this.addCriterion("OPERATOR_ID >", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("OPERATOR_ID >=", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            this.addCriterion("OPERATOR_ID <", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            this.addCriterion("OPERATOR_ID <=", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdLike(String value) {
            this.addCriterion("OPERATOR_ID like", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            this.addCriterion("OPERATOR_ID not like", value, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            this.addCriterion("OPERATOR_ID in", values, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            this.addCriterion("OPERATOR_ID not in", values, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            this.addCriterion("OPERATOR_ID between", value1, value2, "operatorId");
            return (Criteria)this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            this.addCriterion("OPERATOR_ID not between", value1, value2, "operatorId");
            return (Criteria)this;
        }

        public Criteria andIpAddressIsNull() {
            this.addCriterion("IP_ADDRESS is null");
            return (Criteria)this;
        }

        public Criteria andIpAddressIsNotNull() {
            this.addCriterion("IP_ADDRESS is not null");
            return (Criteria)this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            this.addCriterion("IP_ADDRESS =", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            this.addCriterion("IP_ADDRESS <>", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            this.addCriterion("IP_ADDRESS >", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("IP_ADDRESS >=", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressLessThan(String value) {
            this.addCriterion("IP_ADDRESS <", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            this.addCriterion("IP_ADDRESS <=", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressLike(String value) {
            this.addCriterion("IP_ADDRESS like", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressNotLike(String value) {
            this.addCriterion("IP_ADDRESS not like", value, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            this.addCriterion("IP_ADDRESS in", values, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            this.addCriterion("IP_ADDRESS not in", values, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            this.addCriterion("IP_ADDRESS between", value1, value2, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            this.addCriterion("IP_ADDRESS not between", value1, value2, "ipAddress");
            return (Criteria)this;
        }

        public Criteria andOperatorNameIsNull() {
            this.addCriterion("OPERATOR_NAME is null");
            return (Criteria)this;
        }

        public Criteria andOperatorNameIsNotNull() {
            this.addCriterion("OPERATOR_NAME is not null");
            return (Criteria)this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            this.addCriterion("OPERATOR_NAME =", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            this.addCriterion("OPERATOR_NAME <>", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            this.addCriterion("OPERATOR_NAME >", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("OPERATOR_NAME >=", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            this.addCriterion("OPERATOR_NAME <", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            this.addCriterion("OPERATOR_NAME <=", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameLike(String value) {
            this.addCriterion("OPERATOR_NAME like", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            this.addCriterion("OPERATOR_NAME not like", value, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            this.addCriterion("OPERATOR_NAME in", values, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            this.addCriterion("OPERATOR_NAME not in", values, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            this.addCriterion("OPERATOR_NAME between", value1, value2, "operatorName");
            return (Criteria)this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            this.addCriterion("OPERATOR_NAME not between", value1, value2, "operatorName");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("TYPE is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("TYPE is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(Long value) {
            this.addCriterion("TYPE =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(Long value) {
            this.addCriterion("TYPE <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(Long value) {
            this.addCriterion("TYPE >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("TYPE >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(Long value) {
            this.addCriterion("TYPE <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(Long value) {
            this.addCriterion("TYPE <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeIn(List<Long> values) {
            this.addCriterion("TYPE in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<Long> values) {
            this.addCriterion("TYPE not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(Long value1, Long value2) {
            this.addCriterion("TYPE between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(Long value1, Long value2) {
            this.addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andLogLevelIsNull() {
            this.addCriterion("LOG_LEVEL is null");
            return (Criteria)this;
        }

        public Criteria andLogLevelIsNotNull() {
            this.addCriterion("LOG_LEVEL is not null");
            return (Criteria)this;
        }

        public Criteria andLogLevelEqualTo(Long value) {
            this.addCriterion("LOG_LEVEL =", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelNotEqualTo(Long value) {
            this.addCriterion("LOG_LEVEL <>", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelGreaterThan(Long value) {
            this.addCriterion("LOG_LEVEL >", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelGreaterThanOrEqualTo(Long value) {
            this.addCriterion("LOG_LEVEL >=", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelLessThan(Long value) {
            this.addCriterion("LOG_LEVEL <", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelLessThanOrEqualTo(Long value) {
            this.addCriterion("LOG_LEVEL <=", value, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelIn(List<Long> values) {
            this.addCriterion("LOG_LEVEL in", values, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelNotIn(List<Long> values) {
            this.addCriterion("LOG_LEVEL not in", values, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelBetween(Long value1, Long value2) {
            this.addCriterion("LOG_LEVEL between", value1, value2, "logLevel");
            return (Criteria)this;
        }

        public Criteria andLogLevelNotBetween(Long value1, Long value2) {
            this.addCriterion("LOG_LEVEL not between", value1, value2, "logLevel");
            return (Criteria)this;
        }

        public Criteria andOperationTimeIsNull() {
            this.addCriterion("OPERATION_TIME is null");
            return (Criteria)this;
        }

        public Criteria andOperationTimeIsNotNull() {
            this.addCriterion("OPERATION_TIME is not null");
            return (Criteria)this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            this.addCriterion("OPERATION_TIME =", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            this.addCriterion("OPERATION_TIME <>", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            this.addCriterion("OPERATION_TIME >", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("OPERATION_TIME >=", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            this.addCriterion("OPERATION_TIME <", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("OPERATION_TIME <=", value, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            this.addCriterion("OPERATION_TIME in", values, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            this.addCriterion("OPERATION_TIME not in", values, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            this.addCriterion("OPERATION_TIME between", value1, value2, "operationTime");
            return (Criteria)this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("OPERATION_TIME not between", value1, value2, "operationTime");
            return (Criteria)this;
        }

        public Criteria andCreateDateIsNull() {
            this.addCriterion("CREATE_DATE is null");
            return (Criteria)this;
        }

        public Criteria andCreateDateIsNotNull() {
            this.addCriterion("CREATE_DATE is not null");
            return (Criteria)this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            this.addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            this.addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            this.addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            this.addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            this.addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            this.addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            this.addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria)this;
        }

        public Criteria andCreateByIsNull() {
            this.addCriterion("CREATE_BY is null");
            return (Criteria)this;
        }

        public Criteria andCreateByIsNotNull() {
            this.addCriterion("CREATE_BY is not null");
            return (Criteria)this;
        }

        public Criteria andCreateByEqualTo(String value) {
            this.addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            this.addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            this.addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            this.addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByLessThan(String value) {
            this.addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            this.addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByLike(String value) {
            this.addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByNotLike(String value) {
            this.addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByIn(List<String> values) {
            this.addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            this.addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            this.addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria)this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            this.addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByIsNull() {
            this.addCriterion("UPDATE_BY is null");
            return (Criteria)this;
        }

        public Criteria andUpdateByIsNotNull() {
            this.addCriterion("UPDATE_BY is not null");
            return (Criteria)this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            this.addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            this.addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            this.addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            this.addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByLessThan(String value) {
            this.addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            this.addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByLike(String value) {
            this.addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByNotLike(String value) {
            this.addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            this.addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            this.addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            this.addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            this.addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria)this;
        }

        public Criteria andUpdateDateIsNull() {
            this.addCriterion("UPDATE_DATE is null");
            return (Criteria)this;
        }

        public Criteria andUpdateDateIsNotNull() {
            this.addCriterion("UPDATE_DATE is not null");
            return (Criteria)this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            this.addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            this.addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            this.addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            this.addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            this.addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            this.addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            this.addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria)this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria)this;
        }

        public Criteria andStatusIsNull() {
            this.addCriterion("STATUS is null");
            return (Criteria)this;
        }

        public Criteria andStatusIsNotNull() {
            this.addCriterion("STATUS is not null");
            return (Criteria)this;
        }

        public Criteria andStatusEqualTo(String value) {
            this.addCriterion("STATUS =", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            this.addCriterion("STATUS <>", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThan(String value) {
            this.addCriterion("STATUS >", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("STATUS >=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThan(String value) {
            this.addCriterion("STATUS <", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            this.addCriterion("STATUS <=", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusLike(String value) {
            this.addCriterion("STATUS like", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotLike(String value) {
            this.addCriterion("STATUS not like", value, "status");
            return (Criteria)this;
        }

        public Criteria andStatusIn(List<String> values) {
            this.addCriterion("STATUS in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            this.addCriterion("STATUS not in", values, "status");
            return (Criteria)this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            this.addCriterion("STATUS between", value1, value2, "status");
            return (Criteria)this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            this.addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria)this;
        }
    }
}
