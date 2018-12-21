package top.yuyufeng.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author yuyufeng
 * @date 2018/12/21.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "index")
    private String index(Model model) {
        model.addAttribute("myDate", new Date());
        return "index";
    }

    @RequestMapping(value = "hello")
    private String hello(Model model) {
        model.addAttribute("userName","用户1" );
        return "hello";
    }

}
