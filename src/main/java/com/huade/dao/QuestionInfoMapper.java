package com.huade.dao;

import com.huade.pojo.QuestionInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionInfoMapper {
    
    int addQuestionInfo(QuestionInfo questionInfo);
    
    int deleteQuestionInfo(@Param("question_Id")String question_Id);
    
    int updateQuestionInfo(QuestionInfo questionInfo);
    
    List<QuestionInfo> selectQuestionInfo(@Param("question_Id")String question_Id,
                                          @Param("cou_Id")String cou_Id,
                                          @Param("type_Id")String type_Id,
                                          @Param("subject")String subject,
                                          @Param("degree")String degree,
                                          @Param("current")int current,@Param("length") int length);

    QuestionInfo[] GA_QuestionInfo(@Param("cou_Id")String cou_Id,
                                       @Param("type")String type,
                                       @Param("kwl_list") String[] kwl_list);
}
