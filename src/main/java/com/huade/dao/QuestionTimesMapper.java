package com.huade.dao;

import com.huade.pojo.QuestionTimes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionTimesMapper {

    int addQuestionTimesInfo(QuestionTimes questionTimes);

    int useQuestion(@Param("question_Id")String question_Id);

    List<QuestionTimes> selectAll();

}
