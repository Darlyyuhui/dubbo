package com.darly.dubbo.store.bean;

import com.darly.dubbo.framework.base.Criterion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreActiviyTypeSearch {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreActiviyTypeSearch() {
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

        public Criteria andStoreTypeIsNull() {
            addCriterion("STORE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("STORE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(String value) {
            addCriterion("STORE_TYPE =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(String value) {
            addCriterion("STORE_TYPE <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(String value) {
            addCriterion("STORE_TYPE >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_TYPE >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(String value) {
            addCriterion("STORE_TYPE <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("STORE_TYPE <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLike(String value) {
            addCriterion("STORE_TYPE like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotLike(String value) {
            addCriterion("STORE_TYPE not like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<String> values) {
            addCriterion("STORE_TYPE in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<String> values) {
            addCriterion("STORE_TYPE not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(String value1, String value2) {
            addCriterion("STORE_TYPE between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(String value1, String value2) {
            addCriterion("STORE_TYPE not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreDescIsNull() {
            addCriterion("STORE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andStoreDescIsNotNull() {
            addCriterion("STORE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andStoreDescEqualTo(String value) {
            addCriterion("STORE_DESC =", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescNotEqualTo(String value) {
            addCriterion("STORE_DESC <>", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescGreaterThan(String value) {
            addCriterion("STORE_DESC >", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_DESC >=", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescLessThan(String value) {
            addCriterion("STORE_DESC <", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescLessThanOrEqualTo(String value) {
            addCriterion("STORE_DESC <=", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescLike(String value) {
            addCriterion("STORE_DESC like", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescNotLike(String value) {
            addCriterion("STORE_DESC not like", value, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescIn(List<String> values) {
            addCriterion("STORE_DESC in", values, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescNotIn(List<String> values) {
            addCriterion("STORE_DESC not in", values, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescBetween(String value1, String value2) {
            addCriterion("STORE_DESC between", value1, value2, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreDescNotBetween(String value1, String value2) {
            addCriterion("STORE_DESC not between", value1, value2, "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeIsNull() {
            addCriterion("STORE_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeIsNotNull() {
            addCriterion("STORE_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeEqualTo(Date value) {
            addCriterion("STORE_START_TIME =", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeNotEqualTo(Date value) {
            addCriterion("STORE_START_TIME <>", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeGreaterThan(Date value) {
            addCriterion("STORE_START_TIME >", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STORE_START_TIME >=", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeLessThan(Date value) {
            addCriterion("STORE_START_TIME <", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("STORE_START_TIME <=", value, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeIn(List<Date> values) {
            addCriterion("STORE_START_TIME in", values, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeNotIn(List<Date> values) {
            addCriterion("STORE_START_TIME not in", values, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeBetween(Date value1, Date value2) {
            addCriterion("STORE_START_TIME between", value1, value2, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("STORE_START_TIME not between", value1, value2, "storeStartTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeIsNull() {
            addCriterion("STORE_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeIsNotNull() {
            addCriterion("STORE_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeEqualTo(Date value) {
            addCriterion("STORE_END_TIME =", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeNotEqualTo(Date value) {
            addCriterion("STORE_END_TIME <>", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeGreaterThan(Date value) {
            addCriterion("STORE_END_TIME >", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STORE_END_TIME >=", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeLessThan(Date value) {
            addCriterion("STORE_END_TIME <", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("STORE_END_TIME <=", value, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeIn(List<Date> values) {
            addCriterion("STORE_END_TIME in", values, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeNotIn(List<Date> values) {
            addCriterion("STORE_END_TIME not in", values, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeBetween(Date value1, Date value2) {
            addCriterion("STORE_END_TIME between", value1, value2, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("STORE_END_TIME not between", value1, value2, "storeEndTime");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpIsNull() {
            addCriterion("STORE_TYPE_OP is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpIsNotNull() {
            addCriterion("STORE_TYPE_OP is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpEqualTo(String value) {
            addCriterion("STORE_TYPE_OP =", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpNotEqualTo(String value) {
            addCriterion("STORE_TYPE_OP <>", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpGreaterThan(String value) {
            addCriterion("STORE_TYPE_OP >", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_TYPE_OP >=", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpLessThan(String value) {
            addCriterion("STORE_TYPE_OP <", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpLessThanOrEqualTo(String value) {
            addCriterion("STORE_TYPE_OP <=", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpLike(String value) {
            addCriterion("STORE_TYPE_OP like", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpNotLike(String value) {
            addCriterion("STORE_TYPE_OP not like", value, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpIn(List<String> values) {
            addCriterion("STORE_TYPE_OP in", values, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpNotIn(List<String> values) {
            addCriterion("STORE_TYPE_OP not in", values, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpBetween(String value1, String value2) {
            addCriterion("STORE_TYPE_OP between", value1, value2, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpNotBetween(String value1, String value2) {
            addCriterion("STORE_TYPE_OP not between", value1, value2, "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeIsNull() {
            addCriterion("STORE_CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeIsNotNull() {
            addCriterion("STORE_CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeEqualTo(Date value) {
            addCriterion("STORE_CREATETIME =", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeNotEqualTo(Date value) {
            addCriterion("STORE_CREATETIME <>", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeGreaterThan(Date value) {
            addCriterion("STORE_CREATETIME >", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STORE_CREATETIME >=", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeLessThan(Date value) {
            addCriterion("STORE_CREATETIME <", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("STORE_CREATETIME <=", value, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeIn(List<Date> values) {
            addCriterion("STORE_CREATETIME in", values, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeNotIn(List<Date> values) {
            addCriterion("STORE_CREATETIME not in", values, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeBetween(Date value1, Date value2) {
            addCriterion("STORE_CREATETIME between", value1, value2, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("STORE_CREATETIME not between", value1, value2, "storeCreatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeIsNull() {
            addCriterion("STORE_UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeIsNotNull() {
            addCriterion("STORE_UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeEqualTo(Date value) {
            addCriterion("STORE_UPDATETIME =", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeNotEqualTo(Date value) {
            addCriterion("STORE_UPDATETIME <>", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeGreaterThan(Date value) {
            addCriterion("STORE_UPDATETIME >", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("STORE_UPDATETIME >=", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeLessThan(Date value) {
            addCriterion("STORE_UPDATETIME <", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("STORE_UPDATETIME <=", value, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeIn(List<Date> values) {
            addCriterion("STORE_UPDATETIME in", values, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeNotIn(List<Date> values) {
            addCriterion("STORE_UPDATETIME not in", values, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("STORE_UPDATETIME between", value1, value2, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("STORE_UPDATETIME not between", value1, value2, "storeUpdatetime");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonIsNull() {
            addCriterion("STORE_UPDATEREASON is null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonIsNotNull() {
            addCriterion("STORE_UPDATEREASON is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonEqualTo(String value) {
            addCriterion("STORE_UPDATEREASON =", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonNotEqualTo(String value) {
            addCriterion("STORE_UPDATEREASON <>", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonGreaterThan(String value) {
            addCriterion("STORE_UPDATEREASON >", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonGreaterThanOrEqualTo(String value) {
            addCriterion("STORE_UPDATEREASON >=", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonLessThan(String value) {
            addCriterion("STORE_UPDATEREASON <", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonLessThanOrEqualTo(String value) {
            addCriterion("STORE_UPDATEREASON <=", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonLike(String value) {
            addCriterion("STORE_UPDATEREASON like", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonNotLike(String value) {
            addCriterion("STORE_UPDATEREASON not like", value, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonIn(List<String> values) {
            addCriterion("STORE_UPDATEREASON in", values, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonNotIn(List<String> values) {
            addCriterion("STORE_UPDATEREASON not in", values, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonBetween(String value1, String value2) {
            addCriterion("STORE_UPDATEREASON between", value1, value2, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonNotBetween(String value1, String value2) {
            addCriterion("STORE_UPDATEREASON not between", value1, value2, "storeUpdatereason");
            return (Criteria) this;
        }

        public Criteria andIdLikeInsensitive(String value) {
            addCriterion("upper(ID) like", value.toUpperCase(), "id");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLikeInsensitive(String value) {
            addCriterion("upper(STORE_TYPE) like", value.toUpperCase(), "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreDescLikeInsensitive(String value) {
            addCriterion("upper(STORE_DESC) like", value.toUpperCase(), "storeDesc");
            return (Criteria) this;
        }

        public Criteria andStoreTypeOpLikeInsensitive(String value) {
            addCriterion("upper(STORE_TYPE_OP) like", value.toUpperCase(), "storeTypeOp");
            return (Criteria) this;
        }

        public Criteria andStoreUpdatereasonLikeInsensitive(String value) {
            addCriterion("upper(STORE_UPDATEREASON) like", value.toUpperCase(), "storeUpdatereason");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}