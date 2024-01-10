package com.tree.gdhealth.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tree.gdhealth.vo.Branch;
import com.tree.gdhealth.vo.Question;
import com.tree.gdhealth.customer.franchisebranch.*;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class QuestionController {
	@Autowired QuestionService questionService;
	@Autowired FranchiseBranchService branchService;


	@GetMapping("/question/questionList")
	public String questionList(Model model, Question question) {
		
		
	    List<Question> list = questionService.questionList();
	    model.addAttribute("list", list);
	    
	    return "/question/questionList";
	}

	@GetMapping("/question/questionOne")
	public String questionOne(HttpSession session, Model model, int questionNo, Question question) {
		
		Question qsOne = questionService.questionOne(questionNo);
		model.addAttribute("qsOne", qsOne);
		return "/question/questionOne";
	}
	
	@PostMapping("/question/questionOne")
	public String questionOne(HttpSession session, int questionNo) {
		System.out.println("questionNo : "+ questionNo);
		
		return "redirect:/question/questionOne?questionNo=" + questionNo;
	}
	
	@GetMapping("/question/addQuestion")
	public String addQuestion(HttpSession session, Model model, Question question) {
		if(session.getAttribute("customerNo")== null) {
			 return "redirect:/customer/login";
		}
		int customerNo = ((Integer)session.getAttribute("customerNo"));
		
		List<Branch> branchList = branchService.branchInfo();
		
		model.addAttribute("branchList", branchList);
		
		System.out.println("branchList : " + branchList);
		model.addAttribute("customerNo", customerNo);
		
		
		return "/question/addQuestion";
	}
	
	@PostMapping("/question/addQuestion")
	public String addQuestion(int branchNo, String questionTitle, Question question) {
		
		System.out.println(branchNo + "<--branchNo");
		System.out.println(questionTitle + "<--questionTitle");

		int row = questionService.addQuestion(question);
		
		
		return "redirect:/question/questionList";
	}
	
	
	
	
}
