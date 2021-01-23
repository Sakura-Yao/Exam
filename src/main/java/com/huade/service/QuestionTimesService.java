package com.huade.service;

import com.huade.pojo.QuestionTimes;

import java.util.List;

public interface QuestionTimesService {

    int addQuestionTimesInfo(QuestionTimes questionTimes);

    int useQuestion(String question_Id);

    List<QuestionTimes> selectAll();

}
