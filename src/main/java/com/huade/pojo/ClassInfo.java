package com.huade.pojo;

public class ClassInfo {

    private String Id;
    private String class_Id;
    private String people_Num;
    private String class_Col_Id;
    private String class_Spe_Id;

    @Override
    public String toString() {
        return "ClassInfo{" +
                "Id='" + Id + '\'' +
                ", class_Id='" + class_Id + '\'' +
                ", people_Num='" + people_Num + '\'' +
                ", class_Col_Id='" + class_Col_Id + '\'' +
                ", class_Spe_Id='" + class_Spe_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getClass_Id() {
        return class_Id;
    }

    public void setClass_Id(String class_Id) {
        this.class_Id = class_Id;
    }

    public String getPeople_Num() {
        return people_Num;
    }

    public void setPeople_Num(String people_Num) {
        this.people_Num = people_Num;
    }

    public String getClass_Col_Id() {
        return class_Col_Id;
    }

    public void setClass_Col_Id(String class_Col_Id) {
        this.class_Col_Id = class_Col_Id;
    }

    public String getClass_Spe_Id() {
        return class_Spe_Id;
    }

    public void setClass_Spe_Id(String class_Spe_Id) {
        this.class_Spe_Id = class_Spe_Id;
    }

    public ClassInfo(String id, String class_Id, String people_Num, String class_Col_Id, String class_Spe_Id) {
        Id = id;
        this.class_Id = class_Id;
        this.people_Num = people_Num;
        this.class_Col_Id = class_Col_Id;
        this.class_Spe_Id = class_Spe_Id;
    }
}
