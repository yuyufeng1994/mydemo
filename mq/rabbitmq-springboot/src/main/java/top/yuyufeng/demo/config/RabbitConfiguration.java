package top.yuyufeng.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuyufeng
 * @date 2018/12/3.
 */
@Configuration
public class RabbitConfiguration {

    /**
     * 由于采用的是Direct模式,需要在配置Queue的时候,指定一个键,使其和交换机绑定.
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("queue100");
    }
}
