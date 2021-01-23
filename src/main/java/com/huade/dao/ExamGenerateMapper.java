package com.huade.dao;

import com.huade.pojo.Exam_Generate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamGenerateMapper {

    int addExamGenerate(Exam_Generate exam_generate);

    int deleteExamGenerate(@Param("Id")String Id);

    int updateExamGenerate(Exam_Generate exam_generate);

    List<Exam_Generate> selectExamGenerate(@Param("Id")String Id,@Param("exam_Plan_Id")String exam_Plan_Id,
                                           @Param("current")int current, @Param("length")int length);

}
