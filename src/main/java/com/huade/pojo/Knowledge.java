package com.huade.pojo;

public class Knowledge {

    private String Id;
    private String cou_Id;
    private String kwl_Level;
    private String chapter_Num;
    private String section_Num;
    private String kwl_Name;
    private String parent_Id;

    @Override
    public String toString() {
        return "Knowledge{" +
                "Id='" + Id + '\'' +
                ", cou_Id='" + cou_Id + '\'' +
                ", kwl_Level='" + kwl_Level + '\'' +
                ", chapter_Num='" + chapter_Num + '\'' +
                ", section_Num='" + section_Num + '\'' +
                ", kwl_Name='" + kwl_Name + '\'' +
                ", parent_Id='" + parent_Id + '\'' +
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

    public String getKwl_Level() {
        return kwl_Level;
    }

    public void setKwl_Level(String kwl_Level) {
        this.kwl_Level = kwl_Level;
    }

    public String getChapter_Num() {
        return chapter_Num;
    }

    public void setChapter_Num(String chapter_Num) {
        this.chapter_Num = chapter_Num;
    }

    public String getSection_Num() {
        return section_Num;
    }

    public void setSection_Num(String section_Num) {
        this.section_Num = section_Num;
    }

    public String getKwl_Name() {
        return kwl_Name;
    }

    public void setKwl_Name(String kwl_Name) {
        this.kwl_Name = kwl_Name;
    }

    public String getParent_Id() {
        return parent_Id;
    }

    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
    }

    public Knowledge(String id, String cou_Id, String kwl_Level, String chapter_Num, String section_Num, String kwl_Name, String parent_Id) {
        Id = id;
        this.cou_Id = cou_Id;
        this.kwl_Level = kwl_Level;
        this.chapter_Num = chapter_Num;
        this.section_Num = section_Num;
        this.kwl_Name = kwl_Name;
        this.parent_Id = parent_Id;
    }
}
