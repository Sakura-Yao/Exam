package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.User;
import com.huade.service.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;

    @RequestMapping("/SelectAllUser")
    @ResponseBody
    public String selectAllUser(HttpSession session)throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            if (userService.selectAllUser() !=null){
                object.put("code", 1);
                object.put("message", "success");
                object.put("data",userService.selectAllUser());
                return mapper.writeValueAsString(object);
            }else {
                object.put("code", 0);
                object.put("message", "未查询到该信息");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登录状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser (HttpSession session, @Param("user_Id") String user_Id, @Param("password") String password, @Param("user_Name") String user_Name, @Param("user_Type") String user_Type, @Param("user_Sex")String user_Sex, @Param("user_Mobile") String user_Mobile) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            User user = new User(user_Id,password,user_Name,user_Type,user_Sex,user_Mobile);
            if (userService.addUser(user) == 1) {
                object.put("code",1);
                object.put("message","success");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","添加学生信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/DeleteUser")
    @ResponseBody
    public String DeleteUser (HttpSession session,@Param("user_id")String user_id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            if (userService.deleteUser(user_id) == 1) {
                object.put("code",1);
                object.put("message","success");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","删除用户失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/UpdateUser")
    @ResponseBody
    public String UpdateUser (HttpSession session,@Param("user_id")String user_id,
                              @Param("password")String password,
                              @Param("user_Name")String user_Name,
                              @Param("user_Type")String user_Type,
                              @Param("user_Sex")String user_Sex,
                              @Param("user_Mobile")String user_Mobile) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(user_id, password, user_Name, user_Type, user_Sex, user_Mobile);
        if (session.getAttribute("login_session") != null) {
            if (userService.updateUser(user) == 1) {
                object.put("code",1);
                object.put("message","success");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","修改用户失败！请重试！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }


}
