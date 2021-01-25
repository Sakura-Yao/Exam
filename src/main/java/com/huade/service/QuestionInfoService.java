package com.huade.service;

import com.huade.pojo.QuestionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionInfoService {

    int addQuestionInfo(QuestionInfo questionInfo);

    int deleteQuestionInfo(String question_Id);

    int updateQuestionInfo(QuestionInfo questionInfo);

    List<QuestionInfo> selectQuestionInfo(String question_Id,String cou_Id,String type_Id,String subject,String degree,
                                          int current,  int length);

    QuestionInfo[] GA_QuestionInfo(String cou_Id,String type,
                                       String[] kwl_list);
}
