package com.huade.pojo;

import com.huade.service.QuestionInfoServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * 种群，多套试卷
 */
public class Population {

    private QuestionInfoServiceImpl questionInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionInfoServiceImpl",QuestionInfoServiceImpl.class);


    private Paper[] papers;

    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param initFlag       初始化标志 true-初始化
     * @param rule           规则bean
     */
    public Population(int populationSize, boolean initFlag, Rule rule){
        papers = new Paper[populationSize];
        if (initFlag) {
            Paper paper;
            Random random = new Random();
            for (int i = 0; i < populationSize; i++) {
                paper = new Paper();
                paper.setId(i);
                while (paper.getTotalScore() != rule.getTotalMark()) {
                    paper.getQuestionList().clear();
                    String[] idString = rule.getPointIds().toArray(new String[0]);
                    //单选题
                    if (rule.getSingleNum() > 0) {
                        generateQuestion(rule,"1f45bd0005c541b998731546b3b8909a", random, rule.getSingleNum(), rule.getSingleScore(), idString,
                                "单选题数量不够，组卷失败", paper);
                    }
                    //填空题
                    if (rule.getCompleteNum() > 0) {
                        generateQuestion(rule,"9d1ec85c8fdd40ba8b4cc733d4d72581", random, rule.getCompleteNum(), rule.getSingleScore(), idString,
                                "填空题数量不够，组卷失败", paper);
                    }
                    //主观题
                    if (rule.getSubjectNum() > 0) {
                        generateQuestion(rule,"1996a697e26a4453a80900a82c1df699", random, rule.getSubjectNum(), rule.getSingleScore(), idString,
                                "编程题数量不够，组卷失败", paper);
                    }
                    paper.getTotalScore(rule);
                }
                //计算试卷知识点覆盖率
                paper.setKPCoverage(rule);
                //计算试卷适合度
                paper.setAdaptationDegree(rule,Global.KP_WEIGHT,Global.DIFFICULTY_WEIGHT);
                papers[i] = paper;
            }
        }
    }

    private void generateQuestion(Rule rule,String Type, Random random, int questionNum, double score, String[] idString, String s, Paper paper) {
        QuestionInfo[] Array = null;
        //暂时设置为空，之后需要更改Service方法
        Array = questionInfoServiceImpl.GA_QuestionInfo(rule.getCou_Id(), Type, idString);
        QuestionInfo tmpQuestion;
        for (int i = 0; i < questionNum; i++) {
            int index = random.nextInt(Array.length - i);
            //初始化分数
            paper.addQuestion(Array[index]);
            //确保不会出现重复添加试题
            tmpQuestion = Array[Array.length - i -1];
            Array[Array.length - i - 1] = Array[index];
            Array[index] = tmpQuestion;
        }
    }

    /**
     * 获取种群中最优秀的个体
     */
    public Paper getFitness(){
        Paper paper = papers[0];
        for (int i = 1; i < papers.length; i++) {
            if (paper.getAdaptationDegree() < papers[i].getAdaptationDegree()){
                paper = papers[i];
            }
        }
        return paper;
    }

    public Population(int populationSize){
        papers = new Paper[populationSize];
    }

    /**
     * 获取种群中某个个体
     */
    public Paper getPaper(int index){
        return papers[index];
    }

    /**
     * 设置种群中某个个体
     */
    public void setPaper(int index, Paper paper){
        papers[index] = paper;
    }

    /**
     * 返回种群规模
     */
    public int getLength(){
        return papers.length;
    }

}
