package top.yuyufeng.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yuyufeng.demo.vo.ResponseJson;
import top.yuyufeng.demo.vo.UserInfoVO;

/**
 * @author yuyufeng
 * @date 2018/12/6.
 */
@Controller
@RequestMapping("json")
public class JsonController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "getUserInfo", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson<UserInfoVO> getUserInfo(Integer age) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setName("小Yu");
        userInfoVO.setAge(age);
        return ResponseJson.success(userInfoVO);
    }

    @RequestMapping(value = "getUserInfo/{age}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseJson<UserInfoVO> getUserInfo2(@PathVariable("age") Integer age) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setName("小Yu");
        userInfoVO.setAge(age);
        return ResponseJson.success(userInfoVO);
    }

}
