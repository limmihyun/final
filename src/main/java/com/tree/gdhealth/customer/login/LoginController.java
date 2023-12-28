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
	public String loginPage(HttpSession session) {
		// 로그인 세션 확인
		if(session.getAttribute("customerNo") != null) {
			return "customer/home";
		}
		return "customer/logIn";
	}
	
	@PostMapping("/customer/login")
	public String login(HttpSession session, Customer customer, RedirectAttributes red) {
		int customerNo = 0;
		customerNo = loginService.login(customer);
		System.out.println(customerNo);
		if(customerNo == 0) {
			red.addFlashAttribute("msg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
	        return "redirect:/customer/login";
		}
		red.addFlashAttribute("msg", "로그인 되셨습니다.");
		session.setAttribute("customerNo", customerNo);
		session.setAttribute("userLevel", 0);
		return "redirect:/customer/home";
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session,RedirectAttributes red) {
		System.out.println("로그아웃");
		String msg = "로그아웃 되셨습니다.";
		red.addFlashAttribute("msg",msg);
		session.invalidate();
		return "redirect:/customer/home";
	}
	
}
