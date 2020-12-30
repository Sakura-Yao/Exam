package com.huade.pojo;

public class View_Teacher_Class_Info {

    private String user_Id;
    private String user_Name;
    private String classes_Id;
    private String class_Id;
    private String cou_Id;
    private String cou_Name;

    @Override
    public String toString() {
        return "View_Teacher_Class_Info{" +
                "user_Id='" + user_Id + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", classes_Id='" + classes_Id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                '}';
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getClasses_Id() {
        return classes_Id;
    }

    public void setClasses_Id(String classes_Id) {
        this.classes_Id = classes_Id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public View_Teacher_Class_Info(String user_Id, String user_Name, String classes_Id, String class_Id, String cou_Id, String cou_Name) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.classes_Id = classes_Id;
        this.class_Id = class_Id;
        this.cou_Id = cou_Id;
        this.cou_Name = cou_Name;
    }
}
