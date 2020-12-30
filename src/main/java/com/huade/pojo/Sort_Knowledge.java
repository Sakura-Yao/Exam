package com.huade.pojo;

public class Sort_Knowledge {

    private String Id;
    private String cou_Name;
    private Integer kwl_Level;
    private Integer chapter_Num;
    private Integer section_Num;
    private String kwl_Name;

    @Override
    public String toString() {
        return "Sort_Knowledge{" +
                "Id='" + Id + '\'' +
                ", cou_Name='" + cou_Name + '\'' +
                ", kwl_Level=" + kwl_Level +
                ", chapter_Num=" + chapter_Num +
                ", section_Num=" + section_Num +
                ", kwl_Name='" + kwl_Name + '\'' +
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

    public Integer getKwl_Level() {
        return kwl_Level;
    }

    public void setKwl_Level(Integer kwl_Level) {
        this.kwl_Level = kwl_Level;
    }

    public Integer getChapter_Num() {
        return chapter_Num;
    }

    public void setChapter_Num(Integer chapter_Num) {
        this.chapter_Num = chapter_Num;
    }

    public Integer getSection_Num() {
        return section_Num;
    }

    public void setSection_Num(Integer section_Num) {
        this.section_Num = section_Num;
    }

    public String getKwl_Name() {
        return kwl_Name;
    }

    public void setKwl_Name(String kwl_Name) {
        this.kwl_Name = kwl_Name;
    }

    public Sort_Knowledge(String id, String cou_Name, Integer kwl_Level, Integer chapter_Num, Integer section_Num, String kwl_Name) {
        Id = id;
        this.cou_Name = cou_Name;
        this.kwl_Level = kwl_Level;
        this.chapter_Num = chapter_Num;
        this.section_Num = section_Num;
        this.kwl_Name = kwl_Name;
    }
}
