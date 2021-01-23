import com.huade.pojo.ClassCourseInfo;
import com.huade.service.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassCourseInfoTest {

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


    @Test
    public void t01(){
        ClassCourseInfo old_ClassCourseInfo = new ClassCourseInfo("test01","11","test01");
        ClassCourseInfo new_ClassCourseInfo = new ClassCourseInfo("test01","12","test01");
        System.out.println(classCourseInfoServiceImpl.updateClassCourseInfo(new_ClassCourseInfo, old_ClassCourseInfo));
    }

    @Test
    public void t02(){
        ClassCourseInfo new_ClassCourseInfo = new ClassCourseInfo("test01","11","test01");
        System.out.println(classCourseInfoServiceImpl.deleteClassCourseInfo(new_ClassCourseInfo));
    }

    @Test
    public void t03(){
        ClassCourseInfo new_ClassCourseInfo = new ClassCourseInfo("test01","11","test01");
        System.out.println(classCourseInfoServiceImpl.addClassCourseInfo(new_ClassCourseInfo));
    }


}
