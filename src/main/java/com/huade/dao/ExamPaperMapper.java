package com.huade.dao;

import com.huade.pojo.Exam_Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamPaperMapper {

    int addExamPaper(Exam_Paper exam_paper);

    int deleteExamPaper(@Param("Id")String Id);

    int updateExamPaper(Exam_Paper exam_paper);

    List<Exam_Paper> selectExamQuestion(@Param("exam_Id")String exam_Id);

}
