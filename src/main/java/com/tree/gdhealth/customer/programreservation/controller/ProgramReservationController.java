package com.tree.gdhealth.customer.programreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramReservationController {
	
	@GetMapping("/customer/programrs")
	public String programrs() {
		
		return "customer/programreservation";
	}
	
}
