package com.huade.dao;

import com.huade.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CourseMapper {

    int addCourseInfo(Course course);

    int batchAddCourseInfo(List<Map<String,Object>> courseInfoList) throws Exception;

    int deleteCourseInfo (@Param("Id")String Id);

    int updateCourseInfo (Course course);

    List<Course> selectAllCourseInfo(@Param("current")int current,@Param("length") int length);

    List<Course> selectCourseInfo(@Param("cou_Name")String cou_Name,@Param("current")int current,@Param("length") int length);

}
