package com.huade.service;

import com.huade.pojo.Teacher_Basic;

import java.util.List;
import java.util.Map;

public interface TeacherBasicService {

    int addTeacherBasicInfo(Teacher_Basic teacher_basic);

    int deleteTeacherBasicInfo(String user_Id);

    int updateTeacherBasicInfo(Teacher_Basic teacher_basic);

    List<Teacher_Basic> selectAllTeacherBasic(int current, int length);

    List<Teacher_Basic> selectTeacherBasic(String user_Id,String col_Id,String spe_Id,
                                           int current,int length);

    int batchAddTeacherBasicInfo(List<Map<String ,Object>> teacherBasicList) throws Exception;


}
