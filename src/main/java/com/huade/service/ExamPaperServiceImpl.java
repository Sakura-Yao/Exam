package com.huade.service;

import com.huade.dao.ExamPaperMapper;
import com.huade.pojo.Exam_Paper;

import java.util.List;

public class ExamPaperServiceImpl implements ExamPaperService {

    private ExamPaperMapper examPaperMapper;

    public void setExamPaperMapper(ExamPaperMapper examPaperMapper) {
        this.examPaperMapper = examPaperMapper;
    }

    @Override
    public int addExamPaper(Exam_Paper exam_paper) {
        return examPaperMapper.addExamPaper(exam_paper);
    }

    @Override
    public int deleteExamPaper(String Id) {
        return examPaperMapper.deleteExamPaper(Id);
    }

    @Override
    public int updateExamPaper(Exam_Paper exam_paper) {
        return examPaperMapper.updateExamPaper(exam_paper);
    }

    @Override
    public List<Exam_Paper> selectExamQuestion(String exam_Id) {
        return examPaperMapper.selectExamQuestion(exam_Id);
    }
}
