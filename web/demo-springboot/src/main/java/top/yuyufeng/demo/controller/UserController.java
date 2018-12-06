package top.yuyufeng.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.yuyufeng.demo.vo.ResponseJson;
import top.yuyufeng.demo.vo.UserInfoVO;

/**
 * @author yuyufeng
 * @date 2018/12/6.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    ResponseJson<UserInfoVO> getUserInfo() {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setName("小Yu");
        userInfoVO.setAge(25);
        return ResponseJson.success(userInfoVO);
    }
}
