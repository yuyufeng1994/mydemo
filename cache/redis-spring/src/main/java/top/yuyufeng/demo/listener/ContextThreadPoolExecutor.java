package top.yuyufeng.demo.listener;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ContextThreadPoolExecutor implements InitializingBean, DisposableBean {

    private static BlockingQueue<Runnable> queue;
    private static ThreadPoolExecutor executor;
    private Integer corePoolSize = 15;
    private Integer maximumPoolSize = 20;
    private Integer keepAliveTime = 10;
    private Integer queueSize = 1000; //

    private static final ContextThreadPoolExecutor contextExecutor = new ContextThreadPoolExecutor();

    private ContextThreadPoolExecutor(){

    }

    public static ContextThreadPoolExecutor getInstance(){
        return contextExecutor;
    }

    /**
     * 执行线程任务
     * @param runnable
     */
    public static void excuteTask(Runnable runnable){

        executor.execute(runnable);
    }

    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public void setKeepAliveTime(Integer keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public void setQueueSize(Integer queueSize) {
        this.queueSize = queueSize;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        if(queue == null){
            queue = new ArrayBlockingQueue<Runnable>(queueSize);
            if (maximumPoolSize < corePoolSize)
                maximumPoolSize = corePoolSize;
            executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MICROSECONDS, queue);
            executor.prestartCoreThread();
        }
    }

    @Override
    public void destroy(){
        executor.shutdown();
    }
}
