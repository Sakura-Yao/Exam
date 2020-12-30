package com.huade.pojo;

public class View_StudentBasicInfo {

    private String user_Id;
    private String user_Name;
    private String class_Id;
    private String col_Name;
    private String spe_Name;

    @Override
    public String toString() {
        return "View_StudentBasicInfo{" +
                "user_Id='" + user_Id + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                '}';
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

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getCol_Name() {
        return col_Name;
    }

    public void setCol_Name(String col_Name) {
        this.col_Name = col_Name;
    }

    public String getSpe_Name() {
        return spe_Name;
    }

    public void setSpe_Name(String spe_Name) {
        this.spe_Name = spe_Name;
    }

    public View_StudentBasicInfo(String user_Id, String user_Name, String class_Id, String col_Name, String spe_Name) {
        this.user_Id = user_Id;
        this.user_Name = user_Name;
        this.class_Id = class_Id;
        this.col_Name = col_Name;
        this.spe_Name = spe_Name;
    }
}
