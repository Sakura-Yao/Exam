package com.huade.Utils;

import com.huade.pojo.Paper;
import com.huade.pojo.Population;
import com.huade.pojo.Rule;

public class GA {

    private static final int RUN_COUNT = 50;
    private static final double EXPAND = 0.97;
    private static final int POP_SIZE = 100;
    private static final boolean INIT = true;
    private static final double KP_COVERAGE_EXPAND = 0.9;

     public static Paper AutoMakePaper(Rule rule){
         Paper resultPaper = null;
         //迭代计数器
         int count = 0;
         //适应度期望值
         System.out.println("正在组卷！！！");
         //初始化种群
         Population population = new Population(POP_SIZE,INIT,rule);
         while(count < RUN_COUNT && ( population.getFitness().getAdaptationDegree() < EXPAND || population.getFitness().getKPCoverage() < KP_COVERAGE_EXPAND)){
             count++;
             population = com.huade.pojo.GA.evolvePopulation(population,rule);
             System.out.println("第 " + count + " 次进化，适应度为： " + population.getFitness().getAdaptationDegree());
         }
         System.out.println("进化次数： " + count);
         resultPaper = population.getFitness();
         System.out.println("适应度："+population.getFitness().getAdaptationDegree());
         System.out.println("知识点覆盖率："+population.getFitness().getKPCoverage());
         System.out.println("难度系数："+population.getFitness().getDifficulty(rule));
         return resultPaper;
     }

}
