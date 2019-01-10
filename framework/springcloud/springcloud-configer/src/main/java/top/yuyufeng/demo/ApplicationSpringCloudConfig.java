package top.yuyufeng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yuyufeng
 * @date 2018/12/25.
 */
@EnableConfigServer
@SpringBootApplication
public class ApplicationSpringCloudConfig {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpringCloudConfig.class, args);
    }
}
