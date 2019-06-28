package top.yuyufeng.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


public class RedisQueueConsumerListener {
    private static Logger logger = LoggerFactory.getLogger(RedisQueueConsumerListener.class);
    private volatile boolean exit = false;
    private List<IMessageHandleConsumer> consumers = new ArrayList<>();

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOperations;


    public void setConsumers(List<IMessageHandleConsumer> consumers) {
        this.consumers = consumers;
    }

    /**
     * 启动监听
     */
    public void startListener() {
        for (IMessageHandleConsumer consumer : consumers) {
            ContextThreadPoolExecutor.excuteTask(new RedisMessageConsumerThread(consumer));
        }
    }

    /**
     * 关闭监听
     */
    public void stopListener() {
        exit = true;
    }


    class RedisMessageConsumerThread extends Thread {
        private IMessageHandleConsumer consumer;

        RedisMessageConsumerThread(IMessageHandleConsumer consumer) {
            this.consumer = consumer;
        }

        @Override
        public void run() {
            try {
                while (!exit) {
                    try {
                        String message = listOperations.leftPop(consumer.getQueueName());
                        if (!StringUtils.isEmpty(message)) {
                            consumer.handleMessage(message);
                        }
                    } catch (Exception e) {
                        logger.error("message handle error!queue:[]", consumer.getQueueName());
                    }
                }
            } catch (Exception e) {
                logger.error("RedisMessageConsumerThread error! exception:[]", e.getMessage());
            }
        }
    }

}
