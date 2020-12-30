package com.huade.service;

import com.huade.dao.SpecialtyInfoMapper;
import com.huade.pojo.Specialty;

import java.util.List;

public class SpecialtyInfoServiceImpl implements SpecialtyInfoService {

    private SpecialtyInfoMapper specialtyInfoMapper;

    public void setSpecialtyInfoMapper(SpecialtyInfoMapper specialtyInfoMapper) {
        this.specialtyInfoMapper = specialtyInfoMapper;
    }

    @Override
    public int addSpecialtyInfo(Specialty specialty) {
        return specialtyInfoMapper.addSpecialtyInfo(specialty);
    }

    @Override
    public int deleteSpecialtyInfo(String Id) {
        return specialtyInfoMapper.deleteSpecialtyInfo(Id);
    }

    @Override
    public int updateSpecialtyInfo(Specialty specialty) {
        return specialtyInfoMapper.updateSpecialtyInfo(specialty);
    }

    @Override
    public List<Specialty> selectAllSpecialty() {
        return specialtyInfoMapper.selectAllSpecialty();
    }

    @Override
    public List<Specialty> selectSpecialty_col_Id(String col_Id) {
        return specialtyInfoMapper.selectSpecialty_col_Id(col_Id);
    }

    @Override
    public String selectSpe_Id(String spe_Name) {
        return specialtyInfoMapper.selectSpe_Id(spe_Name);
    }
}
