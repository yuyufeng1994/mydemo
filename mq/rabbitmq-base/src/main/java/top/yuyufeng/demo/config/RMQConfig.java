package top.yuyufeng.demo.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yuyufeng
 * @date 2018/12/3.
 */
public class RMQConfig {
    public final static String host = "192.168.176.132";
    public final static String username = "guest";
    public final static String password = "guest";
    public final static int port = 5672;

    public static Connection getConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost(RMQConfig.host);
        factory.setUsername(RMQConfig.username);
        factory.setPassword(RMQConfig.password);
        factory.setPort(RMQConfig.port);
        //创建一个新的连接
        try {
            return factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}
