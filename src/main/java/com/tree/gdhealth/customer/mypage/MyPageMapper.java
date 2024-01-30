package com.tree.gdhealth.customer.mypage;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.CustomerDetail;
import com.tree.gdhealth.vo.CustomerImg;
import com.tree.gdhealth.vo.CustomerMyPage;

@Mapper
public interface MyPageMapper {
	
	CustomerMyPage info(int customerNo);
	CustomerImg customerImgCk(int customerNo);
	int attendanceCount(int customerNo);
	int reviewCount(int customerNo);
	int questionCount(int customerNo);
	String membership(int customerNo);
	Integer customerDeleteCk(Customer customerNo);
	CustomerImg customerImgCk(Customer cusotomer);
	int customerDelete(Customer customer);
	int customerDetailDelete(Customer customer);
	int customerImgDelete(Customer customer);
	int updateMyPage(CustomerDetail customerDetail);
	CustomerImg selectCustomerImg(int customerNo);
}
