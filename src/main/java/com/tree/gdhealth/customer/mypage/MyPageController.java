package com.tree.gdhealth.customer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.CustomerMyPage;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.PastOrPresent;

@Controller
public class MyPageController {
	@Autowired MyPageService myPageService;
	
	// 마이페이지 입장
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
		//맴버십
		String membership = myPageService.membership(customerNo);
		if(membership == null) {
			membership = "만료";
		}
		model.addAttribute("membership", membership);
		
		return "customer/myPage";
	}
	
	@GetMapping("/customer/delete")
	public String customerDeletePage(HttpSession session,Model model) {
		if(session.getAttribute("customerNo") == null) {
			return "customer/home";
		}
		model.addAttribute("open",0);
		return "customer/delete";
	}
	
	@PostMapping("/customer/delete")
	public String customerDelete(HttpSession session,Model model,Customer customer, RedirectAttributes red) {
		int result = myPageService.deleteCustomerCk(customer);
		if(result == 0) {
			System.out.println("틀림");
			model.addAttribute("open",0);
			red.addFlashAttribute("msg", "아이디 또는 비밀번호가 다릅니다.");
			return "redirect:/customer/delete";
		}
		model.addAttribute("open",1);
		return "customer/delete";
	}
	@GetMapping("/customer/deleteDo")
	public String customerDeleteDo(HttpSession session,Model model,Customer customer, RedirectAttributes red) {
		// 사진삭제를위한 패스 값 입력
		String path = session.getServletContext().getRealPath("/upload/customer");
		// 해당 고객번호 계정삭제
		customer.setCustomerNo((Integer)session.getAttribute("customerNo"));
		int result = myPageService.deleteCustomer(customer, path);
		
		System.out.println(result);
		if(result == 0) {
			red.addFlashAttribute("msg", "알수없는오류 관리자에게 문의하세요.");
			return "redirect:/customer/home";
		}
		session.invalidate();
		red.addFlashAttribute("msg", "회원탈퇴가 완료되었습니다.");
		return "redirect:/customer/home";
	}
	
	
}
