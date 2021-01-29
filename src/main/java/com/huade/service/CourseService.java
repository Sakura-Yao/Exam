package com.huade.service;

import com.huade.pojo.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    int addCourseInfo(Course course);

    int batchAddCourseInfo(List<Map<String,Object>> courseInfoList) throws Exception;

    int deleteCourseInfo (String Id);

    int updateCourseInfo (Course course);

    List<Course> selectAllCourseInfo(int current, int length);

    List<Course> selectCourseInfo(String spe_Id,int current,int length);

}
