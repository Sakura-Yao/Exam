package com.huade.service;

import com.huade.pojo.Student_Basic;
import com.huade.pojo.View_StudentBasicInfo;

import java.util.List;
import java.util.Map;

public interface StudentBasicService {

    int addStudentBasic(Student_Basic student_basic);

    int deleteStudentBasic(String user_Id);

    int updateStudentBasic(Student_Basic student_basic);

    List<Student_Basic> selectAllStudentBasic();

    List<View_StudentBasicInfo> selectStudentBasic(String user_Id,String user_Name,String class_Id, String col_Id, String spe_Id,
                                                   int current, int length);

    int batchAddStudentBasicInfo(List<Map<String ,Object>> studentBasicList) throws Exception;


}
