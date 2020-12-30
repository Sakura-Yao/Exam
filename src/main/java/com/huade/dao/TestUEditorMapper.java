package com.huade.dao;

import com.huade.pojo.Test_Ueditor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestUEditorMapper {

    int addTestInfo(Test_Ueditor test_ueditor);

    Test_Ueditor selectTestInfo(@Param("Id")String Id);

    int batchAddTestInfo(List<Map<String ,Object>> infoList) throws Exception;


}
