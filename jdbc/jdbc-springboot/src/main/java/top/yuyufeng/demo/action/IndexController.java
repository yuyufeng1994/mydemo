package top.yuyufeng.demo.action;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yuyufeng
 * @date 2018/12/24.
 */
@RestController
public class IndexController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "insertUser")
    Date insertUser(){
        String sql = "INSERT INTO `user_info` ( `user_name`, `age`, `create_time`) VALUES ( 'yy', '24', '2018-12-26 15:17:56')";
        jdbcTemplate.update(sql);
        return new Date();
    }
}
