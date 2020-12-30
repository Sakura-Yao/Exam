package com.huade.service;

import com.huade.dao.CollegeInfoMapper;
import com.huade.pojo.CollegeInfo;

import java.util.List;

public class CollegeInfoServiceImpl implements CollegeInfoService {

    private CollegeInfoMapper collegeInfoMapper;

    public void setCollegeInfoMapper(CollegeInfoMapper collegeInfoMapper) {
        this.collegeInfoMapper = collegeInfoMapper;
    }

    @Override
    public int addCollegeInfo(CollegeInfo collegeInfo) {
        return collegeInfoMapper.addCollegeInfo(collegeInfo);
    }

    @Override
    public int deleteCollegeInfo(String col_Id) {
        return collegeInfoMapper.deleteCollegeInfo(col_Id);
    }

    @Override
    public int updateCollegeInfo(CollegeInfo collegeInfo) {
        return collegeInfoMapper.updateCollegeInfo(collegeInfo);
    }

    @Override
    public List<CollegeInfo> selectAllCollegeInfo() {
        return collegeInfoMapper.selectAllCollegeInfo();
    }

    @Override
    public CollegeInfo selectCollegeInfo_col_Id(String col_Id) {
        return collegeInfoMapper.selectCollegeInfo_col_Id(col_Id);
    }

    @Override
    public String selectCol_Id(String col_Name) {
        return collegeInfoMapper.selectCol_Id(col_Name);
    }
}
