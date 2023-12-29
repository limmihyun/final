package com.tree.gdhealth.customer.programreservation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String prorsone(HttpSession session,int year, int month, int day, String programName, Model model, RedirectAttributes red) {
		
		if(session.getAttribute("customerNo") == null) {
			return "redirect:/customer/login";
		}
		
		
		int customerNo = (int)(session.getAttribute("customerNo"));
		System.out.println(customerNo + "<--customerNo");
		
		
		
		// -------------이용권 확인 -----------------------------
		
		String msg = "";
		
		Map<String, Object> paramap = programReservationService.customerPayment(customerNo);
		System.out.println(paramap + "<--null확인"); // null값이 들어왔는지 확인 
		
		if(paramap == null) { // null값이면 돌려보냄 
			msg = "이용권이 존재하지 않습니다. 이용권을 구매해주세요";			
			System.out.println("이용권이 없음");
			red.addFlashAttribute("msg", msg);
			return "redirect:/customer/programrs";
		}
		
		int paymentMonth = 0;

		// Object 타입들을 형변환 
		Integer yearObj = Integer.parseInt(String.valueOf(paramap.get("year")));
		Integer monthObj = Integer.parseInt(String.valueOf(paramap.get("month")));
		Integer dayObj = Integer.parseInt(String.valueOf(paramap.get("day")));
		Integer membershipMonthObj = Integer.parseInt(String.valueOf(paramap.get("membershipMonth")));
		
		// payment_date에다 membershipMonth를 더해서 회원의 회원권 총 시간 구하기
		if (monthObj instanceof Integer && membershipMonthObj instanceof Integer) {
		    paymentMonth = (int) monthObj + (int) membershipMonthObj;
		} 
		System.out.println(paymentMonth + "<--paymentMonth");
		
		if(paymentMonth > 12) {
			yearObj = yearObj + 1;
			paymentMonth = paymentMonth - 12;
			monthObj = paymentMonth;
		}
		
		System.out.println(yearObj + "<--yearObj");

		String month1 = String.format("%02d",monthObj);
		
		System.out.println(month1 + "<--month1");
		
		String paymentDate = yearObj + month1 + dayObj;
		System.out.println(paymentDate + "<---paymentDate");

		
		String month2 = String.format("%02d",month);
		String programDate = year + month2 + day;
		System.out.println(programDate + "<---programDate");
		
		if(Integer.parseInt(paymentDate) < Integer.parseInt(programDate)) {
			msg = "이용권 기간 확인 부탁드립니다.";			
			System.out.println("이용권 기간 확인 부탁드립니다. ");
			red.addFlashAttribute("msg", msg);
			return "redirect:/customer/programrs";
		}

		// --------------------------------------------------
		
		
		String customerId = programReservationService.customerId(customerNo);
		model.addAttribute("customerId", customerId);
		
		Map<String,Object> resultList = programReservationService.prorsone(year, month, day, programName);
		model.addAttribute("resultList", resultList);
		System.out.println(resultList + "resultList");
		
		return "customer/proRsOne";
		
	}

}
