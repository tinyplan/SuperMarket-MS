package com.software.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author tinyplan
 * 2021/06/15
 */
@Component("appProperties")
@PropertySource("classpath:config/AppConfig.properties")
public class AppProperties {

    @Value("${app.debug}")
    private String debug;

    public String getDebug() {
        return debug;
    }
}
