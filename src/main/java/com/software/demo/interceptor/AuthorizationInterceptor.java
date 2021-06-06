package com.software.demo.interceptor;

import com.software.demo.annotation.Authorization;
import com.software.demo.constant.TokenConstant;
import com.software.demo.entity.ResultStatus;
import com.software.demo.exception.BusinessException;
import com.software.demo.util.CookieUtil;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author tinyplan
 * 2021/6/2
 * <p>
 * 请求权限校验
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 映射到方法
        if (handler instanceof HandlerMethod) {
            Method method = ((HandlerMethod) handler).getMethod();
            // 只有被@Authorization注解的方法才会拦截
            if (method.getAnnotation(Authorization.class) != null) {
                // 在cookie中寻找token
                Cookie cookie = CookieUtil.getCookie(request, TokenConstant.TOKEN_KEY);
                String tokenInCookies = cookie == null ? null : cookie.getValue();
                // 在session中寻找token
                HttpSession session = request.getSession();
                String token = (String) session.getAttribute(TokenConstant.TOKEN_KEY);
                if (token == null || !token.equals(tokenInCookies) || session.getAttribute(token) == null) {
                    // 未通过验证
                    throw new BusinessException(ResultStatus.RES_FAIL, "没有权限");
                } else {
                    // 刷新时间
                    session.setMaxInactiveInterval(TokenConstant.EXPIRE);
                }
            }
        }
        return true;
    }
}
