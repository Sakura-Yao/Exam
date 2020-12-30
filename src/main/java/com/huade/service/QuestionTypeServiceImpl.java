package com.huade.service;

import com.huade.dao.QuestionTypeMapper;
import com.huade.pojo.Question_Type;

import java.util.List;

public class QuestionTypeServiceImpl implements QuestionTypeService {

    private QuestionTypeMapper questionTypeMapper;

    public void setQuestionTypeMapper(QuestionTypeMapper questionTypeMapper) {
        this.questionTypeMapper = questionTypeMapper;
    }

    @Override
    public int addQuestionType(Question_Type question_type) {
        return questionTypeMapper.addQuestionType(question_type);
    }

    @Override
    public int deleteQuestionType(String Id) {
        return questionTypeMapper.deleteQuestionType(Id);
    }

    @Override
    public int updateQuestionType(Question_Type question_type) {
        return questionTypeMapper.updateQuestionType(question_type);
    }

    @Override
    public List<Question_Type> selectAllQuestionType() {
        return questionTypeMapper.selectAllQuestionType();
    }

    @Override
    public String selectQuestionType_Id(String Id) {
        return questionTypeMapper.selectQuestionType_Id(Id);
    }
}
