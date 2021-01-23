package com.huade.service;

import com.huade.pojo.Exam_Paper;

import java.util.List;

public interface ExamPaperService {

    int addExamPaper(Exam_Paper exam_paper);

    int deleteExamPaper(String Id);

    int updateExamPaper(Exam_Paper exam_paper);

    List<Exam_Paper> selectExamQuestion(String exam_Id);


}
