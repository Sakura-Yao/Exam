package com.huade.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huade.Utils.ExcelData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

@Controller
public class FileController {

    @RequestMapping("/upload")
    public String upload (@RequestParam("file") CommonsMultipartFile file) throws IOException{
        String uploadFileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        JSONObject object = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();
        if ("".equals(uploadFileName)) {
            object.put("code",0);
            object.put("message","上传失败！请重试！");
            return mapper.writeValueAsString(object);
        }
        String path = "/Users/yaoyuan/Online_Exam/file/batch_addition";
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        InputStream inputStream = file.getInputStream();//文件输入流
        OutputStream outputStream = new FileOutputStream(new File(realPath,uuid+uploadFileName));//文件输出流

        //读写
        int len = 0;
        byte[] buffer = new byte[10240];
        while ((len=inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        String file_path = realPath+"/"+uuid+uploadFileName;
        System.out.println("File_Path:" + file_path);
        return file_path;
    }


    @RequestMapping("/download")
    public String downloads(HttpServletResponse response,
                            @Param("fileName")String fileName) throws Exception{
        String path = "/usr/File/download";

        //设置response响应头
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-date");//二进制传输数据

        //设置响应头
        response.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(path,fileName);

        //读取文件--输入流
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[10240];
        int index = 0;
        while ((index = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer,0,index);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return null;
    }

}
