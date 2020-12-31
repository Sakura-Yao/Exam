package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.pojo.QuestionInfo;
import com.huade.pojo.Test_Ueditor;
import com.huade.service.QuestionInfoServiceImpl;
import com.huade.service.TestUEditorServiceImpl;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    @Qualifier("TestUEditorServiceImpl")
    private TestUEditorServiceImpl testUEditorService;

    @RequestMapping(value="/uploadImage",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> uploadImage(@Param("upfile") MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String realName = null;
        String uuidName = null;
        String realPath = null;

        try {
            realName = getRealName(file.getOriginalFilename());
            uuidName = getUUIDFileName(file.getOriginalFilename());

            realPath = "/Users/yaoyuan/Online_Exam/file/image";
            InputStream in = new BufferedInputStream(file.getInputStream());
            OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(realPath,uuidName)));
            IOUtils.copy(in,out);
            map.put("state", "SUCCESS");
            map.put("url","/images/"+uuidName);
            map.put("title",realName);
            map.put("original",realName);
        } catch (IOException e) {
            map.put("state", "文件上传失败,请联系管理员");
            map.put("url","");
            map.put("title","");
            map.put("original","");
        }
        //存入数据库方法
        return map;
    }

    private String getExtName(String s, char split) {
        int i = s.lastIndexOf(split);
        int leg = s.length();
        return i > 0 ? (i + 1) == leg ? " " : s.substring(i+1, s.length()) : " ";
    }

    private String getUUIDFileName(String fileName){
        UUID uuid = UUID.randomUUID();
        StringBuilder sb = new StringBuilder(100);
        sb.append(uuid.toString().replace("-","")).append(".").append(this.getExtName(fileName, '.'));
        return sb.toString();
    }

    private String getRealName(String originalName){
        //System.out.println(originalName.contains("."));

        if(originalName.contains(".")){
            String [] as = originalName.split("\\.");
            //System.out.println(as[0]);
            return as[0];
        }else {
            return originalName;
        }

    }

    @RequestMapping("/testSelect")
    @ResponseBody
    public String testSelect(@RequestParam("Id")String Id) throws JsonProcessingException{
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        Test_Ueditor test_ueditor = testUEditorService.selectTestInfo(Id);
        object.put("code",1);
        object.put("res",test_ueditor.getText());
        return mapper.writeValueAsString(object);
    }

    @RequestMapping("/uploading")
    @ResponseBody
    public String uploading(@RequestParam("question")String question,
                            @RequestParam("answer")String answer) throws JsonProcessingException {
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        String cou_Id = "LT96785089";
        String type_Id = "a3514b0394a940cea19d5e1ef74b041f";
        // editorValue 为富文本编译器提交的内容
        System.out.println("Question:"+question);
        System.out.println("Answer:"+answer);
        String uuid = UUID.randomUUID().toString().replace("-","");
        QuestionInfoServiceImpl questionInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionInfoServiceImpl", QuestionInfoServiceImpl.class);
        QuestionInfo questionInfo = new QuestionInfo(uuid,cou_Id,type_Id,question,"--","--","--","--",answer,"0.65","2a58739e2ea04f1aa69da84726836e8f","");
        int res = questionInfoServiceImpl.addQuestionInfo(questionInfo);

        return String.valueOf(res);
    }

}
