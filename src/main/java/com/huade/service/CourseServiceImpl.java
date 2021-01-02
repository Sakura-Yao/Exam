package com.huade.service;

import com.huade.dao.CourseMapper;
import com.huade.pojo.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public int addCourseInfo(Course course) {
        return courseMapper.addCourseInfo(course);
    }

    @Override
    public int deleteCourseInfo(String Id) {
        return courseMapper.deleteCourseInfo(Id);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return courseMapper.updateCourseInfo(course);
    }

    @Override
    public List<Course> selectAllCourseInfo(int current, int length) {
        return courseMapper.selectAllCourseInfo(current,length);
    }

    @Override
    public List<Course> selectCourseInfo(String cou_Name,String spe_Id, int current, int length) {
        return courseMapper.selectCourseInfo(cou_Name,spe_Id,current,length);
    }
}
