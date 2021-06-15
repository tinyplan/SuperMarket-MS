package com.software.demo.controller;

import com.software.demo.annotation.Authorization;
import com.software.demo.constant.TokenConstant;
import com.software.demo.entity.ApiResult;
import com.software.demo.entity.ResultStatus;
import com.software.demo.entity.dto.LoginDTO;
import com.software.demo.util.CookieUtil;
import com.software.demo.util.TimeUtil;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tinyplan
 * 2021/6/2
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/login")
    public ApiResult<String> login(@RequestBody LoginDTO form, HttpServletRequest request, HttpServletResponse response) {
        String username = form.getUsername();
        String password = form.getPassword();
        if ("admin".equals(username) && "123456+".equals(password)) {
            HttpSession session = request.getSession();
            String rawToken = username + TimeUtil.nowTime();
            String token = DigestUtils.md5DigestAsHex(rawToken.getBytes(StandardCharsets.UTF_8));
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
        return new ApiResult<>(ResultStatus.RES_FAIL, "用户名或密码错误", null);
    }

    @RequestMapping("/logout")
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

    @GetMapping("/info")
    @Authorization
    public ApiResult<Map<String, String>> info() {
        Map<String, String> map = new HashMap<>();
        map.put("roles", "ROLE_ADMIN");
        map.put("avatar", "https://cdn.jsdelivr.net/gh/southyou/supermarket-ms/src/assets/logo/logo.png");
        map.put("accountName", "系统管理员");
        return new ApiResult<>(ResultStatus.RES_SUCCESS, map);
    }

}
