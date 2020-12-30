package com.huade.dao;

import com.huade.pojo.CollegeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollegeInfoMapper {

    int addCollegeInfo (CollegeInfo collegeInfo);

    int deleteCollegeInfo (@Param("col_Id")String col_Id);

    int updateCollegeInfo (CollegeInfo collegeInfo);

    List<CollegeInfo> selectAllCollegeInfo();

    CollegeInfo selectCollegeInfo_col_Id(@Param("col_Id")String col_Id);

    String selectCol_Id(@Param("col_Name")String col_Name);
}

