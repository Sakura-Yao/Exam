package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.Student_Basic;
import com.huade.pojo.Teacher_Basic;
import com.huade.pojo.User;
import com.huade.service.StudentBasicServiceImpl;
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
@RequestMapping("/Student_basic")
public class Student_basicController {
    @Autowired
    @Qualifier("StudentBasicServiceImpl")
    private StudentBasicServiceImpl studentBasicService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;


    @RequestMapping("/addStudentBasic")
    @ResponseBody
    public String addStudentBasic (HttpSession session, @Param("user_Id") String user_Id,
                              @Param("password") String password,
                              @Param("user_Name") String user_Name,
                              @Param("user_Type") String user_Type,
                              @Param("user_Sex")String user_Sex,
                              @Param("user_Mobile") String user_Mobile,
                              @Param("stu_ClassId") String stu_ClassId,
                              @Param("stu_College")String stu_College,
                              @Param("stu_Specialty")String stu_Specialty) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            User user = new User(user_Id,password,user_Name,user_Type,user_Sex,user_Mobile);
            Student_Basic student_basic = new Student_Basic(user_Id,stu_ClassId,stu_College,stu_Specialty);

            if (studentBasicService.addStudentBasic(student_basic)==1 && userService.addUser(user) == 1){
                object.put("code",1);
                object.put("message","添加学生基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","添加学生基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登陆！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/deleteStudentBasic")
    @ResponseBody
    public String deleteStudentBasic(HttpSession session, @Param("user_Id")String user_Id) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            if (studentBasicService.deleteStudentBasic(user_Id)==1 && userService.deleteUser(user_Id) == 1) {
                object.put("code",1);
                object.put("message","删除学生基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","删除学生基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/updateStudentBasic")
    @ResponseBody
    public String updateStudentBasic (HttpSession session,
                                          @Param("user_Id") String user_Id,
                                          @Param("stu_ClassId") String stu_ClassId,
                                          @Param("stu_College")String stu_College,
                                      @Param("stu_Specialty")String stu_Specialty) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null) {
            Student_Basic student_basic = new Student_Basic(user_Id,stu_ClassId,stu_College,stu_Specialty);

            if (studentBasicService.updateStudentBasic(student_basic)==1) {
                object.put("code",1);
                object.put("message","修改学生基础信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","修改学生基础信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/selectStudentBasic")
    @ResponseBody
    public String selectTeacher (HttpSession session,@Param("user_Id")String user_Id,
                                 @Param("user_Name")String user_Name,
                                 @Param("class_Id")String class_Id,
                                 @Param("col_Id")String col_Id,
                                 @Param("spe_Id")String spe_Id,
                                 @Param("current")int current,@Param("length") int length) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        if (session.getAttribute("login_session") != null) {
            if (studentBasicService.selectStudentBasic(user_Id,user_Name,class_Id,col_Id,spe_Id,current,length).size()!=0) {
                object.put("code",1);
                object.put("message","查询学生基础信息成功！");
                object.put("data",studentBasicService.selectStudentBasic(user_Id,user_Name,class_Id,col_Id,spe_Id,current,length));
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","查询学生基础信息失败！");
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
