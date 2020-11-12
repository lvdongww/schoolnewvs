package com.kgc.pojo;

import java.util.Date;

public class Timetable {
    private Integer tid;

    private Integer gid;

    private Date tsignindate;

    private Date tsignoutdate;

    private String rest;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Date getTsignindate() {
        return tsignindate;
    }

    public void setTsignindate(Date tsignindate) {
        this.tsignindate = tsignindate;
    }

    public Date getTsignoutdate() {
        return tsignoutdate;
    }

    public void setTsignoutdate(Date tsignoutdate) {
        this.tsignoutdate = tsignoutdate;
    }

    public String getRest() {
        return rest;
    }

    public void setRest(String rest) {
        this.rest = rest == null ? null : rest.trim();
    }
}