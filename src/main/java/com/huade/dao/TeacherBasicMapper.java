package com.huade.dao;

import com.huade.pojo.Teacher_Basic;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherBasicMapper {
    
    int addTeacherBasicInfo(Teacher_Basic teacher_basic);

    int batchAddTeacherBasicInfo(List<Map<String ,Object>> teacherBasicList) throws Exception;


    int deleteTeacherBasicInfo(@Param("user_Id")String user_Id);
    
    int updateTeacherBasicInfo(Teacher_Basic teacher_basic);
    
    List<Teacher_Basic> selectAllTeacherBasic(@Param("current")int current,@Param("length") int length);
    
    List<Teacher_Basic> selectTeacherBasic(@Param("user_Id")String user_Id,
                                           @Param("col_Id")String col_Id,
                                           @Param("spe_Id")String spe_Id,
                                           @Param("current")int current,@Param("length") int length);
    
}
