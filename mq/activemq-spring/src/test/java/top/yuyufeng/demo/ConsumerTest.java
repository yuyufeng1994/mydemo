package top.yuyufeng.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/consumer.xml"})
public class ConsumerTest {

    public static void main(String[] args) throws IOException {
        //启动消费者
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring/consumer.xml");
        classPathXmlApplicationContext.start();
        System.out.println("consumer started.");
//        System.in.read(); // press any key to exit
    }
}
