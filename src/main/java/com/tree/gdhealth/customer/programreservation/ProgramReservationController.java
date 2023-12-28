package com.tree.gdhealth.customer.programreservation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProgramReservationController {
	@Autowired
	private ProgramReservationService programReservationService;
	
	@GetMapping("/customer/programrs")
	public String programrs(HttpSession session,Model model
			, @RequestParam(required = false) Integer targetYear
			, @RequestParam(required = false) Integer targetMonth
			, @RequestParam(required = false) Integer targetDay) {
		
		Map<String, Object> calendarMap = programReservationService.getCalendar(targetYear, targetMonth, targetDay);
		model.addAttribute("calendarMap", calendarMap);
		
		List<Map<String, Object>> resultList = programReservationService.selectProgramByMonth((int)(calendarMap.get("targetYear")), (int)(calendarMap.get("targetMonth")));
		model.addAttribute("resultList", resultList);
		System.out.println(resultList + "<---resultList 출력");
		
		List<Map<String, Object>> allList = programReservationService.allCalendarList();
		model.addAttribute("allList", allList);

		
		return "customer/programreservation";
	}
	
	@GetMapping("/customer/prorsone")
	public String prorsone(int year, int month, int day, String programName, Model model) {
		
		Map<String,Object> resultList = programReservationService.prorsone(year, month, day, programName);
		model.addAttribute("resultList", resultList);
		System.out.println(resultList + "resultList");
		
		return "customer/proRsOne";
		
	}

}
