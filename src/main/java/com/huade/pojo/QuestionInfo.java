package com.huade.pojo;

public class QuestionInfo {

    private String Id;
    private String cou_Id;
    private String type_Id;
    private String subject;
    private String choice_A;
    private String choice_B;
    private String choice_C;
    private String choice_D;
    private String answer;
    private String degree;
    private String kwl_Id;
    private String analysis;

    @Override
    public String toString() {
        return "QuestionInfo{" +
                "Id='" + Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", type_Id='" + type_Id + '\'' +
                ", subject='" + subject + '\'' +
                ", choice_A='" + choice_A + '\'' +
                ", choice_B='" + choice_B + '\'' +
                ", choice_C='" + choice_C + '\'' +
                ", choice_D='" + choice_D + '\'' +
                ", answer='" + answer + '\'' +
                ", degree='" + degree + '\'' +
                ", kwl_Id='" + kwl_Id + '\'' +
                ", analysis='" + analysis + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCou_Id() {
        return cou_Id;
    }

    public void setCou_Id(String cou_Id) {
        this.cou_Id = cou_Id;
    }

    public String getType_Id() {
        return type_Id;
    }

    public void setType_Id(String type_Id) {
        this.type_Id = type_Id;
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

    public String getKwl_Id() {
        return kwl_Id;
    }

    public void setKwl_Id(String kwl_Id) {
        this.kwl_Id = kwl_Id;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public QuestionInfo(String id, String cou_Id, String type_Id, String subject, String choice_A, String choice_B, String choice_C, String choice_D, String answer, String degree, String kwl_Id, String analysis) {
        Id = id;
        this.cou_Id = cou_Id;
        this.type_Id = type_Id;
        this.subject = subject;
        this.choice_A = choice_A;
        this.choice_B = choice_B;
        this.choice_C = choice_C;
        this.choice_D = choice_D;
        this.answer = answer;
        this.degree = degree;
        this.kwl_Id = kwl_Id;
        this.analysis = analysis;
    }
}
