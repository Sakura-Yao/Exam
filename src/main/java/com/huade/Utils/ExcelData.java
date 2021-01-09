package com.huade.Utils;

import com.alibaba.fastjson.JSONObject;

import com.huade.pojo.Knowledge;
import org.apache.poi.hssf.record.aggregates.RowRecordsAggregate;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelData {

    public XSSFSheet sheet;
    //private XSSFSheet sheet;

    public ExcelData(String filePath,String sheetName) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook sheets = new XSSFWorkbook(fileInputStream);
            //获取sheet
            sheet = sheets.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 根据某一列值为"*****"的这一行，来获取该行第x列的值
     * @param caseName 值
     * @param currentColumn 当前单元格列的索引
     * @param targetColumn 目标单元格列的索引
     * @return
     */
    public String getCellByCaseName(String caseName,int currentColumn,int targetColumn){
        String operateSteps = "";
        //获取行数
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            String cell = row.getCell(currentColumn).toString();
            if (cell.equals(caseName)){
                operateSteps = row.getCell(targetColumn).toString();
                break;
            }
        }
        return operateSteps;
    }

    //获取excel全部数据
    public List readExcelData(){
        ArrayList<String> list = new ArrayList<String>();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rows; i++) {
            XSSFRow row = sheet.getRow(i);
            int columns  = row.getPhysicalNumberOfCells();
            for (int j = 0; j < columns; j++) {
                list.add(row.getCell(j).toString());
            }
        }
        return list;
    }

    public JSONObject readExcelDataForJson(){
        JSONObject object = new JSONObject(true);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (i == 1)
                continue;
            ArrayList<String> values = new ArrayList<String>();
            XSSFRow row = sheet.getRow(i);
            //获取每一行有多少列数据
            int columns = row.getPhysicalNumberOfCells();
            //获取每行第一列的数据 即Key
            String key = row.getCell(0).toString();
            for (int j = 1; j < columns; j++) {
                values.add(row.getCell(j).toString());
            }
            object.put(key,values);
        }
        return object;
    }



//    /**
//     * 批量添加知识点信息
//     * @param filePath 文件名
//     * @param sheetName 表名
//     * @return Map集合（总数目'Total_num' 成功数目'Success_num' 失败数目'Error_num' 所用时间'Time_spent'）
//     */
//    public static Map batch_knowledge (String filePath,String sheetName){
//        Map<String,String> map = new HashMap<String, String>();
//        ExcelData excelData = new ExcelData(filePath,sheetName);
//        Integer Rows = excelData.sheet.getPhysicalNumberOfRows();
//        Integer Success_num = 0;
//        Integer Error_num = 0;
//        long start_time = new Date().getTime();
//        //首先执行一遍逐行获取行列信息，以检查Excel表的完整性和可阅读性
//        for (int i = 0; i < Rows; i++) {
//            XSSFRow row = excelData.sheet.getRow(i);
//        }
//        //然后在进行批量导入数据
//        for (int i = 1; i < Rows; i++) {
//            XSSFRow row = excelData.sheet.getRow(i);
//            String cou_Id = row.getCell(0).toString();
//            String kwl_Level = row.getCell(1).toString();
//            String chapter_Num = row.getCell(2).toString();
//            String section_Num = row.getCell(3).toString();
//            String kwl_Name = row.getCell(4).toString();
//            String uuid = UUID.randomUUID().toString().replace("-","");
//            Knowledge knowledge = new Knowledge(uuid,cou_Id,kwl_Level,chapter_Num,section_Num,kwl_Name,"");
//            if (UtilTools.AddKnowledge(knowledge)==1)
//                Success_num++;
//            else
//                Error_num++;
//        }
//        long end_time = new Date().getTime();
//        Rows = Rows - 1;
//        map.put("Total_num",Rows.toString());
//        map.put("Success_num",Success_num.toString());
//        map.put("Error_num",Error_num.toString());
//        map.put("Time_spent",(end_time-start_time)+"");
//        return map;
//    }
//
//
//    //批量添加学生信息
//    public static Map batch_Student_Info (String filePath,String sheetName){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PublicService publicService = (PublicService) context.getBean("PublicServiceImpl");
//
//        Map<String,String> map = new HashMap<String, String>();
//        ExcelData excelData = new ExcelData(filePath,sheetName);
//        Integer Rows = excelData.sheet.getPhysicalNumberOfRows();
//        Integer Success_num = 0;
//        long start_time = new Date().getTime();
//        //首先执行一遍逐行获取行列信息，检查Excel表的完整性和可阅读性
//        for (int i = 0; i < Rows; i++) {
//            XSSFRow row = excelData.sheet.getRow(i);
//        }
//        //然后在进行批量导入数据
//        for (int i = 1; i < Rows; i++) {
//            XSSFRow row = excelData.sheet.getRow(i);
//            String user_id = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 0);
//            String password = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 1);
//            String name = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 2);
//            String stu_class = excelData.getCellByCaseName(row.getCell(0).toString(),0,3);
//            String sex = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 4);
//            String mobile = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 5);
//            String college = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 6);
//            String specialty = excelData.getCellByCaseName(row.getCell(0).toString(), 0, 7);
//            User user = new User(user_id,password,"Student",name,stu_class,sex,mobile,college,specialty);
//            publicService.add_User(user);
//            Success_num++;
//        }
//        long end_time = new Date().getTime();
//        Rows = Rows - 1;
//        map.put("Total_num",Rows.toString());
//        map.put("Success_num",Success_num.toString());
//        map.put("Time_spent",(end_time-start_time)+"");
//        return map;
//    }



    public static void main(String[] args) {
        Map sheet1 = UtilTools.batch_knowledge("/Users/yaoyuan/Online_Exam/SpringBoot.xlsx", "Sheet1");
        System.out.println(sheet1);
    }
}
