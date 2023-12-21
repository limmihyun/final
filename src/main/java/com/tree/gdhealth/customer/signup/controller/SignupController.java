package com.tree.gdhealth.customer.signup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {

	@GetMapping("/customer/signup")
	public String signup() {
		
		return "customer/signup";
	}
}
