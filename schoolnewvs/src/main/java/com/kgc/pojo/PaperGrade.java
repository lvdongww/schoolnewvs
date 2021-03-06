package com.kgc.pojo;

import java.util.Date;

public class PaperGrade {
    private Integer pgid;

    private Integer pid;

    private Integer gid;

    private Date startTime;

    private Date stopTime;

    private Integer pgtype;

    private ExamPaper examPaper;

    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public PaperGrade() {
    }

    public PaperGrade(Integer pgid, Integer pid, Integer gid, Date startTime, Date stopTime, Integer pgtype) {
        this.pgid = pgid;
        this.pid = pid;
        this.gid = gid;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.pgtype = pgtype;
    }
    public PaperGrade( Integer pid, Integer gid, Date startTime, Date stopTime, Integer pgtype) {
        this.pid = pid;
        this.gid = gid;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.pgtype = pgtype;
    }

    @Override
    public String toString() {
        return "PaperGrade{" +
                "pgid=" + pgid +
                ", pid=" + pid +
                ", gid=" + gid +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                ", pgtype=" + pgtype +
                ", examPaper=" + examPaper +
                '}';
    }

    public ExamPaper getExamPaper() {
        return examPaper;
    }

    public void setExamPaper(ExamPaper examPaper) {
        this.examPaper = examPaper;
    }

    public Integer getPgid() {
        return pgid;
    }

    public void setPgid(Integer pgid) {
        this.pgid = pgid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getPgtype() {
        return pgtype;
    }

    public void setPgtype(Integer pgtype) {
        this.pgtype = pgtype;
    }
}