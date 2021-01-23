package com.huade.pojo;

public class ExamPlan {

    private String Id;
    private String cou_Id;
    private String class_Id;
    private String mode;
    private String proposition_Teacher;
    private String time;
    private String col_Id;
    private String spe_Id;

    @Override
    public String toString() {
        return "ExamPlan{" +
                "Id='" + Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", mode='" + mode + '\'' +
                ", proposition_Teacher='" + proposition_Teacher + '\'' +
                ", time='" + time + '\'' +
                ", col_Id='" + col_Id + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getProposition_Teacher() {
        return proposition_Teacher;
    }

    public void setProposition_Teacher(String proposition_Teacher) {
        this.proposition_Teacher = proposition_Teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCol_Id() {
        return col_Id;
    }

    public void setCol_Id(String col_Id) {
        this.col_Id = col_Id;
    }

    public String getSpe_Id() {
        return spe_Id;
    }

    public void setSpe_Id(String spe_Id) {
        this.spe_Id = spe_Id;
    }

    public ExamPlan() {
    }

    public ExamPlan(String id, String cou_Id, String class_Id, String mode, String proposition_Teacher, String time, String col_Id, String spe_Id) {
        Id = id;
        this.cou_Id = cou_Id;
        this.class_Id = class_Id;
        this.mode = mode;
        this.proposition_Teacher = proposition_Teacher;
        this.time = time;
        this.col_Id = col_Id;
        this.spe_Id = spe_Id;
    }
}
