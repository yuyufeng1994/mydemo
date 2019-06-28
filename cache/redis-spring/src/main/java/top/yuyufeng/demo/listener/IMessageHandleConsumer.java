package top.yuyufeng.demo.listener;

public interface IMessageHandleConsumer {
    void handleMessage(String message);

    String getQueueName();
}
