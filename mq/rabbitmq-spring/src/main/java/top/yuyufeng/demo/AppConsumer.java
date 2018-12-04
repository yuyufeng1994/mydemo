package top.yuyufeng.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yuyufeng
 * @date 2018/12/4.
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-rabbit-consumer.xml");
    }
}
