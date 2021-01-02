package com.huade.dao;

import com.huade.pojo.ClassInfo;
import com.huade.pojo.View_ClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassInfoMapper {

    int addClassInfo (ClassInfo classInfo);

    int updateClassInfo (ClassInfo classInfo);

    int deleteClassInfo (String Id);

    List<View_ClassInfo> selectAllClassInfo();

    List<ClassInfo> selectClassInfo(@Param("Id")String Id,
                                    @Param("col_Id")String col_Id,@Param("spe_Id") String spe_Id,@Param("current")int current,@Param("length") int length);

    String selectId(@Param("class_Id")String class_Id);

}
