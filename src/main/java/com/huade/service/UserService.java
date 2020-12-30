package com.huade.service;

import com.huade.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int addUser(User user);

    int batchAddUser(List<Map<String ,Object>> userList) throws Exception;

    int deleteUser (String user_Id);

    int updateUser (User user);

    List<User> selectAllUser();

    User Login (String user_Id, String password);

}
