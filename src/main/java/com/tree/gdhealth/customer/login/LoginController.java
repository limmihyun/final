package com.tree.gdhealth.customer.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tree.gdhealth.vo.Customer;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired LoginService loginService;
	
	@GetMapping("/customer/login")
	public String loginPage() {
		
		return "customer/logIn";
	}
	@PostMapping("/customer/login")
	public String login(HttpSession session, Customer customer) {
		int customerNo = 0;
		customerNo = loginService.login(customer);
		System.out.println(customerNo);
		session.setAttribute("customerNo", customerNo);
		session.setAttribute("userLevel", 0);
		return "customer/main";
	}
	
}
