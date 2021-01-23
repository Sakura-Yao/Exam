package com.huade.service;

import com.huade.dao.ExamGenerateMapper;
import com.huade.pojo.Exam_Generate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExamGenerateServiceImpl implements ExamGenerateService {

    private ExamGenerateMapper examGenerateMapper;

    public void setExamGenerateMapper(ExamGenerateMapper examGenerateMapper) {
        this.examGenerateMapper = examGenerateMapper;
    }

    @Override
    public int addExamGenerate(Exam_Generate exam_generate) {
        return examGenerateMapper.addExamGenerate(exam_generate);
    }

    @Override
    public int deleteExamGenerate(String Id) {
        return examGenerateMapper.deleteExamGenerate(Id);
    }

    @Override
    public int updateExamGenerate(Exam_Generate exam_generate) {
        return examGenerateMapper.updateExamGenerate(exam_generate);
    }

    @Override
    public List<Exam_Generate> selectExamGenerate(String Id, String exam_Plan_Id, int current, int length) {
        return examGenerateMapper.selectExamGenerate(Id, exam_Plan_Id, current, length);
    }
}
