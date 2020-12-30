package com.huade.service;

import com.huade.pojo.Question_Type;

import java.util.List;

public interface QuestionTypeService {

    int addQuestionType(Question_Type question_type);

    int deleteQuestionType(String Id);

    int updateQuestionType(Question_Type question_type);

    List<Question_Type> selectAllQuestionType();

    String selectQuestionType_Id (String Id);

}
