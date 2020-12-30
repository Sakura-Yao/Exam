package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.Utils.UtilTools;
import com.huade.pojo.User;
import com.huade.service.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserServiceImpl userService;


    @RequestMapping("/getSession")
    @ResponseBody
    public String getSession(HttpSession session, @RequestParam("key")String key)throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        object.put("session_data",session.getAttribute(key));
        return mapper.writeValueAsString(object);
    }

    @RequestMapping("/UserLogin")
    @ResponseBody
    public String UserLogin(HttpSession session, @Param("user_Id")String user_Id, @Param("password")String password)throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if (userService.Login(user_Id, UtilTools.Encrypted_MD5(password)) != null){
            User user = userService.Login(user_Id,UtilTools.Encrypted_MD5(password));
            session.setAttribute("login_session",user);
            object.put("code",1);
            object.put("message","success");
            object.put("data",user);
            return mapper.writeValueAsString(object);
        }else {
            object.put("code",0);
            object.put("message","登陆失败！");
            return mapper.writeValueAsString(object);
        }
    }


}
