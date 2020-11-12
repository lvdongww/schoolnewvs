package com.kgc.pojo;

public class ExamScoreDetail {
    private Integer detailid;

    private Integer scoreid;

    private Integer eid;

    private String uanswer;

    private Integer upoint;

    private ExamScore examScore;

    public ExamScore getExamScore() {
        return examScore;
    }

    public void setExamScore(ExamScore examScore) {
        this.examScore = examScore;
    }

    @Override
    public String toString() {
        return "ExamScoreDetail{" +
                "detailid=" + detailid +
                ", scoreid=" + scoreid +
                ", eid=" + eid +
                ", uanswer='" + uanswer + '\'' +
                ", upoint=" + upoint +
                '}';
    }

    public ExamScoreDetail() {
    }

    public ExamScoreDetail(Integer detailid, Integer scoreid, Integer eid, String uanswer, Integer upoint) {
        this.detailid = detailid;
        this.scoreid = scoreid;
        this.eid = eid;
        this.uanswer = uanswer;
        this.upoint = upoint;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Integer getScoreid() {
        return scoreid;
    }

    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getUanswer() {
        return uanswer;
    }

    public void setUanswer(String uanswer) {
        this.uanswer = uanswer == null ? null : uanswer.trim();
    }

    public Integer getUpoint() {
        return upoint;
    }

    public void setUpoint(Integer upoint) {
        this.upoint = upoint;
    }
}