package top.yuyufeng.demo.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuyufeng
 * @date 2018/12/26.
 */
@RestController
@RefreshScope
public class IndexController {
    @Value("${my-name}")
    private String myName;

    @RequestMapping(value = "/")
    public String index() {
        return "name:" + myName;
    }
}
