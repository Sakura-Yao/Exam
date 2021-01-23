package com.huade.pojo;

public class QuestionTimes {

    private String question_Id;
    private Integer times;

    @Override
    public String toString() {
        return "QuestionTimes{" +
                "question_Id='" + question_Id + '\'' +
                ", times=" + times +
                '}';
    }

    public String getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(String question_Id) {
        this.question_Id = question_Id;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public QuestionTimes(String question_Id, Integer times) {
        this.question_Id = question_Id;
        this.times = times;
    }
}
