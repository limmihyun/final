package com.tree.gdhealth.customer.payment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tree.gdhealth.headoffice.membership.MembershipService;
import com.tree.gdhealth.vo.Membership;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private MembershipService membershipService;
	
	
	@GetMapping("/customer/membershipList")
	public String paymentList(Model model,HttpSession session) {
		
		List<Membership> membershipList = membershipService.membershipList();
		model.addAttribute("membershipList", membershipList);
		
		System.out.println("여기 지나가냐??");
		
		return "customer/membershipList";
	}
	
	@GetMapping("/customer/addPayment")
	public String addPayment(Model model, HttpSession session, int membershipNo, int membershipPrice) {
		
		if(session.getAttribute("customerNo") == null) {
			return "redirect:/customer/login";
		}
		
		
		int customerNo = (int)(session.getAttribute("customerNo"));
		
		model.addAttribute("customerNo", customerNo);
		model.addAttribute("membershipNo", membershipNo);
		model.addAttribute("membershipPrice", membershipPrice);

		
		System.out.println("uuu~~~" + membershipNo);

		
		return "customer/addPayment";
	}
	
    @GetMapping("/customer/processPayment")
    public String processPayment(int membershipNo, HttpSession session) {
    	
		int customerNo = (int)(session.getAttribute("customerNo"));

    	System.out.println(membershipNo);
    	
    	paymentService.addPayment(membershipNo, customerNo);
    	
        return "redirect:/customer/success";
    }
	
	@GetMapping("/customer/success")
	public String success() {

		
		return "customer/success";

	}


}	
