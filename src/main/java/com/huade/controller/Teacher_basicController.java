package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.Teacher_Basic;
import com.huade.pojo.User;
import com.huade.service.TeacherBasicServiceImpl;
import com.huade.service.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/Teacher_basic")
public class Teacher_basicController {
    @Autowired
    @Qualifier("TeacherBasicServiceImpl")
    private TeacherBasicServiceImpl teacherBasicService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;


    @RequestMapping("/addTeacherBasicInfo")
    @ResponseBody
    public String addTeacher (HttpSession session, @Param("user_Id") String user_Id,
                              @Param("password") String password,
                              @Param("user_Name") String user_Name,
                              @Param("user_Type") String user_Type,
                              @Param("user_Sex")String user_Sex,
                              @Param("user_Mobile") String user_Mobile,
                              @Param("college_Id") String college_Id,
                              @Param("specialty_Id")String specialty_Id) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            User user = new User(user_Id,password,user_Name,user_Type,user_Sex,user_Mobile);
            Teacher_Basic teacher_Basic = new Teacher_Basic(user_Id,college_Id,specialty_Id);
            if (teacherBasicService.addTeacherBasicInfo(teacher_Basic)==1 && userService.addUser(user) == 1){
                object.put("code",1);
                object.put("message","添加教师基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","添加教师基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登陆！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/deleteTeacherBasicInfo")
    @ResponseBody
    public String deleteTeacherBasicInfo(HttpSession session, @Param("user_Id")String user_Id) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            if (teacherBasicService.deleteTeacherBasicInfo(user_Id)==1 && userService.deleteUser(user_Id) == 1) {
                object.put("code",1);
                object.put("message","删除教师基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","删除教师基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/updateTeacherBasicInfo")
    @ResponseBody
    public String updateTeacherBasicInfo (HttpSession session,
                                          @Param("user_Id") String user_Id,
                                          @Param("college_Id") String college_Id,
                                          @Param("specialty_Id")String specialty_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            Teacher_Basic teacher_Basic = new Teacher_Basic(user_Id,college_Id,specialty_Id);
            if (teacherBasicService.updateTeacherBasicInfo(teacher_Basic)==1) {
                object.put("code",1);
                object.put("message","修改教师基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","修改教师基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/selectTeacher")
    @ResponseBody
    public String selectTeacher (HttpSession session,@Param("user_Id")String user_Id,
                                 @Param("college_Id")String college_Id,
                                 @Param("specialty_Id")String specialty_Id,
                                 @Param("current")int current,
                                 @Param("length")int length) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Teacher_Basic> teacher_Basic = new ArrayList<Teacher_Basic>();
        if (session.getAttribute("login_session") != null) {
            if (teacherBasicService.selectTeacherBasic(user_Id,college_Id,specialty_Id,current,length).size()!=0) {
                object.put("code",1);
                object.put("message","查询教师基础信息成功！");
                object.put("data",teacherBasicService.selectTeacherBasic(user_Id,college_Id,specialty_Id,current,length));
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","查询教师基础信息失败！");
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
