package com.huade.pojo;

public class Exam_Generate {

    private String Id;
    private String exam_Plan_Id;
    private String exam_Id;

    @Override
    public String toString() {
        return "Exam_Generate{" +
                "Id='" + Id + '\'' +
                ", exam_Plan_Id='" + exam_Plan_Id + '\'' +
                ", exam_Id='" + exam_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExam_Plan_Id() {
        return exam_Plan_Id;
    }

    public void setExam_Plan_Id(String exam_Plan_Id) {
        this.exam_Plan_Id = exam_Plan_Id;
    }

    public String getExam_Id() {
        return exam_Id;
    }

    public void setExam_Id(String exam_Id) {
        this.exam_Id = exam_Id;
    }

    public Exam_Generate(String id, String exam_Plan_Id, String exam_Id) {
        Id = id;
        this.exam_Plan_Id = exam_Plan_Id;
        this.exam_Id = exam_Id;
    }

    public Exam_Generate() {
    }
}
