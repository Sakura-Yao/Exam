package com.huade.pojo;

public class Exam_Paper {

    private String Id;
    private String exam_Id;
    private String question_Id;
    private String score;

    @Override
    public String toString() {
        return "Exam_Paper{" +
                "Id='" + Id + '\'' +
                ", exam_Id='" + exam_Id + '\'' +
                ", question_Id='" + question_Id + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExam_Id() {
        return exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        this.exam_Id = exam_Id;
    }

    public String getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(String question_Id) {
        this.question_Id = question_Id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Exam_Paper() {
    }

    public Exam_Paper(String id, String exam_Id, String question_Id, String score) {
        Id = id;
        this.exam_Id = exam_Id;
        this.question_Id = question_Id;
        this.score = score;
    }
}
