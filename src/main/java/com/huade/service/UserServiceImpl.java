package com.huade.service;

import com.huade.dao.UserMapper;
import com.huade.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int batchAddUser(List<Map<String, Object>> userList) throws Exception {
        return userMapper.batchAddUser(userList);
    }

    @Override
    public int deleteUser(String user_Id) {
        return userMapper.deleteUser(user_Id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User Login(String user_Id, String password) {
        return userMapper.Login(user_Id, password);
    }
}
