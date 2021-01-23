package com.huade.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.CollegeInfo;
import com.huade.pojo.User;
import com.huade.service.CollegeInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/collegeInfo")
public class CollegeInfoController {
    @Autowired
    @Qualifier("CollegeInfoServiceImpl")
    private CollegeInfoService collegeInfoService;

    @RequestMapping("/addCollegeInfo")
    @ResponseBody
    public String addCollegeInfo (HttpSession session, @RequestParam("Id") String Id, @RequestParam("col_Name") String col_Name) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        CollegeInfo collegeInfo = new CollegeInfo(Id,col_Name);
        if(session.getAttribute("login_session") != null ){
            if(collegeInfoService.addCollegeInfo(collegeInfo) == 1){
                object.put("code",1);
                object.put("message","添加学院信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",-1);
                object.put("messger","添加学院信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/deleteCollegeInfo")
    @ResponseBody
    public String deleteCollegeInfo(HttpSession session, @RequestParam("col_Id")String col_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null ){
            if(collegeInfoService.deleteCollegeInfo(col_Id) == 1){
                object.put("code",1);
                object.put("message","删除学院信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","删除学院信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("/updateCollegeInfo")
    @ResponseBody
    public String updateCollegeInfo(HttpSession session,@RequestParam("Id")String Id,@RequestParam("col_Name")String col_Name) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        CollegeInfo collegeInfo = new CollegeInfo(Id,col_Name);
        if(session.getAttribute("login_session") != null){
            if(collegeInfoService.updateCollegeInfo(collegeInfo) == 1){
                object.put("code",1);
                object.put("message","修改学院信息成功！");
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","修改学院信息失败！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);

        }

    }
    @RequestMapping("/selectAllCollegeInfo")
    @ResponseBody
    public String SelectAllCollegeInfo(HttpSession session) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        if(session.getAttribute("login_session") != null){
            if(collegeInfoService.selectAllCollegeInfo() !=null ){
                object.put("code",1);
                object.put("message","查询成功！");
                object.put("data",collegeInfoService.selectAllCollegeInfo());
                return mapper.writeValueAsString(object);
            }
            else {
                object.put("code",0);
                object.put("message","查询不到任何学院信息！");
                return mapper.writeValueAsString(object);
            }
        }
        else {
            object.put("code",-1);
            object.put("message","登陆状态失效！请重新登录！");
            return mapper.writeValueAsString(object);
        }
    }
    @RequestMapping("selectByCol_Id")
    @ResponseBody
    public String SelectBycol_Id(HttpSession session,@RequestParam("col_Id") String col_Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if(session.getAttribute("login_session") != null){
            if (collegeInfoService.selectCollegeInfo_col_Id(col_Id) != null){
                object.put("code",1);
                object.put("message","查询成功！");
                object.put("data",collegeInfoService.selectCollegeInfo_col_Id(col_Id));
                return mapper.writeValueAsString(object);

            }
            else {
                object.put("code",0);
                object.put("message","未查询到学院信息！");
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
