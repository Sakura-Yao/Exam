package com.huade.pojo;

public class Specialty {

    private String Id;
    private String spe_Name;
    private String col_Id;

    @Override
    public String toString() {
        return "Specialty{" +
                "Id='" + Id + '\'' +
                ", spe_Name='" + spe_Name + '\'' +
                ", col_Id='" + col_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getSpe_Name() {
        return spe_Name;
    }

    public void setSpe_Name(String spe_Name) {
        this.spe_Name = spe_Name;
    }

    public String getCol_Id() {
        return col_Id;
    }

    public void setCol_Id(String col_Id) {
        this.col_Id = col_Id;
    }

    public Specialty(String id, String spe_Name, String col_Id) {
        Id = id;
        this.spe_Name = spe_Name;
        this.col_Id = col_Id;
    }
}
