package com.huade.pojo;

public class View_Question_Info {

    private String Id;
    private String cou_Name;
    private String type_Name;
    private String subject;
    private String choice_A;
    private String choice_B;
    private String choice_C;
    private String choice_D;
    private String answer;
    private String degree;
    private String kwl_Name;
    private String analysis;

    @Override
    public String toString() {
        return "View_Question_Info{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", type_Name='" + type_Name + '\'' +
                ", subject='" + subject + '\'' +
                ", choice_A='" + choice_A + '\'' +
                ", choice_B='" + choice_B + '\'' +
                ", choice_C='" + choice_C + '\'' +
                ", choice_D='" + choice_D + '\'' +
                ", answer='" + answer + '\'' +
                ", degree='" + degree + '\'' +
                ", kwl_Name='" + kwl_Name + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Name() {
        return cou_Name;
    }

    public void setCou_Name(String cou_Name) {
        this.cou_Name = cou_Name;
    }

    public String getType_Name() {
        return type_Name;
    }

    public void setType_Name(String type_Name) {
        this.type_Name = type_Name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChoice_A() {
        return choice_A;
    }

    public void setChoice_A(String choice_A) {
        this.choice_A = choice_A;
    }

    public String getChoice_B() {
        return choice_B;
    }

    public void setChoice_B(String choice_B) {
        this.choice_B = choice_B;
    }

    public String getChoice_C() {
        return choice_C;
    }

    public void setChoice_C(String choice_C) {
        this.choice_C = choice_C;
    }

    public String getChoice_D() {
        return choice_D;
    }

    public void setChoice_D(String choice_D) {
        this.choice_D = choice_D;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getKwl_Name() {
        return kwl_Name;
    }

    public void setKwl_Name(String kwl_Name) {
        this.kwl_Name = kwl_Name;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public View_Question_Info(String id, String cou_Name, String type_Name, String subject, String choice_A, String choice_B, String choice_C, String choice_D, String answer, String degree, String kwl_Name, String analysis) {
        Id = id;
        this.cou_Name = cou_Name;
        this.type_Name = type_Name;
        this.subject = subject;
        this.choice_A = choice_A;
        this.choice_B = choice_B;
        this.choice_C = choice_C;
        this.choice_D = choice_D;
        this.answer = answer;
        this.degree = degree;
        this.kwl_Name = kwl_Name;
        this.analysis = analysis;
    }
}
