package com.huade.pojo;

public class Course {

    private String Id;
    private String cou_Name;

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
    }

    public Course(String id, String cou_Name) {
        Id = id;
        this.cou_Name = cou_Name;
    }
}
