package top.yuyufeng.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/producer.xml"})
public class ProducerTest {
    @Autowired
    private ProduceService produceService;

    @Test
    public void test() {
        //进行发送消息
        for (int i = 0; i < 100; i++) {
            produceService.sendMessage("发送消息sendMsg:" + i);
        }

    }
}
