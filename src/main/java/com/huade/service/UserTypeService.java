package com.huade.service;

import com.huade.pojo.User_Type;

import java.util.List;

public interface UserTypeService {

    int addUserType(User_Type user_type);

    int deleteUserType (String Id);

    int updateUserType (User_Type user_type);

    List<User_Type> selectAllUserType();

    String selectUserType_Id(String Id);

    String selectUserType_Name(String type_Name);

}
