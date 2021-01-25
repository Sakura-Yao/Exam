package com.huade.pojo;

import java.util.List;

/**
 * 组卷规则，考试大纲
 */
public class Rule {

    private String Id;
    private String examId;
    private double totalMark;
    private double difficulty;
    private String singleNum;
    private double singleScore;
    private String completeNum;
    private double completeScore;
    private String subjectNum;
    private double subjectScore;
    private List<String> pointIds;

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

    public String getSingleNum() {
        return singleNum;
    }

    public void setSingleNum(String singleNum) {
        this.singleNum = singleNum;
    }

    public double getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(double singleScore) {
        this.singleScore = singleScore;
    }

    public String getCompleteNum() {
        return completeNum;
    }

    public void setCompleteNum(String completeNum) {
        this.completeNum = completeNum;
    }

    public double getCompleteScore() {
        return completeScore;
    }

    public void setCompleteScore(double completeScore) {
        this.completeScore = completeScore;
    }

    public String getSubjectNum() {
        return subjectNum;
    }

    public void setSubjectNum(String subjectNum) {
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
