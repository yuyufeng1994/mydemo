package top.yuyufeng.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yuyufeng
 * @date 2019/1/10.
 */
public class App {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void printLog(){
        logger.info("测试日志");
    }



    public static void main(String[] args) {
        new App().printLog();
    }
}
