package com.huade.dao;

import com.huade.pojo.User;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int addUser(User user);

    int batchAddUser(List<Map<String ,Object>> userList) throws Exception;

    int deleteUser (@Param("user_Id")String user_Id);

    int updateUser (User user);

    List<User> selectAllUser();

    User Login(@Param("user_Id")String user_Id,
               @Param("password")String password);

}
