package com.tree.gdhealth.customer.mypage;

import java.io.File;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.CustomerDetail;
import com.tree.gdhealth.vo.CustomerImg;
import com.tree.gdhealth.vo.CustomerMyPage;

@Service
@Transactional
public class MyPageService {
	@Autowired MyPageMapper myPageMapper;
	
	public CustomerMyPage MyPage(int customerNo) {
		CustomerMyPage info = myPageMapper.info(customerNo);
		
		// bmi 계산식
		double weight = info.getCustomerWeight();
		double height = info.getCustomerHeight();
		height /= 100;
		double bmi = Math.round((weight / (height * height))*10);
		bmi /=10 ;
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
	public String membership(int customerNo) {
		String membership = myPageMapper.membership(customerNo);  
		return membership;
	}
	
	// 고객 계정 삭제전 체크
	public int deleteCustomerCk(Customer customer) {
		int result = 0;
		if(myPageMapper.customerDeleteCk(customer) == null || myPageMapper.customerDeleteCk(customer) == 0) {
			return result;
		}
		result = myPageMapper.customerDeleteCk(customer);
		return result;
	}
	
	// 고객 계정 삭제
	public int deleteCustomer(Customer customer, String path) {
		int n1, n2, n3, result;
		result = 0;
		
		try {
			n1 = myPageMapper.customerDelete(customer);
			n2 = myPageMapper.customerDetailDelete(customer);
			CustomerImg customerImg = myPageMapper.customerImgCk(customer);
			n3 = myPageMapper.customerImgDelete(customer);
			if(n1+n2+n3 != 3) {
				throw new RuntimeErrorException(null);
			}
			// 이미지 파일 삭제
            String imagePath = path + "/" + customerImg.getCustomerImgFileName();
            File file = new File(imagePath);
            boolean isFileDeleted = file.delete();
            if(!isFileDeleted) {
            	throw new RuntimeErrorException(null);
            }
			result = 1;
			return result;
			
		} catch (Exception e) {
			throw new RuntimeErrorException(null);
			
		}
		
		
	}
	//고객정보 키, 몸무게 수정
	public int updateMyPage(CustomerDetail customerDetail) {
		
		System.out.println("ff");
		int row = myPageMapper.updateMyPage(customerDetail);
		System.out.println(row);
		return row;
	}
	
}
