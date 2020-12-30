package com.huade.pojo;

public class Question_Type {

    private String Id;
    private String type_Name;

    @Override
    public String toString() {
        return "Question_Type{" +
                "Id='" + Id + '\'' +
                ", type_Name='" + type_Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType_Name() {
        return type_Name;
    }

    public void setType_Name(String type_Name) {
        this.type_Name = type_Name;
    }

    public Question_Type(String id, String type_Name) {
        Id = id;
        this.type_Name = type_Name;
    }
}
