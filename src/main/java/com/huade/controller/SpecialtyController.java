package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.Specialty;
import com.huade.service.SpecialtyInfoService;
import com.mysql.cj.protocol.x.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Specialty")
public class SpecialtyController {
    @Autowired
    @Qualifier("SpecialtyInfoServiceImpl")
    private SpecialtyInfoService specialtyInfoService;

    @RequestMapping("/addSpecialtyInfo")
    @ResponseBody
    public String addSpecialtyInfo(HttpSession session, @Param("Id") String Id,@Param("spe_Name") String spe_Name,@Param("cou_Id") String cou_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        Specialty specialty = new Specialty(Id,spe_Name,cou_Id);
        if(session.getAttribute("login_session") != null){
            if(specialtyInfoService.addSpecialtyInfo(specialty) == 1){
                object.put("code",1);
                object.put("message","添加专业信息成功！");
                return mapper.writeValueAsString(object);

            }
            else {
                object.put("code",0);
                object.put("message","添加专业信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }

    }
    @RequestMapping("/deleteSpecialtyInfo")
    @ResponseBody
    public String deleteSpecialtyInfo(HttpSession session, @Param("Id") String Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null){
            if(specialtyInfoService.deleteSpecialtyInfo(Id) == 1){
                object.put("code",1);
                object.put("message","删除专业信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","删除专业信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/updateSpecialtyInfo")
    @ResponseBody
    public String updateSpecialtyInfo(HttpSession session,@Param("Id") String Id,@Param("spe_Name") String spe_Name,@Param("col_Id") String col_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        Specialty specialty = new Specialty(Id,spe_Name,col_Id);
        if(session.getAttribute("login_session") != null){
            if (specialtyInfoService.updateSpecialtyInfo(specialty) == 1){
                object.put("code",1);
                object.put("message","修改专业信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","修改专业信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/selectAllSpecialty")
    @ResponseBody
    public String selectAllSpecialty(HttpSession session) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null){
            if(specialtyInfoService.selectAllSpecialty() != null){
                object.put("code",1);
                object.put("message","查询专业信息成功！");
                object.put("data",specialtyInfoService.selectAllSpecialty());
                return mapper.writeValueAsString(object);

            }else {
                object.put("code",0);
                object.put("message","查询不到任何专业信息！");
                return mapper.writeValueAsString(object);
            }

        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/selectCollegeInfo_col_Id")
    @ResponseBody
    public String selectCollegeInfo_col_Id(HttpSession session,@Param("col_Id") String col_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null){
            if(specialtyInfoService.selectSpecialty_col_Id(col_Id) != null){
                object.put("code",1);;
                object.put("message","查询专业信息成功！");
                object.put("data",specialtyInfoService.selectSpecialty_col_Id(col_Id));
                return mapper.writeValueAsString(object);

            }else {
                object.put("code",0);
                object.put("message","查询不到任何专业信息");
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
