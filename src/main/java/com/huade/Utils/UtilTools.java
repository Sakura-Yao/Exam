package com.huade.Utils;

import com.huade.pojo.*;
import com.huade.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.util.*;

public class UtilTools {

    //定义调用的Service方法
    static ClassInfoServiceImpl classInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ClassInfoServiceImpl",ClassInfoServiceImpl.class);
    static CollegeInfoServiceImpl collegeInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("CollegeInfoServiceImpl",CollegeInfoServiceImpl.class);
    static CourseServiceImpl courseServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("CourseServiceImpl",CourseServiceImpl.class);
    static QuestionTypeServiceImpl questionTypeServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionTypeServiceImpl",QuestionTypeServiceImpl.class);
    static SpecialtyInfoServiceImpl specialtyInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("SpecialtyInfoServiceImpl",SpecialtyInfoServiceImpl.class);
    static StudentBasicServiceImpl studentBasicServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("StudentBasicServiceImpl",StudentBasicServiceImpl.class);
    static UserServiceImpl userServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("UserServiceImpl",UserServiceImpl.class);
    static UserTypeServiceImpl userTypeServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("UserTypeServiceImpl",UserTypeServiceImpl.class);
    static ClassCourseInfoServiceImpl classCourseInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ClassCourseInfoServiceImpl",ClassCourseInfoServiceImpl.class);
    static TeacherBasicServiceImpl teacherBasicServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("TeacherBasicServiceImpl",TeacherBasicServiceImpl.class);
    static KnowledgeServiceImpl knowledgeServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("KnowledgeServiceImpl",KnowledgeServiceImpl.class);


    /**
     * Spring提供的MD5加密方法
     * 将字符串转化为 32 位的MD5字符串
     * @param str 需要加密的字符串
     * @return String 加密后的MD5字符串
     */
    public static String Encrypted_MD5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }


    /**
     * 随机生成密码
     * 生成的密码共6位数字
     * @return String RandomPassword
     */
    public static String RandomPassword(){
        StringBuffer RandomPassword = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                RandomPassword.append(0);
            RandomPassword.append(num);
        }
        return RandomPassword.toString();
    }

    /**
     * 随机生成课程编号
     * 课程编号共10位 2位大写字母 + 8位随机数字（例如'TC75491231'）
     * @return String cou_Id
     */
    public static String RandomCourseId(){
        String[] arr = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        StringBuffer CourseId = new StringBuffer();
        for (int i = 0; i < 2; i++) {
            CourseId.append(arr[(int) ((Math.random())*26)]);
        }
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * 99) + 1;
            if (num < 10)
                CourseId.append(0);
            CourseId.append(num);
        }
        return CourseId.toString();
    }

    /**
     * 字符串转字符数组
     * @param str
     * @return
     */
    public static String[] StringToStringArr(String str){
        return str.split(",");
    }


    /**
     * 获取1级知识点的Id
     * 如果正确获取，返回值为该知识点的Id
     * 若错误，则返回字符串 'Error'
     * @param cou_Id 课程编号
     * @param chapter_Num 章节号
     * @return String Id（正确） String 'Error'（错误）
     */
    public static String GetLevel_1_Id(String cou_Id,String chapter_Num){
        List<View_Knowledge> knowledges = knowledgeServiceImpl.selectKnowledge("", cou_Id, "1", chapter_Num, "", 0, 1000);
        if (knowledges.size() == 1){
            return knowledges.get(0).getId();
        }
        else {
            return "Error";
        }
    }

    /**
     * 添加知识点信息
     * @param knowledge 实体类：知识点信息
     * @return 成功：int 1  失败：int 0
     */
    public static int AddKnowledge(Knowledge knowledge){
        if (knowledgeServiceImpl.selectKnowledge("", knowledge.getCou_Id(), knowledge.getKwl_Level(), knowledge.getChapter_Num(), knowledge.getSection_Num(), 0, 1000).size() == 0) {
            if (knowledge.getKwl_Level().equals("2")) {
                if (!(UtilTools.GetLevel_1_Id(knowledge.getCou_Id(), knowledge.getChapter_Num()).equals("Error"))) {
                    knowledge.setParent_Id(UtilTools.GetLevel_1_Id(knowledge.getCou_Id(), knowledge.getChapter_Num()));
                    return knowledgeServiceImpl.addKnowledge(knowledge);
                } else {
                    return 0;
                }
            } else {
                return knowledgeServiceImpl.addKnowledge(knowledge);
            }
        } else {
            return 0;
        }
    }


    /**
     * 一级知识点排序，排序方法："冒泡" 按照章节编号（即字段'chapter_Num'）进行顺序排序
     * 使用该方法的时候，把该方法复制到相应的Controller，直接调用即可
     * 不能调用该工具类下的此方法，有bug
     * @param list_know
     * @return
     */
    public static List<Sort_Knowledge> Sort_Level_1 (List<Sort_Knowledge> list_know){
        for (int i = 0; i < list_know.size()-1; i++) {
            for (int j = 0; j < list_know.size()-i-1; j++) {
                if (list_know.get(j).getChapter_Num() > list_know.get(j + 1).getChapter_Num()) {
                    Sort_Knowledge sort_knowledge = list_know.get(j);
                    list_know.remove(j);
                    list_know.add(j+1,sort_knowledge);
                }
            }
        }
        return list_know;
    }


    /**
     * 二级知识点排序，排序方法："冒泡" 按照小节编号（即字段'section_Num'）进行顺序排序
     * 使用该方法的时候，把该方法复制到相应的Controller，直接调用即可
     * 不能调用该工具类下的此方法，有bug
     * @param list_know
     * @return
     */
    public static List<Sort_Knowledge> Sort_Level_2 (List<Sort_Knowledge> list_know){
        for (int i = 0; i < list_know.size()-1; i++) {
            for (int j = 0; j < list_know.size()-i-1; j++) {
                if (list_know.get(j).getSection_Num() > list_know.get(j + 1).getSection_Num()) {
                    Sort_Knowledge sort_knowledge = list_know.get(j);
                    list_know.remove(j);
                    list_know.add(j+1,sort_knowledge);
                }
            }
        }
        return list_know;
    }

    /**
     * 制作批量添加用户信息的Excel模版
     *
     * @return 返回生成Excel的绝对路径
     */
    public static String MakeBatchAddUserMode(){
        String in_Path = "/Users/yaoyuan/Online_Exam/file/batch_mode/userInfo.xlsx";
        String out_Path = "/Users/yaoyuan/Online_Exam/file/批量添加用户信息.xlsx";
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(in_Path));
            out = new FileOutputStream(new File(out_Path));
            byte[] buffer = new byte[10000];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = 0;
        String data[] = new String[userTypeServiceImpl.selectAllUserType().size()];
        for (User_Type user_type : userTypeServiceImpl.selectAllUserType()) {
            data[index] = user_type.getUser_Type();
            index++;
        }
        index = 0;
        String college_Id[] = new String [collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (CollegeInfo collegeInfo : collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(out_Path));
            XSSFSheet sheet = workbook.getSheet("Sheet2");
            for (int i = 0; i < data.length; i++) {
                sheet.createRow(i).createCell(0).setCellValue(data[i]);
            }
            XSSFSheet sheet3 = workbook.getSheet("Sheet3");
            String[][] res = UtilTools.GetCol_Spe_Name();
            for (int i = 0; i < UtilTools.getCellMaxNum()+1; i++) {
                Row row = sheet3.createRow(i);
                for (int j = 0; j < collegeInfoServiceImpl.selectAllCollegeInfo().size(); j++) {
                    row.createCell(j).setCellValue(res[i][j]);
                }
            }
            for (int i = 0; i < collegeInfoServiceImpl.selectAllCollegeInfo().size(); i++) {
                Name name = workbook.createName();
                name.setNameName(sheet3.getRow(0).getCell(i).toString());
                String formula = "Sheet3!"+UtilTools.getRange(i,2,specialtyInfoServiceImpl.selectSpecialty_col_Id(college_Id[i]).size()+1);
                name.setRefersToFormula(formula);
            }
            XSSFSheet sheet4 = workbook.getSheet("Sheet4");
            String [] classInfo = UtilTools.getClassInfo();
            for (int i = 0; i < classInfo.length; i++) {
                sheet4.createRow(i).createCell(0).setCellValue(classInfo[i]);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(out_Path);
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out_Path;
    }


    /**
     * 批量添加用户信息
     *
     * @param file_Path 批量添加用户信息Excel表文件绝对路径
     * @return HashMap {Total_Num; Success_Num; Error_Message; Time_Spent}
     * @throws DuplicateKeyException 主键异常
     * @throws BadSqlGrammarException SQL语句语法错误检查对应的mapper.xml
     */
    public static Map<String ,String> BatchAddUserInfo(String file_Path) throws Exception{
        long start_time = new Date().getTime();
        String sheet_Name = "Sheet1";
        ExcelData excelData = new ExcelData(file_Path,sheet_Name);
        Map<String ,String> res_Map = new HashMap<>();
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        Integer success_Num = null;
        String res_Message = null;
        List<Map<String,Object>> userList = new ArrayList<>();
        List<Map<String,Object>> studentBasicList = new ArrayList<>();
        List<Map<String,Object>> teacherBasicList = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
            String user_Id = row.getCell(0).getStringCellValue();
            String password = UtilTools.Encrypted_MD5("123456");
            String user_Name = row.getCell(1).toString();
            String user_Type = userTypeServiceImpl.selectUserType_Name(row.getCell(2).toString());
            String class_Id = "";
            if (row.getCell(3)!=null) {
                row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                class_Id = classInfoServiceImpl.selectId(row.getCell(3).getStringCellValue());
            }
            String user_Sex = row.getCell(4).toString();
            String user_Mobile = "";
            if (row.getCell(5)!=null){
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                user_Mobile = row.getCell(5).getStringCellValue();
            }
            String col_Id = collegeInfoServiceImpl.selectCol_Id(row.getCell(6).toString());
            String spe_Id = specialtyInfoServiceImpl.selectSpe_Id(row.getCell(7).toString());
            Map<String,Object> user = new HashMap<>();
            user.put("user_Id",user_Id);
            user.put("password",password);
            user.put("user_Name",user_Name);
            user.put("user_Type",user_Type);
            user.put("user_Sex",user_Sex);
            user.put("user_Mobile",user_Mobile);
            userList.add(user);
            if (row.getCell(2).toString().equals("学生")){
                Map<String,Object> studentBasic = new HashMap<>();
                studentBasic.put("user_Id",user_Id);
                studentBasic.put("stu_ClassId",class_Id);
                studentBasic.put("stu_College",col_Id);
                studentBasic.put("stu_Specialty",spe_Id);
                studentBasicList.add(studentBasic);
            }else {
                Map<String,Object> teacherBasic = new HashMap<>();
                teacherBasic.put("user_Id",user_Id);
                teacherBasic.put("college_Id",col_Id);
                teacherBasic.put("specialty_Id",spe_Id);
                teacherBasicList.add(teacherBasic);
            }
        }
        try {
            success_Num = userServiceImpl.batchAddUser(userList);
            studentBasicServiceImpl.batchAddStudentBasicInfo(studentBasicList);
            teacherBasicServiceImpl.batchAddTeacherBasicInfo(teacherBasicList);
        } catch (DuplicateKeyException e) {
            res_Message = "存在学工号相同的数据，本次批量插入操作未被执行，请检查！";
        } catch (BadSqlGrammarException e){
            for (Map<String, Object> map : userList) {
               userServiceImpl.deleteUser(map.get("user_Id").toString());
            }
            res_Message = "内部错误，请联系开发人员！本次批量操作执行，但数据已被恢复。";
        }
        long end_time = new Date().getTime();
        res_Map.put("Total_num", String.valueOf(rows-1));
        if (success_Num != null) {
            res_Map.put("Success_num", success_Num.toString());
            res_Map.put("Error_Message",res_Message);
        }
        else {
            res_Map.put("Success_num", "0");
            res_Map.put("Error_Message",res_Message);
        }
        res_Map.put("Time_Spent", String.valueOf((end_time-start_time)));
        return res_Map;
    }



    //获取包含专业最大数目（用于生成批量添加用户信息Excel文件）
    public static int getCellMaxNum(){
        int index = 0;
        String college_Id[] = new String [collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        String college[] = new String [collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (CollegeInfo collegeInfo : collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college[index] = collegeInfo.getCol_Name();
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        int max = 0;
        for (String s : college_Id) {
            int size = specialtyInfoServiceImpl.selectSpecialty_col_Id(s).size();
            max = Math.max(size, max);
        }
        return max;
    }

    //获取全部学院和专业的名称信息（用于生成批量添加用户信息Excel文件）
    public static String[][] GetCol_Spe_Name(){
        int index = 0;
        int speMaxNum = getCellMaxNum();
        String college_Id[] = new String [collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        String college[] = new String [collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (CollegeInfo collegeInfo : collegeInfoServiceImpl.selectAllCollegeInfo()) {
            college[index] = collegeInfo.getCol_Name();
            college_Id[index] = collegeInfo.getId();
            index++;
        }
        String [][] arr = new String [speMaxNum+1][collegeInfoServiceImpl.selectAllCollegeInfo().size()];
        for (int i = 0; i < collegeInfoServiceImpl.selectAllCollegeInfo().size(); i++) {
            arr[0][i] = college[i];
            index = 0;
            String specialty[] = new String [getCellMaxNum()];
            for (Specialty specialty1 : specialtyInfoServiceImpl.selectSpecialty_col_Id(college_Id[i])) {
                specialty[index] = specialty1.getSpe_Name();
                index++;
            }
            for (int j = 0; j < speMaxNum; j++) {
                arr[j+1][i] = specialty[j];
            }
        }
//        测试代码
//        for (int i = 0; i < speMaxNum+1; i++) {
//            for (int j = 0; j < collegeInfoServiceImpl.selectAllCollegeInfo().size(); j++) {
//                System.out.print(arr[i][j]+"  ");
//            }
//            System.out.println();
//        }
        return arr;
    }


    /**
     *  计算formula（用于生成批量添加用户信息Excel文件）
     * @param rowId 第几行
     * @param rowCount 一共多少行
     * @return 如果给入参 1,1,10. 表示从B1-K1。最终返回 $B$1:$K$1
     *
     */
    public static String getRange(int colId, int rowId, int rowCount) {
        char res_letter = (char)('A'+colId);
        return "$"+res_letter+"$"+rowId+":$"+res_letter+"$"+rowCount;
    }


    //获取班级信息
    public static String[] getClassInfo(){
        int size = classInfoServiceImpl.selectAllClassInfo().size();
        String[] classInfo = new String [size];
        int index = 0;
        for (View_ClassInfo info : classInfoServiceImpl.selectAllClassInfo()) {
            classInfo[index] = info.getClass_Id();
            index++;
        }
        return classInfo;
    }



}
