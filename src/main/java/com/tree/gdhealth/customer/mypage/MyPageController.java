package com.tree.gdhealth.customer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {
	@Autowired MyPageService myPageService;
	
	@GetMapping("/customer/myPage")
	public String myPage(HttpSession session) {
		if(session.getAttribute("customerNo") == null) {
			return "customer/home";
		}
		return "customer/myPage";
	}
	
	
	
}
