package com.tree.gdhealth.customer.programreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class ProgramReservationRest {

	@Autowired
	private ProgramReservationService programReservationService;
	
	@GetMapping("/customer/reservationdelete")
	public int reservationdelete(HttpSession session, int programReservationNo) {		
		int customerNo = 0;
		
		customerNo = (int)(session.getAttribute("customerNo"));
		
		int result = programReservationService.reservationdelete(programReservationNo, customerNo);
		
		return result;
	}
}
