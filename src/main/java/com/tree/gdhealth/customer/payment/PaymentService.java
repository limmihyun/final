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

		System.out.println("paramap!" + paramap);
		
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

		System.out.println(result + "result");
		
		
		int resultint = paymentMapper.updatePayment(result);
		
		return resultint;
	}
	
	public int deletePayment(int customerNo) {
		
		
		// -------- 회원권 만료시 DELETE --------
		
		// 현재 날짜 데이터 가져오기 
        LocalDate currentDate = LocalDate.now();

        // 년, 월, 일 가져오기
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();

        // 결과 출력
        System.out.println("Year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
        
        String month1 = String.format("%02d",month);
        String day1 = String.format("%02d",day);
        
        String date = year + month1 + day1;

        System.out.println("date" + date);
        
		// -----------------------------------
        
        Map<String, Object> paymentDate = paymentMapper.selectPaymentMonth(customerNo);
        if(paymentDate != null) {
	        int paymentYear = (int)paymentDate.get("year");
	        int paymentMonth = (int)paymentDate.get("month");
	        int paymentDay = (int)paymentDate.get("day");
	        
	        String paymentMonth1 = String.format("%02d",paymentMonth);
	        String paymentDay1 = String.format("%02d",paymentDay);
	        
	        System.out.println("paymentYear: " + paymentYear);
	        System.out.println("paymentMonth1: " + paymentMonth1);
	        System.out.println("paymentDay1: " + paymentDay1);
	   
	        
	        String paymentDate1 = paymentYear + paymentMonth1 + paymentDay1;
	        
	        System.out.println("paymentDate1" + paymentDate1);
	        
			if(Integer.parseInt(paymentDate1) < Integer.parseInt(date)) {
				
				System.out.println("현재 날짜가 더 큰 경우");
				paymentMapper.deletePayment(customerNo);
				
			}
        }
        return 1;
	}
	
	public int selectActiveN(int customerNo) {
		
		int result = paymentMapper.selectActiveN(customerNo);
		
		return result;
	}

}
