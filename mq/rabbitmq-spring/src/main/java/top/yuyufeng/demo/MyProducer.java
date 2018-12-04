package top.yuyufeng.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author yuyufeng
 * @date 2018/12/4.
 */
@Service
public class MyProducer {
    @Resource(name = "amqpTemplate")
    private AmqpTemplate amqpTemplate;

    /*@Resource(name = "amqpTemplate2")
    private AmqpTemplate amqpTemplate2;*/

    public void sendMessage(Object message) throws IOException {
        System.out.println(message);
        for (int i = 0; i < 5; i++) {
            amqpTemplate.convertAndSend("queue100Key", message + " " + i);
        }

//        amqpTemplate.convertAndSend("queue101", message);
//        amqpTemplate2.convertAndSend("queue102", message);
    }
}
