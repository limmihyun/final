package com.tree.gdhealth.customer.payment;

import java.time.LocalDate;

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

		paymentService.deletePayment(customerNo);
		int selectPayment = paymentService.selectPayment(customerNo);
		System.out.println(selectPayment + "null 검사");
		
		int activeN = paymentService.selectActiveN(customerNo);

		
		if(selectPayment > 0 || activeN > 0) {
			hasMembership = true;
		}
		
		System.out.println(hasMembership);
		
		return hasMembership;
	}
}
