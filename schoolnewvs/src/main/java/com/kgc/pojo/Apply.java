package com.kgc.pojo;

import java.util.Date;

public class Apply {
    private Integer appid;

    private Integer aid;

    private Integer teacherid;

    private String appnei;

    private Integer apptype;

    private Date appdate;

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getAppnei() {
        return appnei;
    }

    public void setAppnei(String appnei) {
        this.appnei = appnei == null ? null : appnei.trim();
    }

    public Integer getApptype() {
        return apptype;
    }

    public void setApptype(Integer apptype) {
        this.apptype = apptype;
    }

    public Date getAppdate() {
        return appdate;
    }

    public void setAppdate(Date appdate) {
        this.appdate = appdate;
    }
}