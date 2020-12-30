package com.huade.service;

import com.huade.pojo.Knowledge;
import com.huade.pojo.View_Knowledge;

import java.util.List;

public interface KnowledgeService {

    int addKnowledge(Knowledge knowledge);

    int deleteKnowledge(String Id);

    int updateKnowledge(Knowledge knowledge);

    List<View_Knowledge> selectAllKnowledge (int current, int length);

    List<View_Knowledge> selectKnowledge (String Id,String cou_Id,String kwl_Level,String chapter_Num,String section_Num,
                                     int current, int length);


}
