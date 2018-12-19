package top.yuyufeng.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yuyufeng.demo.mapper.UserInfoMapper;
import top.yuyufeng.demo.model.UserInfo;

import java.util.Date;

/**
 * @author yuyufeng
 * @date 2018/12/19.
 */
@RestController
@RequestMapping("user")
public class UserAction {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @RequestMapping(value = "insert")
    String insert(){
        UserInfo t = new UserInfo();
        t.setUserName("yyf1");
        t.setAge(25);
        t.setCreateTime(new Date());
        userInfoMapper.insert(t);
        return "success";
    }
}
