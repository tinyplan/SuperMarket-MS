package com.software.demo.controller;

import com.software.demo.constant.TokenConstant;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.dto.LoginDTO;
import com.software.demo.util.CookieUtil;
import com.software.demo.util.TimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ApiResult<String> login(@RequestBody LoginDTO form, HttpServletRequest request, HttpServletResponse response) {
        String username = form.getUsername();
        String password = form.getPassword();
        if ("admin".equals(username) && "123456+".equals(password)) {
            HttpSession session = request.getSession();
            if (session.getAttribute(TokenConstant.TOKEN_KEY) == null) {
                String token = username + LocalDateTime.now().format(TimeUtil.FORMATTER_DATE);
                // 设置session
                session.setAttribute(TokenConstant.TOKEN_KEY, token);
                session.setAttribute(token, username);
                session.setMaxInactiveInterval(TokenConstant.EXPIRE);
                // 设置cookie
                Cookie cookie = new Cookie(TokenConstant.TOKEN_KEY, token);
                cookie.setPath("/");
                cookie.setMaxAge(TokenConstant.EXPIRE);
                response.addCookie(cookie);
                return new ApiResult<>(ResultStatus.RES_SUCCESS, "登录成功", token);
            }
            return new ApiResult<>(ResultStatus.RES_FAIL, "请勿重复登录", null);
        }
        return new ApiResult<>(ResultStatus.RES_FAIL, "用户名或密码错误", null);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ApiResult<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // 删除对应的cookie
        Cookie cookie = CookieUtil.getCookie(request, TokenConstant.TOKEN_KEY);
        if (cookie != null) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        // 清空session对象的内容, 不会删除对象本身
        request.getSession().invalidate();
        return new ApiResult<>(ResultStatus.RES_SUCCESS, "退出成功", null);
    }

}
