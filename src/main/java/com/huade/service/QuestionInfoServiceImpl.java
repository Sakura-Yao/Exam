package com.huade.service;

import com.huade.dao.QuestionInfoMapper;
import com.huade.pojo.QuestionInfo;

import java.util.List;

public class QuestionInfoServiceImpl implements QuestionInfoMapper {

    private QuestionInfoMapper questionInfoMapper;

    public void setQuestionInfoMapper(QuestionInfoMapper questionInfoMapper) {
        this.questionInfoMapper = questionInfoMapper;
    }

    @Override
    public int addQuestionInfo(QuestionInfo questionInfo) {
        return questionInfoMapper.addQuestionInfo(questionInfo);
    }

    @Override
    public int deleteQuestionInfo(String question_Id) {
        return questionInfoMapper.deleteQuestionInfo(question_Id);
    }

    @Override
    public int updateQuestionInfo(QuestionInfo questionInfo) {
        return questionInfoMapper.updateQuestionInfo(questionInfo);
    }

    @Override
    public List<QuestionInfo> selectQuestionInfo(String question_Id, String cou_Id, String type_Id, String subject, String degree, int current, int length) {
        return questionInfoMapper.selectQuestionInfo(question_Id, cou_Id, type_Id, subject, degree, current, length);
    }
}
