package com.tree.gdhealth.customer.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class PaymentRest {
	
	@Autowired
	private PaymentService paymentService;

	@GetMapping("/customer/checkMembership")
	public boolean checkMembership(HttpSession session) {
		
        boolean hasMembership = false;
		
		int customerNo = (int)(session.getAttribute("customerNo"));
		
		int selectPayment = paymentService.selectPayment(customerNo);
		System.out.println(selectPayment + "null일려나");

		
		if(selectPayment > 0) {
			hasMembership = true;
		}
		
		System.out.println(hasMembership);
		
		return hasMembership;
	}
}
