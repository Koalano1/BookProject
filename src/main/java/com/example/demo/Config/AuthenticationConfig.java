package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthenticationConfig implements WebMvcConfigurer{

	@Autowired
	private AuthentionInteceptor authentionInteceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authentionInteceptor).addPathPatterns("/", "/book-list","/update-book/**");
	}
}
