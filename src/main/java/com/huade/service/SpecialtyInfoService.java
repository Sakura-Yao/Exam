package com.huade.service;

import com.huade.pojo.Specialty;

import java.util.List;

public interface SpecialtyInfoService {

    int addSpecialtyInfo (Specialty specialty);

    int deleteSpecialtyInfo (String Id);

    int updateSpecialtyInfo (Specialty specialty);

    List<Specialty> selectAllSpecialty();

    List<Specialty> selectSpecialty_col_Id (String col_Id);

    String selectSpe_Id(String spe_Name);

}
