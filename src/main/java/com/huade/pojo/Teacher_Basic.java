package com.huade.pojo;

public class Teacher_Basic {

    private String user_Id;
    private String college_Id;
    private String specialty_Id;

    @Override
    public String toString() {
        return "Teacher_Basic{" +
                "user_Id='" + user_Id + '\'' +
                ", college_Id='" + college_Id + '\'' +
                ", specialty_Id='" + specialty_Id + '\'' +
                '}';
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getCollege_Id() {
        return college_Id;
    }

    public void setCollege_Id(String college_Id) {
        this.college_Id = college_Id;
    }

    public String getSpecialty_Id() {
        return specialty_Id;
    }

    public void setSpecialty_Id(String specialty_Id) {
        this.specialty_Id = specialty_Id;
    }

    public Teacher_Basic(String user_Id, String college_Id, String specialty_Id) {
        this.user_Id = user_Id;
        this.college_Id = college_Id;
        this.specialty_Id = specialty_Id;
    }
}
