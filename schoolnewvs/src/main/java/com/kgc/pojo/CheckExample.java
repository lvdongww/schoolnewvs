package com.kgc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckExample() {
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

        public Criteria andChidIsNull() {
            addCriterion("chid is null");
            return (Criteria) this;
        }

        public Criteria andChidIsNotNull() {
            addCriterion("chid is not null");
            return (Criteria) this;
        }

        public Criteria andChidEqualTo(Integer value) {
            addCriterion("chid =", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidNotEqualTo(Integer value) {
            addCriterion("chid <>", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidGreaterThan(Integer value) {
            addCriterion("chid >", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidGreaterThanOrEqualTo(Integer value) {
            addCriterion("chid >=", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidLessThan(Integer value) {
            addCriterion("chid <", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidLessThanOrEqualTo(Integer value) {
            addCriterion("chid <=", value, "chid");
            return (Criteria) this;
        }

        public Criteria andChidIn(List<Integer> values) {
            addCriterion("chid in", values, "chid");
            return (Criteria) this;
        }

        public Criteria andChidNotIn(List<Integer> values) {
            addCriterion("chid not in", values, "chid");
            return (Criteria) this;
        }

        public Criteria andChidBetween(Integer value1, Integer value2) {
            addCriterion("chid between", value1, value2, "chid");
            return (Criteria) this;
        }

        public Criteria andChidNotBetween(Integer value1, Integer value2) {
            addCriterion("chid not between", value1, value2, "chid");
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

        public Criteria andSignindateIsNull() {
            addCriterion("signindate is null");
            return (Criteria) this;
        }

        public Criteria andSignindateIsNotNull() {
            addCriterion("signindate is not null");
            return (Criteria) this;
        }

        public Criteria andSignindateEqualTo(Date value) {
            addCriterion("signindate =", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotEqualTo(Date value) {
            addCriterion("signindate <>", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateGreaterThan(Date value) {
            addCriterion("signindate >", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateGreaterThanOrEqualTo(Date value) {
            addCriterion("signindate >=", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateLessThan(Date value) {
            addCriterion("signindate <", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateLessThanOrEqualTo(Date value) {
            addCriterion("signindate <=", value, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateIn(List<Date> values) {
            addCriterion("signindate in", values, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotIn(List<Date> values) {
            addCriterion("signindate not in", values, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateBetween(Date value1, Date value2) {
            addCriterion("signindate between", value1, value2, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignindateNotBetween(Date value1, Date value2) {
            addCriterion("signindate not between", value1, value2, "signindate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateIsNull() {
            addCriterion("signoutdate is null");
            return (Criteria) this;
        }

        public Criteria andSignoutdateIsNotNull() {
            addCriterion("signoutdate is not null");
            return (Criteria) this;
        }

        public Criteria andSignoutdateEqualTo(Date value) {
            addCriterion("signoutdate =", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateNotEqualTo(Date value) {
            addCriterion("signoutdate <>", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateGreaterThan(Date value) {
            addCriterion("signoutdate >", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateGreaterThanOrEqualTo(Date value) {
            addCriterion("signoutdate >=", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateLessThan(Date value) {
            addCriterion("signoutdate <", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateLessThanOrEqualTo(Date value) {
            addCriterion("signoutdate <=", value, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateIn(List<Date> values) {
            addCriterion("signoutdate in", values, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateNotIn(List<Date> values) {
            addCriterion("signoutdate not in", values, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateBetween(Date value1, Date value2) {
            addCriterion("signoutdate between", value1, value2, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andSignoutdateNotBetween(Date value1, Date value2) {
            addCriterion("signoutdate not between", value1, value2, "signoutdate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andChtypeIsNull() {
            addCriterion("chtype is null");
            return (Criteria) this;
        }

        public Criteria andChtypeIsNotNull() {
            addCriterion("chtype is not null");
            return (Criteria) this;
        }

        public Criteria andChtypeEqualTo(Integer value) {
            addCriterion("chtype =", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeNotEqualTo(Integer value) {
            addCriterion("chtype <>", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeGreaterThan(Integer value) {
            addCriterion("chtype >", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("chtype >=", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeLessThan(Integer value) {
            addCriterion("chtype <", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeLessThanOrEqualTo(Integer value) {
            addCriterion("chtype <=", value, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeIn(List<Integer> values) {
            addCriterion("chtype in", values, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeNotIn(List<Integer> values) {
            addCriterion("chtype not in", values, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeBetween(Integer value1, Integer value2) {
            addCriterion("chtype between", value1, value2, "chtype");
            return (Criteria) this;
        }

        public Criteria andChtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("chtype not between", value1, value2, "chtype");
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