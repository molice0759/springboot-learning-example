package com.molice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author molice
 * @date 2019/3/9
 */
@SpringBootApplication(scanBasePackages = { "com.molice"})
@EnableAutoConfiguration
public class SpringbootLearningExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLearningExampleApplication.class, args);
	}

}
