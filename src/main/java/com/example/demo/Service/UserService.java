package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Respository.UserJPAResponsitory;

@Service
public class UserService {
	
	@Autowired
	UserJPAResponsitory userJPAResponsitory;
	
	public Account findByEmailAndPass(String email, String pass) {
		return userJPAResponsitory.findByEmailAndPass(email, pass);
	}
}
