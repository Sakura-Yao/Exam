package com.huade.dao;

import com.huade.pojo.Knowledge;
import com.huade.pojo.View_Knowledge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KnowledgeMapper {

    int addKnowledge(Knowledge knowledge);

    int deleteKnowledge(@Param("Id")String Id);

    int updateKnowledge(Knowledge knowledge);

    List<View_Knowledge> selectAllKnowledge (@Param("current")int current, @Param("length") int length);

    List<View_Knowledge> selectKnowledge (@Param("Id")String Id,
                                     @Param("cou_Id")String cou_Id,
                                     @Param("kwl_Level")String kwl_Level,
                                     @Param("chapter_Num")String chapter_Num,
                                     @Param("section_Num")String section_Num,
                                     @Param("current")int current, @Param("length")int length);

}
