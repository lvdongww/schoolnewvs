package com.kgc.pojo;

public class GradeUser {
    private Integer guid;

    private Integer gradeid;

    private Integer userid;

    private UserInfo userInfo;


    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {

        this.userid = userid;
    }

    @Override
    public String toString() {
        return "GradeUser{" +
                "guid=" + guid +
                ", gradeid=" + gradeid +
                ", userid=" + userid +
                ", userInfo=" + userInfo +
                '}';
    }
}