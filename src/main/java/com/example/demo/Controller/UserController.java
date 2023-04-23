package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Account;
import com.example.demo.Service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping({"/login"})
	public String index(Model model, HttpSession session) {
		String name = (String) session.getAttribute("UserName");
		
//		if(name != null || !"".equals(name)) {
//			return "redirect:/book-list";
//		} else {
//			
//		}
		return "User/login";
	}

	@PostMapping({ "/login" })
	public String login(@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password, HttpSession httpSession) {
		Account account = userService.findByEmailAndPass(email, password);
		if (account != null) {
			httpSession.setAttribute("UserName", account.getUserName());
			return "redirect:/book-list";
		} else {
			return "User/login";

		}
	}
	
	@GetMapping({"/logout"})
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("UserName");
		return "redirect:/login";
	}
}
