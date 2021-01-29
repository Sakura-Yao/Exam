package com.huade.pojo;

import java.util.List;

/**
 * 组卷规则，考试大纲
 */
public class Rule {

    private String Id;
    private String examId;
    private String cou_Id;
    private double totalMark;
    private double difficulty;
    private int singleNum;
    private double singleScore;
    private int completeNum;
    private double completeScore;
    private int subjectNum;
    private double subjectScore;
    private List<String> pointIds;

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public int getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(int singleNum) {
        this.singleNum = singleNum;
    }

    public double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(double singleScore) {
        this.singleScore = singleScore;
    }

    public int getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(int completeNum) {
        this.completeNum = completeNum;
    }

    public double getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(double completeScore) {
        this.completeScore = completeScore;
    }

    public int getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(int subjectNum) {
        this.subjectNum = subjectNum;
    }

    public double getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(double subjectScore) {
        this.subjectScore = subjectScore;
    }

    public List<String> getPointIds() {
        return pointIds;
    }

    public void setPointIds(List<String> pointIds) {
        this.pointIds = pointIds;
    }

}
