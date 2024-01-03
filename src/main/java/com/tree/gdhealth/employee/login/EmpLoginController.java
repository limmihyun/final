package com.tree.gdhealth.employee.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tree.gdhealth.customer.login.LoginService;
import com.tree.gdhealth.vo.Employee;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpLoginController {
@Autowired EmpLoginService empLoginService;
	
	@GetMapping("/employee/login")
	public String loginPage(HttpSession session) {
		// 로그인 세션 확인
		if(session.getAttribute("employeeNo") != null) {
			return "customer/home";
		}
		return "employee/logIn";
	}
	
	@PostMapping("/employee/login")
	public String login(HttpSession session, Employee employee, RedirectAttributes red) {
		int employeeNo = 0;
		employeeNo = empLoginService.login(employee);
		System.out.println(employeeNo);
		if(employeeNo == 0) {
			red.addFlashAttribute("msg", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
	        return "redirect:/customer/login";
		}
		red.addFlashAttribute("msg", "로그인 되셨습니다.");
		// 
		session.setAttribute("employeeNo", employeeNo);
		session.setAttribute("userLevel", 1);
		return "redirect:/customer/home";
	}
	
	@GetMapping("/employee/logout")
	public String logout(HttpSession session,RedirectAttributes red) {
		System.out.println("로그아웃");
		String msg = "로그아웃 되셨습니다.";
		red.addFlashAttribute("msg",msg);
		session.invalidate();
		return "redirect:/customer/home";
	}
}
