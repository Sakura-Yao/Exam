import com.huade.pojo.Exam_Generate;
import com.huade.pojo.QuestionInfo;
import com.huade.pojo.QuestionTimes;
import com.huade.service.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class ExamTest {

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
    private ExamPlanServiceImpl examPlanServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ExamPlanServiceImpl",ExamPlanServiceImpl.class);
    private ExamPaperServiceImpl examPaperServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ExamPaperServiceImpl",ExamPaperServiceImpl.class);
    private ExamGenerateServiceImpl examGenerateServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("ExamGenerateServiceImpl",ExamGenerateServiceImpl.class);
    private QuestionTimesServiceImpl questionTimesServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionTimesServiceImpl",QuestionTimesServiceImpl.class);
    private QuestionInfoServiceImpl questionInfoServiceImpl = new ClassPathXmlApplicationContext("applicationContext.xml").getBean("QuestionInfoServiceImpl",QuestionInfoServiceImpl.class);

    @Test
    public void t1(){
        Exam_Generate exam_generate = new Exam_Generate("t01","b237ec4f97b94272bf084479b34fbe57","t01");
        System.out.println(exam_generate.getExam_Plan_Id());
        System.out.println(examGenerateServiceImpl.addExamGenerate(exam_generate));
    }

    @Test
    public void t2(){
        List<QuestionInfo> questionInfos = questionInfoServiceImpl.selectQuestionInfo("", "", "", "", "", 0, 0);
        for (QuestionInfo questionInfo : questionInfos) {
            QuestionTimes questionTimes = new QuestionTimes(questionInfo.getId(), 0);
            System.out.println(questionTimesServiceImpl.addQuestionTimesInfo(questionTimes));
        }
//        questionTimesServiceImpl.addQuestionTimesInfo();
    }

    @Test
    public void t3(){
        System.out.println(questionTimesServiceImpl.addQuestionTimesInfo(new QuestionTimes("fb5f000deffa4ed3b2ff0330ed044ff7",0)));
    }

    @Test
    public void t4(){
        String Id = UUID.randomUUID().toString().replace("-","");
        QuestionInfo questionInfo = new QuestionInfo(Id,"test01","9d1ec85c8fdd40ba8b4cc733d4d72581","","","","","","","","2a58739e2ea04f1aa69da84726836e8f","");
        questionInfoServiceImpl.addQuestionInfo(questionInfo);
    }

    @Test
    public void t5(){
        String[] type = {"1f45bd0005c541b998731546b3b8909a","9d1ec85c8fdd40ba8b4cc733d4d72581","a3514b0394a940cea19d5e1ef74b041f",
        "b5046eea8c484ec8ab011da3a650a1e5","3eb9b37cff394f3fa9a1a052e1685105","fd09a3873f184169b4fd335934078123","1996a697e26a4453a80900a82c1df699"};
        String [] degree = {"0.45","0.65","0.25","0.45","0.65","0.25","0.45","0.25","0.65","0.45"};
        //随机生成1000道题目
        int success = 0;
        for (int i = 1; i <= 1000; i++) {
            String uuid = UUID.randomUUID().toString().replace("-","");
            QuestionInfo questionInfo = new QuestionInfo(uuid,"test01",type[(int)(Math.random()*7)],"测试试题"+i,"-","-","-","-","测试答案",
                    degree[(int)(Math.random()*10)],"test01","测试解析");
            success = success + questionInfoServiceImpl.addQuestionInfo(questionInfo);
            QuestionTimes questionTimes = new QuestionTimes(uuid,0);
            success = success + questionTimesServiceImpl.addQuestionTimesInfo(questionTimes);
        }
        System.out.println(success);
    }

    @Test
    public void t6(){
        int [] res = {0,0,0,0,0,0,0};
        for (int i = 0; i < 1000; i++) {
            res[(int)(Math.random()*4)]++;
        }
        System.out.println(Arrays.toString(res));
    }

    public double t7(){
        String[] type = {"1f45bd0005c541b998731546b3b8909a","9d1ec85c8fdd40ba8b4cc733d4d72581","a3514b0394a940cea19d5e1ef74b041f",
                "b5046eea8c484ec8ab011da3a650a1e5","3eb9b37cff394f3fa9a1a052e1685105","fd09a3873f184169b4fd335934078123","1996a697e26a4453a80900a82c1df699"};
        String cou_Id = "test01";
        Random random = new Random();
        double degree_avg = 0;
        for (String s : type) {
//            System.out.println(questionTypeServiceImpl.selectQuestionType_Id(s)+":");
            List<Map<String,String>> res =new ArrayList<Map<String,String>>();
            for (int i = 0; i < 10; i++) {
                Map<String,String> map = new HashMap<>();
                List<QuestionInfo> questionInfos = questionInfoServiceImpl.selectQuestionInfo("", cou_Id, s, "", "", 0, 0);
                int num = random.nextInt(questionInfos.size());
                QuestionInfo questionInfo = questionInfos.get(num);
                map.put("Id",questionInfo.getId());
                map.put("Degree",questionInfo.getDegree());
                res.add(map);
            }
        for (Map<String, String> re : res) {
            //System.out.println(re.get("Id")+"\t"+re.get("Degree"));
            degree_avg += Double.parseDouble(re.get("Degree"));
        }
        //System.out.println();
        }
        //System.out.println("总体难度系数："+degree_avg/50);
        return degree_avg/50;
    }

    @Test
    public void t8(){
        double res = t7();
        int num = 1;
        while(true) {

            if (res > 0.5 && res < 0.6){
                System.out.println(res);
                System.out.println(num);
                return;
            }
            else{
                res = t7();
                System.out.println(res);
            }
            num++;
        }

    }

}
