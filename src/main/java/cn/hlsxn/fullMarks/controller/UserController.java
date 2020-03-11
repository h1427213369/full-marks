package cn.hlsxn.fullMarks.controller;

import cn.hlsxn.fullMarks.pojo.RespBean;
import cn.hlsxn.fullMarks.pojo.UserPojo;
import cn.hlsxn.fullMarks.service.UserService;
import cn.hlsxn.fullMarks.util.CodeUtil;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/a")
    @ResponseBody
    public String home() {
        List<UserPojo> users = userService.findAll();
        for (UserPojo user : users) {
            System.out.println(user);
        }
        return "d:Hello World!";
    }
    @PostMapping("/login")
    @ResponseBody
    public RespBean login(HttpServletRequest request,String name, String password) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return RespBean.error("验证码错误，请重新输入!");
        }
        RespBean respBean = userService.login(request, name, password);
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        return respBean;
    }
    @PostMapping("/register")
    @ResponseBody
    public RespBean register(HttpServletRequest request, UserPojo user) {
        if (!CodeUtil.checkVerifyCode(request)) {
            return RespBean.error("验证码错误，请重新输入!");
        }
        RespBean respBean = userService.register(user);
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        return respBean;
    }
}
