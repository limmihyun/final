package com.tree.gdhealth.headoffice.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tree.gdhealth.utils.auth.Auth;
import com.tree.gdhealth.utils.auth.Authority;

@RequestMapping("/headoffice/home")
@Controller
public class HomeController {
	
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping
	public String home() {
		
		return "headoffice/home";
	}
	
}
