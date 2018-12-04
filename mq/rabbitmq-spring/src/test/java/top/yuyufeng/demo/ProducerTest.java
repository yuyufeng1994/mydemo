package top.yuyufeng.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuyufeng
 * @date 2018/12/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-rabbit-producer.xml"})
public class ProducerTest {

    @Autowired
    private MyProducer myProducer;

    @Test
    public void test() throws Exception {
        myProducer.sendMessage("啊dsada啊");
    }

}
