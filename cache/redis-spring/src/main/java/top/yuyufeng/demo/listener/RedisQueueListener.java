package top.yuyufeng.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class RedisQueueListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(RedisQueueConsumerListener.class);
    private RedisQueueConsumerListener redisQueueConsumerListener;
    /**
     * Receives notification that the web application initialization
     * process is starting.
     * <p>
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 容器启动后增加启动订阅
        logger.info("redis queue listener start ");
        redisQueueConsumerListener = (RedisQueueConsumerListener) ContextLoaderListener.getCurrentWebApplicationContext().getBean("redisQueueConsumerListener");
        redisQueueConsumerListener.startListener();
    }

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     * <p>
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 容器关闭时增加取消订阅
        logger.info("stop redis queue listener:");
        redisQueueConsumerListener.stopListener();
    }
}
