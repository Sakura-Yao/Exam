package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.Course;
import com.huade.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;

    @RequestMapping("/addCourseInfo")
    @ResponseBody
    public String addCourseInfo(HttpSession session, @RequestParam("Id") String Id, @RequestParam("cou_Name") String cou_Name, @RequestParam("spe_Id") String spe_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        Course course = new Course(Id,cou_Name);
        if(session.getAttribute("login_session") != null){
            if(courseService.addCourseInfo(course) == 1){
                object.put("code",1);
                object.put("message","添加课程成功！");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","添加课程失败！");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/deleteCourseInfo")
    @ResponseBody
    public String deleteCourseInfo(HttpSession session, @RequestParam("cou_Id") String cou_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null){
            if (courseService.deleteCourseInfo(cou_Id) == 1){
                object.put("code",1);
                object.put("message","删除课程成功！");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","删除课程失败！");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }

    }
    @RequestMapping("/updateCourseInfo")
    @ResponseBody
    public String updateCourseInfo(HttpSession session,@RequestParam("Id") String Id,@RequestParam("cou_Name") String cou_Name,@RequestParam("spe_Id") String spe_Id) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        Course course = new Course(Id,cou_Name);
        if (session.getAttribute("login_session") != null) {
            if (courseService.updateCourseInfo(course) == 1) {
                object.put("code", 1);
                object.put("message", "修改课程成功！");
                return mapper.writeValueAsString(object);
            } else {
                object.put("code", 0);
                object.put("message", "修改课程失败！");
                return mapper.writeValueAsString(object);
            }
        } else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/selectAllCourseInfo")
    @ResponseBody
    public String selectAllCourseInfo(HttpSession session,@RequestParam("current") int current,@RequestParam("length") int length) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null){
            if (courseService.selectAllCourseInfo(current, length) != null){
                object.put("code", 1);
                object.put("message", "查询课程成功！");
                object.put("data",courseService.selectAllCourseInfo(current, length));
                return mapper.writeValueAsString(object);
            } else {
                object.put("code", 0);
                object.put("message", "未查询到任何课程！");
                return mapper.writeValueAsString(object);
            }
        } else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    //需要更改
//    @RequestMapping("/selectCourseInfo")
//    @ResponseBody
//    public String selectCourseInfo(HttpSession session,@Param("spe_Id") String spe_Id,@Param("current") int current,@Param("length") int length) throws JsonProcessingException {
//        JSONObject object = new JSONObject();
//        ObjectMapper mapper = new ObjectMapper();
//        if (session.getAttribute("login_session") != null) {
//            if (courseService.selectCourseInfo(spe_Id, current, length) != null) {
//                object.put("code", 1);
//                object.put("message", "查询课程成功！");
//                object.put("data",courseService.selectCourseInfo(spe_Id, current, length));
//                return mapper.writeValueAsString(object);
//            } else {
//                object.put("code", 0);
//                object.put("message", "未查询到任何课程！");
//                return mapper.writeValueAsString(object);
//            }
//        } else {
//            object.put("code", -1);
//            object.put("message", "登陆状态失效！请重新登录！");
//            return mapper.writeValueAsString(object);
//        }
//    }




}
