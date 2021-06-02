package com.software.demo.controller;

import com.software.demo.constant.TokenConstant;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.form.LoginForm;
import com.software.demo.util.TimeFormatUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author tinyplan
 * 2021/6/2
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public ApiResult<String> login(@RequestBody LoginForm form, HttpServletRequest request) {
        String username = form.getUsername();
        String password = form.getPassword();
        if ("admin".equals(username) && "123456".equals(password)) {
            HttpSession session = request.getSession();
            if (session.getAttribute(TokenConstant.TOKEN_KEY) == null) {
                String token = username + LocalDateTime.now().format(TimeFormatUtil.FORMATTER);
                session.setAttribute(TokenConstant.TOKEN_KEY, token);
                session.setAttribute(token, username);
                // 15min后过期
                session.setMaxInactiveInterval(TokenConstant.EXPIRE);
                return new ApiResult<>(ResultStatus.RES_SUCCESS, "登录成功", token);
            }
            return new ApiResult<>(ResultStatus.RES_FAIL, "请勿重复登录", null);
        }
        return new ApiResult<>(ResultStatus.RES_FAIL, "用户名或密码错误", null);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ApiResult<String> logout(HttpServletRequest request) {
        // 清空session对象的内容, 不会删除对象本身
        request.getSession().invalidate();
        return new ApiResult<>(ResultStatus.RES_SUCCESS, "退出成功", null);
    }

}
