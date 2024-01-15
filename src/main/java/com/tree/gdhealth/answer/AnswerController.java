package com.tree.gdhealth.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AnswerController {
	@Autowired AnswerService answerService;
	
	@GetMapping("/answer/addAnswer")
	public String addAnswer(HttpSession session, Model model){
		if(session.getAttribute("loginEmployee")== null) {
			return "redirect:/employee/login";
		}
		return "/answer/addAnswer";
	}
	
	@PostMapping("/answer/addAnswer")
	public String addAnswer(HttpSession session) {
		if(session.getAttribute("loginEmployee")== null) {
			return "redirect:/employee/login";
		}
		return "redirect:/answer/noticeList";
	}
	
	
}
