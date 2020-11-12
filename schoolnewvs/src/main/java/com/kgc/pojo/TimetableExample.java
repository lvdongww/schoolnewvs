package com.kgc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimetableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimetableExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andTsignindateIsNull() {
            addCriterion("tsignindate is null");
            return (Criteria) this;
        }

        public Criteria andTsignindateIsNotNull() {
            addCriterion("tsignindate is not null");
            return (Criteria) this;
        }

        public Criteria andTsignindateEqualTo(Date value) {
            addCriterion("tsignindate =", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateNotEqualTo(Date value) {
            addCriterion("tsignindate <>", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateGreaterThan(Date value) {
            addCriterion("tsignindate >", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateGreaterThanOrEqualTo(Date value) {
            addCriterion("tsignindate >=", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateLessThan(Date value) {
            addCriterion("tsignindate <", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateLessThanOrEqualTo(Date value) {
            addCriterion("tsignindate <=", value, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateIn(List<Date> values) {
            addCriterion("tsignindate in", values, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateNotIn(List<Date> values) {
            addCriterion("tsignindate not in", values, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateBetween(Date value1, Date value2) {
            addCriterion("tsignindate between", value1, value2, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignindateNotBetween(Date value1, Date value2) {
            addCriterion("tsignindate not between", value1, value2, "tsignindate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateIsNull() {
            addCriterion("tsignoutdate is null");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateIsNotNull() {
            addCriterion("tsignoutdate is not null");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateEqualTo(Date value) {
            addCriterion("tsignoutdate =", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateNotEqualTo(Date value) {
            addCriterion("tsignoutdate <>", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateGreaterThan(Date value) {
            addCriterion("tsignoutdate >", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateGreaterThanOrEqualTo(Date value) {
            addCriterion("tsignoutdate >=", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateLessThan(Date value) {
            addCriterion("tsignoutdate <", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateLessThanOrEqualTo(Date value) {
            addCriterion("tsignoutdate <=", value, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateIn(List<Date> values) {
            addCriterion("tsignoutdate in", values, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateNotIn(List<Date> values) {
            addCriterion("tsignoutdate not in", values, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateBetween(Date value1, Date value2) {
            addCriterion("tsignoutdate between", value1, value2, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andTsignoutdateNotBetween(Date value1, Date value2) {
            addCriterion("tsignoutdate not between", value1, value2, "tsignoutdate");
            return (Criteria) this;
        }

        public Criteria andRestIsNull() {
            addCriterion("rest is null");
            return (Criteria) this;
        }

        public Criteria andRestIsNotNull() {
            addCriterion("rest is not null");
            return (Criteria) this;
        }

        public Criteria andRestEqualTo(String value) {
            addCriterion("rest =", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotEqualTo(String value) {
            addCriterion("rest <>", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThan(String value) {
            addCriterion("rest >", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestGreaterThanOrEqualTo(String value) {
            addCriterion("rest >=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThan(String value) {
            addCriterion("rest <", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLessThanOrEqualTo(String value) {
            addCriterion("rest <=", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestLike(String value) {
            addCriterion("rest like", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotLike(String value) {
            addCriterion("rest not like", value, "rest");
            return (Criteria) this;
        }

        public Criteria andRestIn(List<String> values) {
            addCriterion("rest in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotIn(List<String> values) {
            addCriterion("rest not in", values, "rest");
            return (Criteria) this;
        }

        public Criteria andRestBetween(String value1, String value2) {
            addCriterion("rest between", value1, value2, "rest");
            return (Criteria) this;
        }

        public Criteria andRestNotBetween(String value1, String value2) {
            addCriterion("rest not between", value1, value2, "rest");
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