package com.huade.pojo;

public class Error_Question {

    private String Id;
    private String user_Id;
    private String question_Id;

    @Override
    public String toString() {
        return "Error_Question{" +
                "Id='" + Id + '\'' +
                ", user_Id='" + user_Id + '\'' +
                ", question_Id='" + question_Id + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getQuestion_Id() {
        return question_Id;
    }

    public void setQuestion_Id(String question_Id) {
        this.question_Id = question_Id;
    }

    public Error_Question(String id, String user_Id, String question_Id) {
        Id = id;
        this.user_Id = user_Id;
        this.question_Id = question_Id;
    }
}
