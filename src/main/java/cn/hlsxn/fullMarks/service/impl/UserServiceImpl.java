package cn.hlsxn.fullMarks.service.impl;

import cn.hlsxn.fullMarks.pojo.RespBean;
import cn.hlsxn.fullMarks.mapper.UserMapper;
import cn.hlsxn.fullMarks.pojo.UserPojo;
import cn.hlsxn.fullMarks.service.UserService;
import cn.hlsxn.fullMarks.util.MailUtils;
import cn.hlsxn.fullMarks.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserPojo> findAll() {
        return userMapper.findAll();
    }

    @Override
    public RespBean login(HttpServletRequest request, String user, String password) {
        UserPojo userPojo = userMapper.login(user, password);
        if (null == userPojo) {
            return RespBean.error("账号或者密码错误，请检查后重新输入");
        }
        int status = userPojo.getUstatus();
        if (0 == status) {
            return RespBean.error("账户未激活，请先激活");
        }
        request.getSession().setAttribute("user", userPojo);
        return RespBean.ok("");
    }

    @Override
    public RespBean register(UserPojo user) {
        String username = userMapper.findByUserName(user.getUsername());
        if (null != username) {
            return RespBean.error("用户名重复，请重新输入!");
        }
        user.setUname(user.getUsername());
        user.setUface("");
        user.setUuid(UuidUtil.getUuid());
        user.setUgold(0);
        user.setUgold(200);
        userMapper.insert(user);
        //注册成功，发送邮件
        String text="<a href=\"http://h1427213369.picp.net/travel/user/active?code="+user.getUuid()+"\">正在注册百分纸牌，请点击激活</a>";
        MailUtils.sendMail(user.getUemail(), text, "百分纸牌网游");
        return RespBean.ok("注册成功,请查收邮件并激活!");
    }
}
