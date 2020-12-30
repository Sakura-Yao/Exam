package com.huade.dao;

import com.huade.pojo.User_Type;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTypeMapper {

     int addUserType(User_Type user_type);

     int deleteUserType (@Param("Id")String Id);

     int updateUserType (User_Type user_type);

     List<User_Type> selectAllUserType();

     String selectUserType_Id(@Param("Id")String Id);

     String selectUserType_Name(@Param("type_Name")String type_Name);
}
