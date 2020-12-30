package com.huade.pojo;

public class User_Type {

    private String Id;
    private String user_Type;

    @Override
    public String toString() {
        return "User_Type{" +
                "Id='" + Id + '\'' +
                ", user_Type='" + user_Type + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type = user_Type;
    }

    public User_Type(String id, String user_Type) {
        Id = id;
        this.user_Type = user_Type;
    }
}
