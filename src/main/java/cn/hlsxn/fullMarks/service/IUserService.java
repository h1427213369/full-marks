package cn.hlsxn.fullMarks.service;

import cn.hlsxn.fullMarks.pojo.RespBean;
import cn.hlsxn.fullMarks.pojo.UserPojo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface IUserService {
    /**
     * 查询用户
     * @return
     */
    List<UserPojo> findAll();

    /**
     * 登录
     *
     * @return
     */
    RespBean login(HttpServletRequest request, String user, String password);

    /**
     * 注册
     * @param user
     * @return
     */
    RespBean register(UserPojo user);
}
