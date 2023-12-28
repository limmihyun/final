package com.tree.gdhealth.customer.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
	
	@GetMapping("/customer/home")
	public String home() {
		
		return "customer/home";
	}
}
