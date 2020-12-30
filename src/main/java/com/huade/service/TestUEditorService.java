package com.huade.service;

import com.huade.pojo.Test_Ueditor;

import java.util.List;
import java.util.Map;

public interface TestUEditorService {

    int addTestInfo(Test_Ueditor test_ueditor);

    Test_Ueditor selectTestInfo(String Id);

    int batchAddTestInfo(List<Map<String ,Object>> infoList);

}
