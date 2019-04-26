package com.molice.config.listener;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author molice
 * @date 2019/2/3
 **/
@Configuration
@ServletComponentScan("com.molice.listener")
public class ListenerConfiguration {
}
