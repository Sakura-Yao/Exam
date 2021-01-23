package com.huade.service;

import com.huade.pojo.ExamPlan;

import java.util.List;

public interface ExamPlanService {

    int addExamPlan(ExamPlan examPlan);

    int deleteExamPlan(String Id);

    int updateExamPlan(ExamPlan examPlan);

    List<ExamPlan> selectExamPlan(String Id,String cou_Id,
                                  String class_Id, String mode,
                                  String proposition_Teacher,
                                  String time, String col_Id, String spe_Id,
                                  int current, int length);


}
