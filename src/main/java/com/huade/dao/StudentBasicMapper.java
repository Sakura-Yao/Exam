package com.huade.dao;

import com.huade.pojo.Student_Basic;
import com.huade.pojo.View_StudentBasicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentBasicMapper {
    
    int addStudentBasic(Student_Basic student_basic);

    int batchAddStudentBasicInfo(List<Map<String ,Object>> studentBasicList) throws Exception;


    int deleteStudentBasic(@Param("user_Id")String user_Id);
    
    int updateStudentBasic(Student_Basic student_basic);
    
    List<Student_Basic> selectAllStudentBasic();

    List<View_StudentBasicInfo> selectStudentBasic(@Param("user_Id")String user_Id,
                                                   @Param("user_Name")String user_Name,
                                                   @Param("class_Id")String class_Id,
                                                   @Param("col_Id")String col_Id,
                                                   @Param("spe_Id")String spe_Id,
                                                   @Param("current")int current,@Param("length") int length);
    
}
