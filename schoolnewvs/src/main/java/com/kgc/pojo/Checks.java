package com.kgc.pojo;

import java.util.Date;

public class Checks {
    private Integer chid;

    private Integer aid;

    private Date signindate;

    private Date signoutdate;

    private String remark;

    private Integer chtype;

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getSignindate() {
        return signindate;
    }

    public void setSignindate(Date signindate) {
        this.signindate = signindate;
    }

    public Date getSignoutdate() {
        return signoutdate;
    }

    public void setSignoutdate(Date signoutdate) {
        this.signoutdate = signoutdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getChtype() {
        return chtype;
    }

    public void setChtype(Integer chtype) {
        this.chtype = chtype;
    }
}