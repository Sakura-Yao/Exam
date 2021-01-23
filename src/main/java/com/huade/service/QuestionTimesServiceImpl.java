package com.huade.service;

import com.huade.dao.QuestionTimesMapper;
import com.huade.pojo.QuestionTimes;

import java.util.List;

public class QuestionTimesServiceImpl implements QuestionTimesService {

    private QuestionTimesMapper questionTimesMapper;

    public void setQuestionTimesMapper(QuestionTimesMapper questionTimesMapper) {
        this.questionTimesMapper = questionTimesMapper;
    }

    @Override
    public int addQuestionTimesInfo(QuestionTimes questionTimes) {
        return questionTimesMapper.addQuestionTimesInfo(questionTimes);
    }

    @Override
    public int useQuestion(String question_Id) {
        return questionTimesMapper.useQuestion(question_Id);
    }

    @Override
    public List<QuestionTimes> selectAll() {
        return questionTimesMapper.selectAll();
    }
}
