package com.huade.pojo;

public class View_CourseInfo {

    private String Id;
    private String cou_Name;
    private String spe_Name;

    @Override
    public String toString() {
        return "View_CourseInfo{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
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

    public String getSpe_Name() {
        return spe_Name;
    }

    public void setSpe_Name(String spe_Name) {
        this.spe_Name = spe_Name;
    }

    public View_CourseInfo(String id, String cou_Name, String spe_Name) {
        Id = id;
        this.cou_Name = cou_Name;
        this.spe_Name = spe_Name;
    }
}
