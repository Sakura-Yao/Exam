import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;


public class xml {

    @Test
    public void test_xml() throws DocumentException {
        //创建SAXReader对象用于获取xml文件
        SAXReader reader = new SAXReader();
        //读取xml文件 获得Document对象
        Document doc = reader.read(new File("/Users/yaoyuan/Exam/src/test/java/testxml.xml"));
        //获取根元素
        Element root = doc.getRootElement();

        //读取节点为uploadFilePath的所有元素并放在Element的实例中
        Element uploadFilePath = root.element("uploadFilePath");
        //通过Element的elementText(String elementName)方法获得某个元素的值
        System.out.println(uploadFilePath.elementText("Title"));
        System.out.println(uploadFilePath.elementText("Path"));

        Element downloadFilePath = root.element("downloadFilePath");
        System.out.println(downloadFilePath.elementText("Title"));
        System.out.println(downloadFilePath.elementText("Path"));

    }

}
