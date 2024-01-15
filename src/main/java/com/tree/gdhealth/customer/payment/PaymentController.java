package com.tree.gdhealth.customer.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tree.gdhealth.headoffice.membership.MembershipService;
import com.tree.gdhealth.vo.Membership;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	@Autowired
//	private PaymentService paymentService;
	private MembershipService membershipService;
	
	@GetMapping("/customer/membershipList")
	public String paymentList(Model model,HttpSession session) {
		
		List<Membership> membershipList = membershipService.membershipList();
		model.addAttribute("membershipList", membershipList);
		
		return "customer/membershipList";
	}
	
	@GetMapping("/customer/addPayment")
	public String addPayment(Model model) {
		
		return "customer/addPayment";
	}
}	
