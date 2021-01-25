package com.huade.pojo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 遗传算法中的个体，即一套可能的试卷。对试卷进行编码，而不是对整个题库编码
 */
public class Paper {

    private int Id;
    private double adaptationDegree = 0.00;
    private double KPCoverage = 0.00;
    private double totalScore = 0.00;
    private double difficulty = 0.00;
    private List<QuestionInfo> questionList = new ArrayList<QuestionInfo>();

    public Paper(int size){
        for (int i = 0; i < size; i++) {
            questionList.add(null);
        }
    }

    public Paper(){
        super();
    }

    /**
     * 计算试卷总分
     */
    public double getTotalScore(Rule rule){
        if (totalScore == 0){
            double total = 0.00;
            for (QuestionInfo questionInfo : questionList) {
                if (questionInfo.getType_Id().equals("1f45bd0005c541b998731546b3b8909a")){

                    total += rule.getSingleScore();
                }
                else if (questionInfo.getType_Id().equals("9d1ec85c8fdd40ba8b4cc733d4d72581")) {

                    total += rule.getCompleteScore();
                }
                else if (questionInfo.getType_Id().equals("1996a697e26a4453a80900a82c1df699")) {

                    total += rule.getSubjectScore();
                }
            }
            totalScore = total;
        }
        return totalScore;
    }


    /**
     * 计算试卷个体难度系数，计算公式 每道题难度*分数求和除总分
     */
    public double getDifficulty(Rule rule){
        if (difficulty == 0) {
            double _difficulty = 0;
            for (QuestionInfo questionInfo : questionList) {
                if (questionInfo.getType_Id().equals("1f45bd0005c541b998731546b3b8909a"))
                    _difficulty += rule.getSingleScore() * Double.parseDouble(questionInfo.getDegree());
                else if (questionInfo.getType_Id().equals("9d1ec85c8fdd40ba8b4cc733d4d72581"))
                    _difficulty += rule.getCompleteScore() * Double.parseDouble(questionInfo.getDegree());
                else
                    _difficulty +=rule.getSubjectScore() * Double.parseDouble(questionInfo.getDegree());
            }
            difficulty = _difficulty / getTotalScore(rule);
        }
        return difficulty;
    }

    /**
     * 获取试题数量
     */
    public int getQuestionSize(){
        return questionList.size();
    }

    /**
     * 计算知识点覆盖率 公式为个体包含的知识点/期望包含的知识点
     */
    public void setKPCoverage(Rule rule){
        if (KPCoverage == 0) {
            Set<String> result = new HashSet<String>(rule.getPointIds());
            Set<String> another = questionList.stream().map(questionInfo -> String.valueOf(questionInfo.getKwl_Id())).collect(Collectors.toSet());
            //交集处理
            result.retainAll(another);
            //System.out.println(result.size() +"\t"+rule.getPointIds().size() + "\t"+(double)result.size() / (double)rule.getPointIds().size());
            KPCoverage = (double)result.size() / (double)rule.getPointIds().size();

        }
    }

    /**
     * 计算个体适应度 公式为：f=1-(1-M/N)*f1-|EP-P|*f2
     * 其中M/N为知识点覆盖率，EP为期望难度系数，P为种群个体难度系数，f1为知识点分布的权重
     * ，f2为难度系数所占权重。当f1=0时退化为只限制试题难度系数，当f2=0时退化为只限制知识点分布
     *
     * @param rule 组卷规则
     * @param f1   知识点分布的权重
     * @param f2   难度系数的权重
     */
    public void setAdaptationDegree(Rule rule,double f1,double f2){
        if (adaptationDegree == 0) {
            adaptationDegree = 1 - (1 - getKPCoverage()) * f1 - Math.abs(rule.getDifficulty() - getDifficulty(rule)) * f2;
        }
    }

    /**
     * 查询是否包含某题目
     * @param questionInfo
     * @return
     */
    public boolean containsQuestion(QuestionInfo questionInfo){
        if (questionInfo == null) {
            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i) == null) {
                    return true;
                }
            }
        } else {
            for (QuestionInfo info : questionList) {
                if (info != null) {
                    if (info.equals(questionInfo)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 增加问题
     * @return
     */
    public void saveQuestion(int index,QuestionInfo questionInfo){
        this.questionList.set(index,questionInfo);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.KPCoverage = 0;
    }

    public void addQuestion(QuestionInfo questionInfo){
        this.questionList.add(questionInfo);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.KPCoverage = 0;
    }

    public QuestionInfo getQuestion(int index){
        return questionList.get(index);
    }

    public void setId(int id) {
        Id = id;
    }

    public void setQuestionList(List<QuestionInfo> questionList) {
        this.questionList = questionList;
    }

    public int getId() {
        return Id;
    }

    public double getAdaptationDegree() {
        return adaptationDegree;
    }

    public double getKPCoverage() {
        return KPCoverage;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public List<QuestionInfo> getQuestionList() {
        return questionList;
    }
}
