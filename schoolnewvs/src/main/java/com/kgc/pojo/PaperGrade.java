package com.kgc.pojo;

import java.util.Date;

public class PaperGrade {
    private Integer pgid;

    private Integer pid;

    private Integer gid;

    private Date startTime;

    private Date stopTime;

    private Integer pgtype;

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