package com.example.demo.Config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthentionInteceptor implements HandlerInterceptor {

	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{

	String name = (String) request.getSession().getAttribute("UserName");
	if(name == null || "".equals(name)) {
		response.sendRedirect("/login");
		return false;
	}
	return true;
	}
}
