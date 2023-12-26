package com.tree.gdhealth.customer.programreservation.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tree.gdhealth.customer.programreservation.service.CalendarService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProgramReservationController {
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping("/customer/programrs")
	public String programrs(HttpSession session,Model model
			, @RequestParam(required = false) Integer targetYear
			, @RequestParam(required = false) Integer targetMonth
			, @RequestParam(required = false) Integer targetDay) {
		
		Map<String, Object> calendarMap = calendarService.getCalendar(targetYear, targetMonth, targetDay);
		model.addAttribute("calendarMap", calendarMap);
		
		List<Map<String, Object>> resultList = calendarService.selectProgramByMonth((int)(calendarMap.get("targetYear")), (int)(calendarMap.get("targetMonth")));
		model.addAttribute("resultList", resultList);
		System.out.println(resultList + "<---resultList 출력");
		
		return "customer/programreservation";
	}

}
