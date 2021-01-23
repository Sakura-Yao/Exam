package com.huade.service;

import com.huade.dao.ExamPlanMapper;
import com.huade.pojo.ExamPlan;

import java.util.List;

public class ExamPlanServiceImpl implements ExamPlanService {

    private ExamPlanMapper examPlanMapper;

    public void setExamPlanMapper(ExamPlanMapper examPlanMapper) {
        this.examPlanMapper = examPlanMapper;
    }

    @Override
    public int addExamPlan(ExamPlan examPlan) {
        return examPlanMapper.addExamPlan(examPlan);
    }

    @Override
    public int deleteExamPlan(String Id) {
        return examPlanMapper.deleteExamPlan(Id);
    }

    @Override
    public int updateExamPlan(ExamPlan examPlan) {
        return examPlanMapper.updateExamPlan(examPlan);
    }

    @Override
    public List<ExamPlan> selectExamPlan(String Id, String cou_Id, String class_Id, String mode, String proposition_Teacher, String time, String col_Id, String spe_Id, int current, int length) {
        return examPlanMapper.selectExamPlan(Id, cou_Id, class_Id, mode, proposition_Teacher, time, col_Id, spe_Id, current, length);
    }
}
