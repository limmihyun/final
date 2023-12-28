package com.tree.gdhealth.customer.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String login(HttpSession session, Customer customer, RedirectAttributes redirectAttributes) {
		int customerNo = 0;
		customerNo = loginService.login(customer);
		System.out.println(customerNo);
		if(customerNo == 0) {
			redirectAttributes.addFlashAttribute("msg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
	        return "redirect:/customer/login";
		}
		
		session.setAttribute("customerNo", customerNo);
		session.setAttribute("userLevel", 0);
		return "redirect:/customer/main";
	}
	
}
