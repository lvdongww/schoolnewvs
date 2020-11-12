package com.kgc.pojo;

import java.util.Date;

public class ExamScore {
    private Integer scoreid;

    private Integer userid;

    private Integer paperid;

    private Integer pgid;

    private Integer score;

    private Integer rights;

    private Integer errors;

    private Date subtime;

    public ExamScore() {
    }

    public ExamScore(Integer scoreid, Integer userid, Integer paperid, Integer score, Integer rights, Integer errors) {
        this.scoreid = scoreid;
        this.userid = userid;
        this.paperid = paperid;
        this.score = score;
        this.rights = rights;
        this.errors = errors;
    }


    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getPgid() {
        return pgid;
    }

    public void setPgid(Integer pgid) {
        this.pgid = pgid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getRights() {
        return rights;
    }

    public void setRights(Integer rights) {
        this.rights = rights;
    }

    public Integer getErrors() {
        return errors;
    }

    public void setErrors(Integer errors) {
        this.errors = errors;
    }

    public Date getSubtime() {
        return subtime;
    }

    public void setSubtime(Date subtime) {
        this.subtime = subtime;
    }
}