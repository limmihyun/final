package com.tree.gdhealth.customer.payment;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	private PaymentMapper paymentMapper;
	
	public int addPayment(int membershipNo, int customerNo) {
		
		int membershipMonth = paymentMapper.membershipMonth(membershipNo);
		
		// 현재 년, 월, 일 구하기 -------------------------------------
		
        LocalDate currentDate = LocalDate.now();

        // 년, 월, 일 가져오기
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();

        // 결과 출력
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
		// --------------------------------------
        
		int resultMonth = membershipMonth + month; // 현재 날짜와 membershipMonth를 더한 값.
		
		if(resultMonth > 12) {
			year = year + 1;
			resultMonth = resultMonth - 12;
		}
        
        
		Map<String, Object> paramap = new HashMap<>();
		paramap.put("membershipNo", membershipNo);
		paramap.put("year", year);
		paramap.put("resultMonth", resultMonth);
		paramap.put("day", day);
		paramap.put("customerNo", customerNo);

		
		paymentMapper.addPayment(paramap);

		return 1;
	}
	
	public int selectPayment(int customerNo) {
		
		int result = paymentMapper.selectPayment(customerNo);
		
		return result;
	}
	
	public int updatePayment(int customerNo, int membershipMonth) {
		
		Map<String,Object> paramap = paymentMapper.selectPaymentMonth(customerNo);
		
		int month = (int)paramap.get("month");
		int year = (int)paramap.get("year");
		int day = (int)paramap.get("day");
		
		month = month + membershipMonth;
		if(month > 12) {
			year = year + 1;
			month = month - 12;
		}
		
		Map<String, Object> result = new HashMap<>();
		result.put("customerNo", customerNo);
		result.put("month", month);
		result.put("year", year);
		result.put("day", day);

		System.out.println(result + "result !! ! ! !");
		
		
		int resultint = paymentMapper.updatePayment(result);
		
		return resultint;
	}
}
