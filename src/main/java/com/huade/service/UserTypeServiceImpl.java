package com.huade.service;

import com.huade.dao.UserTypeMapper;
import com.huade.pojo.User_Type;

import java.util.List;

public class UserTypeServiceImpl implements UserTypeService {

    private UserTypeMapper userTypeMapper;

    public void setUserTypeMapper(UserTypeMapper userTypeMapper) {
        this.userTypeMapper = userTypeMapper;
    }

    @Override
    public int addUserType(User_Type user_type) {
        return userTypeMapper.addUserType(user_type);
    }

    @Override
    public int deleteUserType(String Id) {
        return userTypeMapper.deleteUserType(Id);
    }

    @Override
    public int updateUserType(User_Type user_type) {
        return userTypeMapper.updateUserType(user_type);
    }

    @Override
    public List<User_Type> selectAllUserType() {
        return userTypeMapper.selectAllUserType();
    }

    @Override
    public String selectUserType_Id(String Id) {
        return userTypeMapper.selectUserType_Id(Id);
    }

    @Override
    public String selectUserType_Name(String type_Name) {
        return userTypeMapper.selectUserType_Name(type_Name);
    }
}
