package com.huade.pojo;

public class ClassCourseInfo {

    private String classes_Id;
    private String user_Id;
    private String cou_Id;

    @Override
    public String toString() {
        return "ClassCourseInfo{" +
                "classes_Id='" + classes_Id + '\'' +
                ", user_Id='" + user_Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                '}';
    }

    public String getClasses_Id() {
        return classes_Id;
    }

    public void setClasses_Id(String classes_Id) {
        this.classes_Id = classes_Id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public ClassCourseInfo(String classes_Id, String user_Id, String cou_Id) {
        this.classes_Id = classes_Id;
        this.user_Id = user_Id;
        this.cou_Id = cou_Id;
    }
}
