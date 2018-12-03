package top.yuyufeng.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yuyufeng
 * @date 2018/12/3.
 */
@Component
public class MyConsumer {
    /**
     * 监听器监听指定的Queue
     * @param str
     */
    @RabbitListener(queues = "queue100")
    public void process(String str) {
        System.out.println("Receive:" + str);
    }
}
