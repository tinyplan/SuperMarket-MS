package com.software.demo.config;

import com.software.demo.interceptor.AuthorizationInterceptor;
import com.software.demo.properties.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author tinyplan
 * 2021/6/2
 *
 * 拦截器配置类
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptorConfig.class);

    @Resource(name = "authorizationInterceptor")
    private AuthorizationInterceptor authorizationInterceptor;

    @Resource(name = "appProperties")
    private AppProperties appProperties;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        if ("false".equals(appProperties.getDebug())) {
            registry.addInterceptor(authorizationInterceptor);
        } else {
            LOGGER.info("Debug模式!!!!");
        }
        super.addInterceptors(registry);
    }
}
