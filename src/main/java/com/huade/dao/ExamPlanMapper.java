package com.huade.dao;

import com.huade.pojo.ExamPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamPlanMapper {

    int addExamPlan(ExamPlan examPlan);

    int deleteExamPlan(@Param("Id")String Id);

    int updateExamPlan(ExamPlan examPlan);

    List<ExamPlan> selectExamPlan(@Param("Id")String Id,@Param("cou_Id")String cou_Id,
                                  @Param("class_Id")String class_Id,@Param("mode")String mode,
                                  @Param("proposition_Teacher")String proposition_Teacher,
                                  @Param("time")String time,
                                  @Param("col_Id")String col_Id,@Param("spe_Id")String spe_Id,
                                  @Param("current")int current, @Param("length")int length);

}
