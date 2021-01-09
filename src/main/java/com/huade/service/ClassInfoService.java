package com.huade.service;

import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;

import java.util.List;
import java.util.Map;

public interface ClassInfoService {

    int addClassInfo (ClassInfo classInfo);

    int batchAddClassInfo(List<Map<String ,Object>> classInfoList) throws Exception;

    int updateClassInfo (ClassInfo classInfo);

    int deleteClassInfo (String Id);

    List<View_ClassInfo> selectAllClassInfo();

    List<ClassInfo> selectClassInfo(String Id,String col_Id,String spe_Id,int current,int length);

    String selectId(String class_Id);


}
