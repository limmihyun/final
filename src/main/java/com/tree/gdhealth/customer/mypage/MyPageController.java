package com.tree.gdhealth.customer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tree.gdhealth.vo.CustomerMyPage;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyPageController {
	@Autowired MyPageService myPageService;
	
	@GetMapping("/customer/myPage")
	public String myPage(HttpSession session,Model model) {
		if(session.getAttribute("customerNo") == null) {
			return "customer/home";
		}
		int customerNo = (Integer)session.getAttribute("customerNo");
		//고객정보
		CustomerMyPage info = myPageService.MyPage(customerNo);
		model.addAttribute("info", info);
		//출석
		int attendanceCount = myPageService.attendance(customerNo);
		model.addAttribute("attendanceCount", attendanceCount);
		//리뷰
		int reviewCount = myPageService.review(customerNo);
		model.addAttribute("reviewCount", reviewCount);
		//문의
		int questionCount = myPageService.question(customerNo);
		model.addAttribute("questionCount", questionCount);
		return "customer/myPage";
	}
	
	
	
}
