package top.yuyufeng.demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 接受direct的消息MyConsumer
 * @author yuyufeng
 * @date 2018/12/4.
 */
public class MyConsumer3 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("消费者MyConsumer3接收到消息：" + message);
    }
}
