package com.huade.pojo;

import com.huade.service.QuestionInfoServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 遗传算法组卷实现类
 */
public class GA {
    /**
     * 变异概率
     */
    private static final double mutationRate = 0.085;
    /**
     * 精英主义
     */
    private static final boolean elitism = true;
    /**
     * 淘汰数组大小
     */
    private static final int tournamentSize = 5;

    private static QuestionInfoServiceImpl questionInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionInfoServiceImpl",QuestionInfoServiceImpl.class);


    /**
     * 进化种群
     */
    public static Population evolvePopulation(Population pop,Rule rule){
        Population newPopulation = new Population(pop.getLength());
        int elitismOffset;
        //精英主义
        if (elitism) {
            elitismOffset = 1;
            //保留上一代最优秀的个体
            Paper fitness = pop.getFitness();
            fitness.setId(0);
            newPopulation.setPaper(0,fitness);
        }
        //种群交叉操作，从当前种群pop中来创建下一代种群newPopulation
        for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
            //较优选择
            Paper parent1 = select(pop);
            Paper parent2 = select(pop);
            while (parent2.getId() == parent1.getId()) {
                parent2 = select(pop);
            }
            //交叉
            Paper child = crossover(parent1,parent2,rule);
            child.setId(i);
            newPopulation.setPaper(i,child);
        }
        //种群变异操作
        Paper tmpPaper;
        for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
            tmpPaper = newPopulation.getPaper(i);
            mutate(tmpPaper);
            //计算知识点覆盖率与适应度
            tmpPaper.setKPCoverage(rule);
            tmpPaper.setAdaptationDegree(rule,Global.KP_WEIGHT,Global.DIFFICULTY_WEIGHT);
        }
        return newPopulation;
    }

    /**
     * 交叉算子
     *
     * @param parent1
     * @param parent2
     * @return
     */
    private static Paper crossover(Paper parent1, Paper parent2, Rule rule) {
        Paper child = new Paper(parent1.getQuestionSize());
        int s1 = (int) (Math.random() * parent1.getQuestionSize());
        int s2 = (int) (Math.random() * parent1.getQuestionSize());

        //parent1的startPos endPos之间的序列，会被遗传到下一代
        int startPos = Math.min(s1,s2);
        int endPos = Math.max(s1,s2);
        for (int i = startPos; i < endPos; i++) {
            child.saveQuestion(i,parent1.getQuestion(i));
        }
        //继承parent2中未被child继承的question
        //并防止出现重复的元素
        String idString = rule.getPointIds().toString();
        for (int i = 0; i < startPos; i++) {
            if (!child.containsQuestion(parent2.getQuestion(i))){
                child.saveQuestion(i, parent2.getQuestion(i));
            } else {
                String type_id = parent2.getQuestion(i).getType_Id();
                String cou_id = parent2.getQuestion(i).getCou_Id();
                String[] kwl_id = {parent2.getQuestion(i).getKwl_Id()};
                //需要重新定义Service
                QuestionInfo[] Array = questionInfoServiceImpl.GA_QuestionInfo(cou_id,type_id,kwl_id);
                child.saveQuestion(i,Array[(int) (Math.random() * Array.length)]);
            }
        }
        for (int i = endPos; i < parent2.getQuestionSize(); i++) {
            if (!child.containsQuestion(parent2.getQuestion(i))){
                child.saveQuestion(i, parent2.getQuestion(i));
            } else {
                String type_id = parent2.getQuestion(i).getType_Id();
                String cou_id = parent2.getQuestion(i).getCou_Id();
                String[] kwl_id = {parent2.getQuestion(i).getKwl_Id()};
                //需要重新定义Service
                QuestionInfo[] Array = questionInfoServiceImpl.GA_QuestionInfo(cou_id,type_id,kwl_id);
                child.saveQuestion(i,Array[(int) (Math.random() * Array.length)]);
            }
        }
        return child;
    }

    /**
     * 突变算子 每个个体的每个基因都有可能突变
     *
     * @param paper
     */
    private static void mutate(Paper paper) {
        QuestionInfo tmpQuestion;
        List<QuestionInfo> list;
        int index;
        for (int i = 0; i < paper.getQuestionSize(); i++) {
            if (Math.random() < mutationRate){
                //进行突变
                tmpQuestion = paper.getQuestion(i);
                //从题库中获取和变异的题目类型一样的题目
                String type_id = tmpQuestion.getType_Id();
                String[] kwl_id = {tmpQuestion.getKwl_Id()};
                String cou_id = tmpQuestion.getCou_Id();
                QuestionInfo[] questionInfos = questionInfoServiceImpl.GA_QuestionInfo(cou_id,type_id,kwl_id);
                if (questionInfos.length > 0) {
                    //随机选一道
                    index = (int) (Math.random() * questionInfos.length);

                    paper.saveQuestion(i,questionInfos[index]);
                }
            }
        }
    }

    /**
     * 选择算子
     *
     * @param population 种群
     */
    private static Paper select(Population population) {
        Population pop = new Population(tournamentSize);
        for (int i = 0; i < tournamentSize; i++) {
            pop.setPaper(i,population.getPaper((int) (Math.random() * population.getLength())));
        }
        return pop.getFitness();
    }

}
