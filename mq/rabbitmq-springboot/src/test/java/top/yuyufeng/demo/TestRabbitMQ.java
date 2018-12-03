package top.yuyufeng.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yuyufeng.demo.mq.MyProducer;

/**
 * @author yuyufeng
 * @date 2018/11/30.
 */
@SpringBootTest(classes=Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {
    @Autowired
    private MyProducer producer;

    @Test
    public void testRabbit() {
        producer.send("hello 你好.");
    }
}
