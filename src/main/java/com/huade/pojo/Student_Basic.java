package com.huade.pojo;

public class Student_Basic {

    private String user_Id;
    private String stu_ClassId;
    private String stu_College;
    private String stu_Specialty;

    @Override
    public String toString() {
        return "Student_Basic{" +
                "user_Id='" + user_Id + '\'' +
                ", stu_ClassId='" + stu_ClassId + '\'' +
                ", stu_College='" + stu_College + '\'' +
                ", stu_Specialty='" + stu_Specialty + '\'' +
                '}';
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getStu_ClassId() {
        return stu_ClassId;
    }

    public void setStu_ClassId(String stu_ClassId) {
        this.stu_ClassId = stu_ClassId;
    }

    public String getStu_College() {
        return stu_College;
    }

    public void setStu_College(String stu_College) {
        this.stu_College = stu_College;
    }

    public String getStu_Specialty() {
        return stu_Specialty;
    }

    public void setStu_Specialty(String stu_Specialty) {
        this.stu_Specialty = stu_Specialty;
    }

    public Student_Basic(String user_Id, String stu_ClassId, String stu_College, String stu_Specialty) {
        this.user_Id = user_Id;
        this.stu_ClassId = stu_ClassId;
        this.stu_College = stu_College;
        this.stu_Specialty = stu_Specialty;
    }
}
