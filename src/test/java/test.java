import org.junit.Test;

import java.util.UUID;

public class test {

    @Test
    public void test1(){
        System.out.println(UUID.randomUUID().toString().replace("-","").length());

    }

}
