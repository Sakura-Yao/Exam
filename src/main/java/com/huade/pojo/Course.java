package com.huade.pojo;

public class Course {

    private String Id;
    private String cou_Name;
    private String spe_Id;

    @Override
    public String toString() {
        return "Course{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", spe_Id='" + spe_Id + '\'' +
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

    public String getSpe_Id() {
        return spe_Id;
    }

    public void setSpe_Id(String spe_Id) {
        this.spe_Id = spe_Id;
    }

    public Course(String id, String cou_Name, String spe_Id) {
        Id = id;
        this.cou_Name = cou_Name;
        this.spe_Id = spe_Id;
    }
}
