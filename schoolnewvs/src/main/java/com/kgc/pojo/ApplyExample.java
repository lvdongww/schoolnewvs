package com.kgc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyExample() {
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

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(Integer value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(Integer value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(Integer value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(Integer value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(Integer value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(Integer value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<Integer> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<Integer> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(Integer value1, Integer value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(Integer value1, Integer value2) {
            addCriterion("appid not between", value1, value2, "appid");
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

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherid is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherid =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherid <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherid >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherid >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherid <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherid <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherid in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherid not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherid between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherid not between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andAppneiIsNull() {
            addCriterion("appnei is null");
            return (Criteria) this;
        }

        public Criteria andAppneiIsNotNull() {
            addCriterion("appnei is not null");
            return (Criteria) this;
        }

        public Criteria andAppneiEqualTo(String value) {
            addCriterion("appnei =", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiNotEqualTo(String value) {
            addCriterion("appnei <>", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiGreaterThan(String value) {
            addCriterion("appnei >", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiGreaterThanOrEqualTo(String value) {
            addCriterion("appnei >=", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiLessThan(String value) {
            addCriterion("appnei <", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiLessThanOrEqualTo(String value) {
            addCriterion("appnei <=", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiLike(String value) {
            addCriterion("appnei like", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiNotLike(String value) {
            addCriterion("appnei not like", value, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiIn(List<String> values) {
            addCriterion("appnei in", values, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiNotIn(List<String> values) {
            addCriterion("appnei not in", values, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiBetween(String value1, String value2) {
            addCriterion("appnei between", value1, value2, "appnei");
            return (Criteria) this;
        }

        public Criteria andAppneiNotBetween(String value1, String value2) {
            addCriterion("appnei not between", value1, value2, "appnei");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNull() {
            addCriterion("apptype is null");
            return (Criteria) this;
        }

        public Criteria andApptypeIsNotNull() {
            addCriterion("apptype is not null");
            return (Criteria) this;
        }

        public Criteria andApptypeEqualTo(Integer value) {
            addCriterion("apptype =", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotEqualTo(Integer value) {
            addCriterion("apptype <>", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThan(Integer value) {
            addCriterion("apptype >", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("apptype >=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThan(Integer value) {
            addCriterion("apptype <", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeLessThanOrEqualTo(Integer value) {
            addCriterion("apptype <=", value, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeIn(List<Integer> values) {
            addCriterion("apptype in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotIn(List<Integer> values) {
            addCriterion("apptype not in", values, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeBetween(Integer value1, Integer value2) {
            addCriterion("apptype between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andApptypeNotBetween(Integer value1, Integer value2) {
            addCriterion("apptype not between", value1, value2, "apptype");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNull() {
            addCriterion("appdate is null");
            return (Criteria) this;
        }

        public Criteria andAppdateIsNotNull() {
            addCriterion("appdate is not null");
            return (Criteria) this;
        }

        public Criteria andAppdateEqualTo(Date value) {
            addCriterion("appdate =", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotEqualTo(Date value) {
            addCriterion("appdate <>", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThan(Date value) {
            addCriterion("appdate >", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateGreaterThanOrEqualTo(Date value) {
            addCriterion("appdate >=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThan(Date value) {
            addCriterion("appdate <", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateLessThanOrEqualTo(Date value) {
            addCriterion("appdate <=", value, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateIn(List<Date> values) {
            addCriterion("appdate in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotIn(List<Date> values) {
            addCriterion("appdate not in", values, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateBetween(Date value1, Date value2) {
            addCriterion("appdate between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppdateNotBetween(Date value1, Date value2) {
            addCriterion("appdate not between", value1, value2, "appdate");
            return (Criteria) this;
        }

        public Criteria andAppcountIsNull() {
            addCriterion("appcount is null");
            return (Criteria) this;
        }

        public Criteria andAppcountIsNotNull() {
            addCriterion("appcount is not null");
            return (Criteria) this;
        }

        public Criteria andAppcountEqualTo(Integer value) {
            addCriterion("appcount =", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountNotEqualTo(Integer value) {
            addCriterion("appcount <>", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountGreaterThan(Integer value) {
            addCriterion("appcount >", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("appcount >=", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountLessThan(Integer value) {
            addCriterion("appcount <", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountLessThanOrEqualTo(Integer value) {
            addCriterion("appcount <=", value, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountIn(List<Integer> values) {
            addCriterion("appcount in", values, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountNotIn(List<Integer> values) {
            addCriterion("appcount not in", values, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountBetween(Integer value1, Integer value2) {
            addCriterion("appcount between", value1, value2, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcountNotBetween(Integer value1, Integer value2) {
            addCriterion("appcount not between", value1, value2, "appcount");
            return (Criteria) this;
        }

        public Criteria andAppcrudateIsNull() {
            addCriterion("appcrudate is null");
            return (Criteria) this;
        }

        public Criteria andAppcrudateIsNotNull() {
            addCriterion("appcrudate is not null");
            return (Criteria) this;
        }

        public Criteria andAppcrudateEqualTo(Date value) {
            addCriterion("appcrudate =", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateNotEqualTo(Date value) {
            addCriterion("appcrudate <>", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateGreaterThan(Date value) {
            addCriterion("appcrudate >", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateGreaterThanOrEqualTo(Date value) {
            addCriterion("appcrudate >=", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateLessThan(Date value) {
            addCriterion("appcrudate <", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateLessThanOrEqualTo(Date value) {
            addCriterion("appcrudate <=", value, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateIn(List<Date> values) {
            addCriterion("appcrudate in", values, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateNotIn(List<Date> values) {
            addCriterion("appcrudate not in", values, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateBetween(Date value1, Date value2) {
            addCriterion("appcrudate between", value1, value2, "appcrudate");
            return (Criteria) this;
        }

        public Criteria andAppcrudateNotBetween(Date value1, Date value2) {
            addCriterion("appcrudate not between", value1, value2, "appcrudate");
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