package com.molice.config.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author molice
 * @date 2019/2/3
 **/
@Configuration
@ServletComponentScan("com.molice.filter")
public class FilterConfiguration {
}
