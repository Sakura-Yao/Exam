package com.huade.service;

import com.huade.dao.StudentBasicMapper;
import com.huade.pojo.Student_Basic;
import com.huade.pojo.View_StudentBasicInfo;

import java.util.List;
import java.util.Map;

public class StudentBasicServiceImpl implements StudentBasicService {

    private StudentBasicMapper studentBasicMapper;

    public void setStudentBasicMapper(StudentBasicMapper studentBasicMapper) {
        this.studentBasicMapper = studentBasicMapper;
    }

    @Override
    public int addStudentBasic(Student_Basic student_basic) {
        return studentBasicMapper.addStudentBasic(student_basic);
    }

    @Override
    public int deleteStudentBasic(String user_Id) {
        return studentBasicMapper.deleteStudentBasic(user_Id);
    }

    @Override
    public int updateStudentBasic(Student_Basic student_basic) {
        return studentBasicMapper.updateStudentBasic(student_basic);
    }

    @Override
    public List<Student_Basic> selectAllStudentBasic() {
        return studentBasicMapper.selectAllStudentBasic();
    }

    @Override
    public List<View_StudentBasicInfo> selectStudentBasic(String user_Id, String user_Name, String class_Id, String col_Id, String spe_Id, int current, int length) {
        return studentBasicMapper.selectStudentBasic(user_Id,user_Name,class_Id,col_Id,spe_Id,current,length);
    }

    @Override
    public int batchAddStudentBasicInfo(List<Map<String, Object>> studentBasicList) throws Exception {
        return studentBasicMapper.batchAddStudentBasicInfo(studentBasicList);
    }
}
