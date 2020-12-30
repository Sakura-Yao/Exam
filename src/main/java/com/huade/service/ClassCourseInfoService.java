package com.huade.service;

import com.huade.dao.ClassCourseInfoMapper;
import com.huade.pojo.ClassCourseInfo;

import java.util.ArrayList;
import java.util.List;

public interface ClassCourseInfoService {

    int addClassCourseInfo(ClassCourseInfo classCourseInfo);

    int deleteClassCourseInfo(ClassCourseInfo classCourseInfo);

    int updateClassCourseInfo (ClassCourseInfo new_ClassCourseInfo,
                               ClassCourseInfo old_ClassCourseInfo);

    List<ClassCourseInfoMapper> selectAllClassCourseInfo(int current, int length);

    List<ClassCourseInfoMapper> selectClassCourseInfo(String[] class_Id, String user_Id, String cou_Id,
                                                      int current, int length);


}
