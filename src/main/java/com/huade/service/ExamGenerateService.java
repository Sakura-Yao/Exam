package com.huade.service;

import com.huade.pojo.Exam_Generate;

import java.util.List;

public interface ExamGenerateService {

    int addExamGenerate(Exam_Generate exam_generate);

    int deleteExamGenerate(String Id);

    int updateExamGenerate(Exam_Generate exam_generate);

    List<Exam_Generate> selectExamGenerate(String Id,String exam_Plan_Id,
                                           int current, int length);


}
