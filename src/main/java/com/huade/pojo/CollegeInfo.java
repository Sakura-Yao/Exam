package com.huade.pojo;

public class CollegeInfo {

    private String Id;
    private String col_Name;

    @Override
    public String toString() {
        return "CollegeInfo{" +
                "Id='" + Id + '\'' +
                ", col_Name='" + col_Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCol_Name() {
        return col_Name;
    }

    public void setCol_Name(String col_Name) {
        this.col_Name = col_Name;
    }

    public CollegeInfo(String id, String col_Name) {
        Id = id;
        this.col_Name = col_Name;
    }
}
