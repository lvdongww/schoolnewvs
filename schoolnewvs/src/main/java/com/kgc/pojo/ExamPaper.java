package com.kgc.pojo;

import java.util.Date;
import java.util.List;

public class ExamPaper {
    private Integer paperid;

    private String papername;

    private String papertype;

    private String method;

    private String remarks;

    private Date createTime;

    private PaperGrade paperGrade;

    private List<ExamScore> scoreList;

    public PaperGrade getPaperGrade() {
        return paperGrade;
    }

    public void setPaperGrade(PaperGrade paperGrade) {
        this.paperGrade = paperGrade;
    }

    public List<ExamScore> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<ExamScore> scoreList) {
        this.scoreList = scoreList;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername == null ? null : papername.trim();
    }

    public String getPapertype() {
        return papertype;
    }

    public void setPapertype(String papertype) {
        this.papertype = papertype == null ? null : papertype.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}