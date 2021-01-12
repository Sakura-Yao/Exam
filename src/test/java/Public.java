import com.huade.Utils.ExcelData;
import com.huade.Utils.UtilTools;
import com.huade.pojo.*;
import com.huade.service.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;

import java.io.*;
import java.util.*;

public class Public {

    //分行显示数据
    public void ShowInfo(Object[] objects){
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    //定义调用的Service方法
    private ClassInfoServiceImpl classInfoServiceImpl = (ClassInfoServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ClassInfoServiceImpl");
    private CollegeInfoServiceImpl collegeInfoServiceImpl = (CollegeInfoServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("CollegeInfoServiceImpl");
    private CourseServiceImpl courseServiceImpl = (CourseServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("CourseServiceImpl");
    private QuestionTypeServiceImpl questionTypeServiceImpl = (QuestionTypeServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionTypeServiceImpl");
    private SpecialtyInfoServiceImpl specialtyInfoServiceImpl = (SpecialtyInfoServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("SpecialtyInfoServiceImpl");
    private StudentBasicServiceImpl studentBasicServiceImpl = (StudentBasicServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("StudentBasicServiceImpl");
    private UserServiceImpl userServiceImpl = (UserServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("UserServiceImpl");
    private UserTypeServiceImpl userTypeServiceImpl = (UserTypeServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("UserTypeServiceImpl");
    private ClassCourseInfoServiceImpl classCourseInfoServiceImpl = (ClassCourseInfoServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ClassCourseInfoServiceImpl");
    private TeacherBasicServiceImpl teacherBasicServiceImpl = (TeacherBasicServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("TeacherBasicServiceImpl");
    private KnowledgeServiceImpl knowledgeServiceImpl = (KnowledgeServiceImpl) new ClassPathXmlApplicationContext("applicationContext.xml").getBean("KnowledgeServiceImpl");
    private TestUEditorServiceImpl testUEditorServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("TestUEditorServiceImpl",TestUEditorServiceImpl.class);

    public List<Sort_Knowledge> Sort_Level_1 (List<Sort_Knowledge> list_know){
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

    public List<Sort_Knowledge> Sort_Level_2 (List<Sort_Knowledge> list_know){
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

    @Test
    public void EasyTest(){
        List<Sort_Knowledge> list_know = new ArrayList<>();
        List<View_Knowledge> view_knowledges = knowledgeServiceImpl.selectKnowledge("", "", "1", "", "", 0, 1000);
        for (View_Knowledge view_knowledge : view_knowledges) {
            Sort_Knowledge knowledge = new Sort_Knowledge(view_knowledge.getId(),view_knowledge.getCou_Name(),Integer.valueOf(view_knowledge.getKwl_Level()),
                    Integer.valueOf(view_knowledge.getChapter_Num()),Integer.valueOf(view_knowledge.getSection_Num()),view_knowledge.getKwl_Name());
            list_know.add(knowledge);
        }
        ShowInfo(Sort_Level_1(list_know).toArray());
    }

    @Test
    public void EasyTest1(){
        List<Sort_Knowledge> list_know = new ArrayList<>();
        List<View_Knowledge> view_knowledges = knowledgeServiceImpl.selectKnowledge("", "", "2", "5", "", 0, 1000);
        for (View_Knowledge view_knowledge : view_knowledges) {
            Sort_Knowledge knowledge = new Sort_Knowledge(view_knowledge.getId(),view_knowledge.getCou_Name(),Integer.valueOf(view_knowledge.getKwl_Level()),
                    Integer.valueOf(view_knowledge.getChapter_Num()),Integer.valueOf(view_knowledge.getSection_Num()),view_knowledge.getKwl_Name());
            list_know.add(knowledge);
        }
        ShowInfo(Sort_Level_2(list_know).toArray());
    }


    public String uuid (){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void getuuid(){
//        System.out.println(uuid());

    }
    @Test
    public void test_makeUUID(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uuid());
        stringBuilder.append(uuid());
        System.out.println(stringBuilder.toString());
        System.out.println(stringBuilder.toString().length());
    }

    @Test
    public void test_edit_password (){
        System.out.println(classInfoServiceImpl.selectAllClassInfo().size());
        System.out.println(classInfoServiceImpl.selectClassInfo("","","",0,0).size());
    }

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-i-1; j++) {
                Integer temp = list.get(j);
                list.remove(j);
                list.add(j+1,temp);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test2(){
        System.out.println(specialtyInfoServiceImpl.selectAllSpecialty());
    }

    @Test
    public void test3(){
        System.out.println(userTypeServiceImpl.selectUserType_Id("c8d4c17743b14deebda71170c43f12b4"));
    }

    @Test
    public void test4(){
        String str = "英语，俄语，123";
        str = str.replace("，",",");
        System.out.println(str);
    }

    @Test
    public void test5(){
        String[] class_Id = UtilTools.StringToStringArr("371d08cd9f064b758d161d1ce4271abc,0d465103dba84396a16a3e873b0d9c90");
        ShowInfo(classCourseInfoServiceImpl.selectClassCourseInfo(class_Id,"","",0,100).toArray());
    }

    @Test
    public void test6(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        ClassInfo classInfo = new ClassInfo(uuid,"1801712","0","75d2a68ba28146e08414f1a6f9c3afef","f02f730c6fb642ed894f75b8c8d63c20");
        System.out.println(classInfoServiceImpl.selectAllClassInfo());
    }

    @Test
    public void test7(){
        List<View_StudentBasicInfo> view_studentBasicInfos = studentBasicServiceImpl.selectStudentBasic("", "", "", "", "", 0, 1000);
        System.out.println("Total:"+view_studentBasicInfos.size());
        for (View_StudentBasicInfo view_studentBasicInfo : view_studentBasicInfos) {
            System.out.println(view_studentBasicInfo);
        }
    }


    @Test
    public void test8(){
        StringBuffer str = new StringBuffer("19240453");
        str.append("\n这是一个QQ号");
        str.insert(5,"29");
        str.setCharAt(2,'2');
        str.delete(1,3);
        System.out.println(str.toString());
    }

    @Test
    public void testRandom(){
        System.out.println(UtilTools.RandomCourseId());
    }

    @Test
    //Spring的md5加密算法
    public void testSpringMD5(){
        String password = "admin";
        System.out.println(UtilTools.Encrypted_MD5(password));
    }

    @Test
    public void test9(){
        System.out.println(courseServiceImpl.selectAllCourseInfo(0, 1000));
    }

    @Test
    public void test10(){
        String user_Id = "1180130116";
        String password = UtilTools.Encrypted_MD5("123456");
        System.out.println(userServiceImpl.Login(user_Id, password));
    }

    @Test
    public void test11() throws Exception {
        String uuid = UUID.randomUUID().toString().replace("-","");
        List<Map<String,Object>> infoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String ,Object> map = new HashMap<>();
            map.put("Id",i);
            map.put("text","map"+i);
            infoList.add(map);
        }
        Map<String ,Object> map = new HashMap<>();
        map.put("Id",2);
        map.put("text","map"+1);
        map.put("psp","pap");
        infoList.add(map);
        System.out.println(infoList);
        try {
            System.out.println(testUEditorServiceImpl.batchAddTestInfo(infoList));
        } catch (DuplicateKeyException e) {
            System.out.println("发生主键异常！存在主键相同的值，本次插入未被执行，请检查！");
        }
    }

    @Test
    //用户批量导入信息
    public void test12() throws Exception{
        String file_Path = "/Users/yaoyuan/Online_Exam/file/batch_addition/user.xlsx";
        String sheet_Name = "user";
        ExcelData excelData = new ExcelData(file_Path,sheet_Name);
        int rows = excelData.sheet.getPhysicalNumberOfRows();
        List<Map<String,Object>> userList = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            XSSFRow row = excelData.sheet.getRow(i);
            String user_Id = row.getCell(0).toString();
            String password = "123456";
            String user_Name = row.getCell(1).toString();
            String user_Type = userTypeServiceImpl.selectUserType_Name(row.getCell(2).toString());
            String user_Sex = row.getCell(3).toString();
            String user_Mobile = row.getCell(4).toString();
            Map<String,Object> user = new HashMap<>();
            user.put("user_Id",user_Id);
            user.put("password",password);
            user.put("user_Name",user_Name);
            user.put("user_Type",user_Type);
            user.put("user_Sex",user_Sex);
            user.put("user_Mobile",user_Mobile);
            userList.add(user);
        }
        try {
            System.out.println(userServiceImpl.batchAddUser(userList));
        } catch (DuplicateKeyException e) {
            System.out.println("发生主键异常！存在主键相同的值，本次插入未被执行，请检查！");
        }
        //System.out.println(excelData.readExcelData());
    }

    @Test
    public void test13()throws Exception{
        Map<String, String> map = UtilTools.BatchAddUserInfo("/Users/yaoyuan/Online_Exam/file/batch_addition/user.xlsx");
        System.out.println(map);
    }

    @Test
    public void test14(){
        ExcelData excelData = new ExcelData("/Users/yaoyuan/Online_Exam/file/batch_addition/test.xlsx","Sheet1");
        System.out.println(excelData.readExcelData());
        XSSFRow row = excelData.sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
        System.out.println(row.getCell(0).getStringCellValue());
    }

    @Test
    //生成表格文件
    public void test15(){
        String type_data[] = {"学生","教师","教学秘书"};
        XSSFWorkbook workbook = new XSSFWorkbook();
        //XSSFSheet sheet1 = workbook.createSheet("Sheet1");
        XSSFSheet sheet2 = workbook.createSheet("Sheet2");
        for (int i = 0; i < type_data.length; i++) {
            sheet2.createRow(i).createCell(0).setCellValue(type_data[i]);
        }
        try {
            workbook.write(new FileOutputStream(new File("/Users/yaoyuan/Online_Exam/file/batch_mode/userInfo.xlsx")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test16(){
        String in_Path = "/Users/yaoyuan/Online_Exam/file/batch_mode/courseInfo.xlsx";
        System.out.println(UtilTools.MakeBatchAddCourseInfo(in_Path));
    }



    @Test
    public void test17() throws Exception{
        System.out.println(UtilTools.BatchAddUserInfo("/Users/yaoyuan/Online_Exam/file/批量添加用户信息.xlsx"));
    }

    @Test
    public void test18(){

    }


}
