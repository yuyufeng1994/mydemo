package top.yuyufeng.demo.demo1;

import com.rabbitmq.client.*;
import top.yuyufeng.demo.config.RMQConfig;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yuyufeng
 * @date 2018/12/3.
 */
public class ConsumerTest {
    private final static String QUEUE_NAME = "quene_test";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ地址
        factory.setHost(RMQConfig.host);
        factory.setUsername(RMQConfig.username);
        factory.setPassword(RMQConfig.password);
        factory.setPort(RMQConfig.port);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //声明要关注的队列
        channel.queueDeclare(QUEUE_NAME, false, false, true, null);
        System.out.println("Customer Waiting Received messages");
        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
