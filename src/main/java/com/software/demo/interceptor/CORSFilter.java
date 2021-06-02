package com.software.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 */
@WebFilter(filterName = "CORSFilter", urlPatterns = "/*", initParams = @WebInitParam(name = "IsCross", value = "true"))
@Order(0)
public class CORSFilter implements Filter {
    public static final Logger LOGGER = LoggerFactory.getLogger(CORSFilter.class);

    private boolean isCross;

    @Override
    public void init(FilterConfig filterConfig) {
        isCross = "true".equals(filterConfig.getInitParameter("IsCross"));
        LOGGER.info("isCross = " + isCross);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (isCross) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            if (!"OPTIONS".equals(httpServletRequest.getMethod())) {
                LOGGER.info("拦截请求: " + httpServletRequest.getServletPath()
                        + ", " + httpServletRequest.getMethod());
            }
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            httpServletResponse.setHeader("Access-Control-Max-Age", "0");
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("XDomainRequestAllowed", "1");
            httpServletResponse.setHeader("Access-Control-Allow-Headers",
                    String.join(",", new String[]{
                            "Origin", "No-Cache", "X-Requested-With",
                            "If-Modified-Since", "Pragma", "Last-Modified",
                            "Cache-Control", "Expires", "Content-Type",
                            "X-E4M-With", "x-token", "Authorization"})
            );
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        isCross = false;
    }
}
