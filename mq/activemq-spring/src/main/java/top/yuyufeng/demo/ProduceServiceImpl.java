package top.yuyufeng.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

public class ProduceServiceImpl implements ProduceService {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource(name = "queueDestination")
    private Destination destination;

    /**
     * 发送消息
     *
     * @param msg
     */
    @Override
    public void sendMessage(final String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(msg);
                return textMessage;
            }
        });
        System.out.println("发送的消息为： " + msg);
    }

}
