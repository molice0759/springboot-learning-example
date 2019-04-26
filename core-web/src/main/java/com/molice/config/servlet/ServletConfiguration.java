package com.molice.config.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * servlet配置
 * @author molice
 * @date 2019/1/29
 **/
@Configuration
@ServletComponentScan(value = "com.molice.servlet")
public class ServletConfiguration {

/*    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new TestServlet(), "/test");
    }*/
}
