package com.comcast.LongestCommonSubstring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ImportResource("classpath:applicationContext.xml")
public class LongestCommonSubstringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LongestCommonSubstringApplication.class, args);
	}

}
