package com.tree.gdhealth.customer.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.CustomerMyPage;

@Service
@Transactional
public class MyPageService {
	@Autowired MyPageMapper myPageMapper;
	
	public CustomerMyPage MyPage(int customerNo) {
		CustomerMyPage info = myPageMapper.info(customerNo); 
		int weight = info.getCustomerWeight();
		int height = info.getCustomerHeight();
		double bmi = (weight / (height * height / 10000));
		info.setCustomerBmi(bmi);
		System.out.println(info.toString());
		System.out.println(bmi);
		return info;
	}
	
	public int attendance(int customerNo) {
		int attendanceCount = myPageMapper.attendanceCount(customerNo);  
		return attendanceCount;
	}
	public int review(int customerNo) {
		int reviewCount = myPageMapper.reviewCount(customerNo);  
		return reviewCount;
	}
	public int question(int customerNo) {
		int questionCount = myPageMapper.questionCount(customerNo);  
		return questionCount;
	}
}
