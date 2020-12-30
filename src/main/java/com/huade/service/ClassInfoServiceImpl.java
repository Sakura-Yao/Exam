package com.huade.service;

import com.huade.dao.ClassInfoMapper;
import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;

import java.util.List;

public class ClassInfoServiceImpl implements ClassInfoService {

    private ClassInfoMapper classInfoMapper;

    public void setClassInfoMapper(ClassInfoMapper classInfoMapper) {
        this.classInfoMapper = classInfoMapper;
    }

    @Override
    public int addClassInfo(ClassInfo classInfo) {
        return classInfoMapper.addClassInfo(classInfo);
    }

    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        return classInfoMapper.updateClassInfo(classInfo);
    }

    @Override
    public int deleteClassInfo(String Id) {
        return classInfoMapper.deleteClassInfo(Id);
    }

    @Override
    public List<View_ClassInfo> selectAllClassInfo() {
        return classInfoMapper.selectAllClassInfo();
    }

    @Override
    public List<ClassInfo> selectClassInfo(String col_Id,String spe_Id,int current,int length) {
        return classInfoMapper.selectClassInfo(col_Id,spe_Id,current,length);
    }

    @Override
    public String selectId(String class_Id) {
        return classInfoMapper.selectId(class_Id);
    }

}
