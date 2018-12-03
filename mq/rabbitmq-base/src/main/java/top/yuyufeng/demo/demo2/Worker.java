package top.yuyufeng.demo.demo2;

import com.rabbitmq.client.*;
import top.yuyufeng.demo.config.RMQConfig;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 启动多个消费者
 * @author yuyufeng
 * @date 2018/12/3.
 */
public class Worker {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RMQConfig.getConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Worker1  Waiting for messages");

        //每次从队列获取的数量
        channel.basicQos(2);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Worker1  Received '" + message + "'");
                try {
                    doWork(message);
//                    throw new Exception();
                } catch (Exception e) {
                    channel.abort();
                } finally {
                    System.out.println("Worker1 Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        boolean autoAck = false;
        //消息消费完成确认
        channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String task) {
        try {
            Thread.sleep(100); // 暂停1秒钟
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
