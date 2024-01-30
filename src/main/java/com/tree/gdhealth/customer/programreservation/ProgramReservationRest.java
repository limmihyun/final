package com.tree.gdhealth.customer.programreservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class ProgramReservationRest {

	@Autowired
	private ProgramReservationService programReservationService;
	
	@GetMapping("/customer/reservationdelete")
	public int reservationdelete(HttpSession session, int programReservationNo) {		
		int customerNo = 0;
		
		System.out.println(programReservationNo + "<---programReservationNo");
		
		customerNo = (int)(session.getAttribute("customerNo"));
		
		int result2 = programReservationService.reviewdelete(programReservationNo, customerNo);
		System.out.println(result2 + "<--result2");
		
		int result = programReservationService.reservationdelete(programReservationNo, customerNo);
		System.out.println("reservation 삭제 1 -- " + result);
		
		return result;
	}
	
	@GetMapping("/customer/nextPage")
    public Map<String,Object> programrs(
            HttpSession session, Model model,
            @RequestParam(required = false) Integer targetYear,
            @RequestParam(required = false) Integer targetMonth,
            @RequestParam(required = false) Integer targetDay,
            @RequestParam(defaultValue = "1") int currentPageMonth1) {



        int customerNo = (int) (session.getAttribute("customerNo"));

        Map<String, Object> calendarMap = programReservationService.getCalendar(targetYear, targetMonth, targetDay);

        // 페이징 처리를 위한 데이터 조회
        List<Map<String, Object>> listMonth1 = programReservationService.listPage(currentPageMonth1, (int) (calendarMap.get("targetYear")), (int) (calendarMap.get("targetMonth")), (int) (calendarMap.get("thisDay")), (int) (calendarMap.get("thisYear")), (int) (calendarMap.get("thisMonth")));
        Integer lastPage = programReservationService.lastPage(currentPageMonth1, (int) (calendarMap.get("targetYear")), (int) (calendarMap.get("targetMonth")), (int) (calendarMap.get("thisDay")));

        List<Map<String, Object>> resultList = programReservationService.selectProgramByMonth((int) (calendarMap.get("targetYear")), (int) (calendarMap.get("targetMonth")));
        
        List<Map<String, Object>> myCalendarList = programReservationService.myCalendarLust((int) (calendarMap.get("targetYear")), (int) (calendarMap.get("targetMonth")), customerNo);
        
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("calendarMap", calendarMap);
        responseMap.put("listMonth1", listMonth1);
        responseMap.put("lastPage", lastPage);
        responseMap.put("resultList", resultList);
        responseMap.put("currentPageMonth1", currentPageMonth1);
        responseMap.put("myCalendarList", myCalendarList);
        System.out.println(calendarMap);
        System.out.println(listMonth1 + "<--listMonth1");
        System.out.println(lastPage + "<--lastPage");
        System.out.println(myCalendarList + "<--myCalendarList");
        System.out.println(currentPageMonth1 + "<--currentPageMonth1");

        
        return responseMap;
    }
}
