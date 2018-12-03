package top.yuyufeng.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yuyufeng.demo.mq.MyProducer;

/**
 * @author yuyufeng
 * @date 2018/12/3.
 */
@RestController
public class DemoController {

    @Autowired
    private MyProducer producer;

    @RequestMapping("send")
    public String send(String msg) {
        producer.send(msg);
        return msg + " ok";
    }
}
