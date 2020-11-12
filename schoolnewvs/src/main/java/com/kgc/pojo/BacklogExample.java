package com.kgc.pojo;

import java.util.ArrayList;
import java.util.List;

public class BacklogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BacklogExample() {
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

        public Criteria andBackidIsNull() {
            addCriterion("backid is null");
            return (Criteria) this;
        }

        public Criteria andBackidIsNotNull() {
            addCriterion("backid is not null");
            return (Criteria) this;
        }

        public Criteria andBackidEqualTo(Integer value) {
            addCriterion("backid =", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotEqualTo(Integer value) {
            addCriterion("backid <>", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidGreaterThan(Integer value) {
            addCriterion("backid >", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidGreaterThanOrEqualTo(Integer value) {
            addCriterion("backid >=", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidLessThan(Integer value) {
            addCriterion("backid <", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidLessThanOrEqualTo(Integer value) {
            addCriterion("backid <=", value, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidIn(List<Integer> values) {
            addCriterion("backid in", values, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotIn(List<Integer> values) {
            addCriterion("backid not in", values, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidBetween(Integer value1, Integer value2) {
            addCriterion("backid between", value1, value2, "backid");
            return (Criteria) this;
        }

        public Criteria andBackidNotBetween(Integer value1, Integer value2) {
            addCriterion("backid not between", value1, value2, "backid");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andHaoidIsNull() {
            addCriterion("haoid is null");
            return (Criteria) this;
        }

        public Criteria andHaoidIsNotNull() {
            addCriterion("haoid is not null");
            return (Criteria) this;
        }

        public Criteria andHaoidEqualTo(Integer value) {
            addCriterion("haoid =", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidNotEqualTo(Integer value) {
            addCriterion("haoid <>", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidGreaterThan(Integer value) {
            addCriterion("haoid >", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("haoid >=", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidLessThan(Integer value) {
            addCriterion("haoid <", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidLessThanOrEqualTo(Integer value) {
            addCriterion("haoid <=", value, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidIn(List<Integer> values) {
            addCriterion("haoid in", values, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidNotIn(List<Integer> values) {
            addCriterion("haoid not in", values, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidBetween(Integer value1, Integer value2) {
            addCriterion("haoid between", value1, value2, "haoid");
            return (Criteria) this;
        }

        public Criteria andHaoidNotBetween(Integer value1, Integer value2) {
            addCriterion("haoid not between", value1, value2, "haoid");
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