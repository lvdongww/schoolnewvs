package com.kgc.pojo;

public class Timetable {
    private Integer tid;

    private Integer gid;

    private String tsignindate;

    private String tsignoutdate;

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

    public String getTsignindate() {
        return tsignindate;
    }

    public void setTsignindate(String tsignindate) {
        this.tsignindate = tsignindate == null ? null : tsignindate.trim();
    }

    public String getTsignoutdate() {
        return tsignoutdate;
    }

    public void setTsignoutdate(String tsignoutdate) {
        this.tsignoutdate = tsignoutdate == null ? null : tsignoutdate.trim();
    }
}