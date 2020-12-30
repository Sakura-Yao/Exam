package com.huade.pojo;

public class User {

    private String user_Id;
    private String password;
    private String user_Name;
    private String user_Type;
    private String user_Sex;
    private String user_Mobile;

    @Override
    public String toString() {
        return "User{" +
                "user_Id='" + user_Id + '\'' +
                ", password='" + password + '\'' +
                ", user_Name='" + user_Name + '\'' +
                ", user_Type='" + user_Type + '\'' +
                ", user_Sex='" + user_Sex + '\'' +
                ", user_Mobile='" + user_Mobile + '\'' +
                '}';
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getUser_Type() {
        return user_Type;
    }

    public void setUser_Type(String user_Type) {
        this.user_Type = user_Type;
    }

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }

    public String getUser_Mobile() {
        return user_Mobile;
    }

    public void setUser_Mobile(String user_Mobile) {
        this.user_Mobile = user_Mobile;
    }

    public User(String user_Id, String password, String user_Name, String user_Type, String user_Sex, String user_Mobile) {
        this.user_Id = user_Id;
        this.password = password;
        this.user_Name = user_Name;
        this.user_Type = user_Type;
        this.user_Sex = user_Sex;
        this.user_Mobile = user_Mobile;
    }
}
