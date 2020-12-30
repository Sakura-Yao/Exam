package com.huade.pojo;

public class Test_Ueditor {

    private String Id;
    private String text;

    @Override
    public String toString() {
        return "test_ueditor{" +
                "Id='" + Id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Test_Ueditor(String id, String text) {
        Id = id;
        this.text = text;
    }
}
