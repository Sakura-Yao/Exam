import com.huade.Utils.GA;
import com.huade.pojo.Paper;
import com.huade.pojo.Population;
import com.huade.pojo.QuestionInfo;
import com.huade.pojo.Rule;

import java.util.ArrayList;
import java.util.List;

public class GA_Main {

    public static void main(String[] args) {
        //规则
        List<String> pointIds = new ArrayList<>();
        pointIds.add("c795c6b761954bd391e7cad4cff61a69");
        pointIds.add("8dbaecc4ce4144289a4bb8e443b2b3af");
        pointIds.add("13cd9f851bc3450191a4d86bc17ee4e3");
        pointIds.add("8c5f66f7f5c2468db52978be22f3d6eb");
        pointIds.add("1191efe8d4274677889445af15169357");
        pointIds.add("3587bdc69e54417eb7bc57884ea70009");
        pointIds.add("19dd664a47ac422d908674b4e64b9862");
        pointIds.add("3eeddc25760449208662ad58100e2787");
        pointIds.add("2ff83cbf15ad4bc4b6c5fd7e6c4e1f98");
        pointIds.add("c89ea4cf1db94085bc5065061cfbc62d");
        pointIds.add("60b4a828822b4f888ca125beba906921");
        pointIds.add("6a4e0003ab0349b6a24e5b2303c8871a");
        pointIds.add("cf65ee85b5c14fd8b6a5c3549bcb71b9");
        pointIds.add("131fc47b373f4999a403f9f1a2a2ed85");
        pointIds.add("04a3d8ae06bb4d22aac7f3f4005fe5af");
        pointIds.add("3554cc391ecf4e7cbac3ea54f8f8d912");
        pointIds.add("170180964ef14d89a1dc317a58f0ba33");
        pointIds.add("10d2ab63adaf460d9770220acf21474f");
        pointIds.add("8fe2c27c162945e9852332f3e9f2f9bd");
        pointIds.add("e5a123f2472048e18510f5ef2eb9f8b0");
        Rule rule = new Rule();
        rule.setId("1");
        rule.setExamId("1");
        rule.setCou_Id("TT001");
        rule.setTotalMark(50);
        rule.setDifficulty(0.75);
        rule.setSingleNum(10);
        rule.setSingleScore(2);
        rule.setCompleteNum(10);
        rule.setCompleteScore(2);
        rule.setSubjectNum(2);
        rule.setSubjectScore(5);
        rule.setPointIds(pointIds);
        System.out.println("正在组卷！！！");
        GA.AutoMakePaper(rule);
    }

}
