package com.huade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.ClassCourseInfo;
import com.huade.service.ClassCourseInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;

@Controller
@RequestMapping("/classCourseInfo")
public class ClassCourseInfoController {
    @Autowired
    @Qualifier("ClassCourseInfoServiceImpl")
    private ClassCourseInfoService classCourseInfoService;

    @RequestMapping("/addClassCourseInfo")
    @ResponseBody
    public String addClassCourseInfo(HttpSession session,@Param("classes_Id") String classes_Id,@Param("user_Id") String user_Id,@Param("cou_Id") String cou_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        ClassCourseInfo classCourseInfo = new ClassCourseInfo(classes_Id, user_Id, cou_Id);
        if(session.getAttribute("login_session") != null){
            if (classCourseInfoService.addClassCourseInfo(classCourseInfo) == 1){
                object.put("code",1);
                object.put("message","添加成功");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","添加失败");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }

    @RequestMapping("/deleteClassCourseInfo")
    @ResponseBody
    public String deleteClassCourseInfo(HttpSession session,@Param("classes_Id") String classes_Id,@Param("user_Id") String user_Id,@Param("cou_Id") String cou_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        ClassCourseInfo classCourseInfo = new ClassCourseInfo(classes_Id, user_Id, cou_Id);
        if(session.getAttribute("login_session") != null){
            if (classCourseInfoService.deleteClassCourseInfo(classCourseInfo) == 1){
                object.put("code",1);
                object.put("message","删除成功");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","删除失败");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/updateClassCourseInfo")
    @ResponseBody
    public String updateClassCourseInfo(HttpSession session,@Param("new_classes_Id") String new_classes_Id,@Param("new_user_Id") String new_user_Id,@Param("new_cou_Id") String new_cou_Id,@Param("old_classes_Id") String old_classes_Id,@Param("old_user_Id") String old_user_Id,@Param("old_cou_Id") String old_cou_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        ClassCourseInfo new_classCourseInfo = new ClassCourseInfo(new_classes_Id, new_user_Id, new_cou_Id);
        ClassCourseInfo old_classCourseInfo = new ClassCourseInfo(old_classes_Id, old_user_Id, old_cou_Id);
        if (session.getAttribute("login_session") != null){
            if (classCourseInfoService.updateClassCourseInfo(new_classCourseInfo,old_classCourseInfo) == 1){
                object.put("code",1);
                object.put("message","修改成功");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","修改失败");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/selectAllClassCourseInfo")
    @ResponseBody
    public String selectAllClassCourseInfo(HttpSession session, @Param("current") int current,@Param("length") int length) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null){
            if (classCourseInfoService.selectAllClassCourseInfo(current, length) != null){
                object.put("code",1);
                object.put("message","查询成功");
                object.put("data",classCourseInfoService.selectAllClassCourseInfo(current, length));
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","未查询到任何信息");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/selectClassCourseInfo")
    @ResponseBody
    public String selectClassCourseInfo(HttpSession session,@Param("class_Id") String[] class_Id,@Param("user_Id") String user_Id,@Param("cou_Id") String cou_Id,@Param("current") int current,@Param("length") int length) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (session.getAttribute("login_session") != null){
            if (classCourseInfoService.selectClassCourseInfo(class_Id,user_Id,cou_Id,current,length) != null){
                object.put("code",1);
                object.put("message","查询成功");
                return mapper.writeValueAsString(object);
            }else {
                object.put("code",0);
                object.put("message","未查询到任何信息");
                return mapper.writeValueAsString(object);
            }
        }else {
            object.put("code", -1);
            object.put("message", "登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);


        }
    }



}
