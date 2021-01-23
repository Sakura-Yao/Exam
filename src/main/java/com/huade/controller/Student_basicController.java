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
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * 添加学生基本信息Controller
     * @param session 登录状态
     * @param user_Id 学生Id
     * @param password 密码
     * @param user_Name 姓名
     * @param user_Type 类型
     * @param user_Sex 性别
     * @param user_Mobile 手机号码
     * @param stu_ClassId 所属班级
     * @param stu_College 所属院系
     * @param stu_Specialty 所属专业
     * @return Json
     * @throws JsonProcessingException
     * @since 后面加上最后一次修改的日期，作为版本控制
     */
    @RequestMapping("/addStudentBasic") //接口注解
    @ResponseBody //返回值为字符串
    public String addStudentBasic (HttpSession session, @RequestParam("user_Id") String user_Id,
                              @RequestParam("password") String password,
                              @RequestParam("user_Name") String user_Name,
                              @RequestParam("user_Type") String user_Type,
                              @RequestParam("user_Sex")String user_Sex,
                              @RequestParam("user_Mobile") String user_Mobile,
                              @RequestParam("stu_ClassId") String stu_ClassId,
                              @RequestParam("stu_College")String stu_College,
                              @RequestParam("stu_Specialty")String stu_Specialty) throws JsonProcessingException {
        //创建Json对象和SpringMVC返回类
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        //判断登录状态
        if (session.getAttribute("login_session") != null) {
            //将前端发送的信息整合为user实体类
            User user = new User(user_Id,password,user_Name,user_Type,user_Sex,user_Mobile);
            //将前端发送的信息整合为Student_Basic实体类
            Student_Basic student_basic = new Student_Basic(user_Id,stu_ClassId,stu_College,stu_Specialty);
            //判断学生信息和用户信息是否添加成功
            if (studentBasicService.addStudentBasic(student_basic)==1 && userService.addUser(user) == 1){
                //生成返回的json信息
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
            //SpringMVC返回json类型字符串
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/deleteStudentBasic")
    @ResponseBody
    public String deleteStudentBasic(HttpSession session, @RequestParam("user_Id")String user_Id) throws JsonProcessingException {
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
                                          @RequestParam("user_Id") String user_Id,
                                          @RequestParam("stu_ClassId") String stu_ClassId,
                                          @RequestParam("stu_College")String stu_College,
                                      @RequestParam("stu_Specialty")String stu_Specialty) throws JsonProcessingException{
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
    public String selectTeacher (HttpSession session,@RequestParam("user_Id")String user_Id,
                                 @RequestParam("user_Name")String user_Name,
                                 @RequestParam("class_Id")String class_Id,
                                 @RequestParam("col_Id")String col_Id,
                                 @RequestParam("spe_Id")String spe_Id,
                                 @RequestParam("current")int current,@RequestParam("length") int length) throws JsonProcessingException{
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
