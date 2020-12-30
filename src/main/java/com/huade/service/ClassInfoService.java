package com.huade.service;

import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;

import java.util.List;

public interface ClassInfoService {

    int addClassInfo (ClassInfo classInfo);

    int updateClassInfo (ClassInfo classInfo);

    int deleteClassInfo (String Id);

    List<View_ClassInfo> selectAllClassInfo();

    List<ClassInfo> selectClassInfo(String col_Id,String spe_Id,int current,int length);

    String selectId(String class_Id);


}
