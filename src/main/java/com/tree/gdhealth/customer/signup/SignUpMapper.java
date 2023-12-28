package com.tree.gdhealth.customer.signup;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Customer;
import com.tree.gdhealth.vo.CustomerSignUp;

@Mapper
public interface SignUpMapper {
	
	int customerIn(CustomerSignUp customerSignUp);
	int customerDetailIn(CustomerSignUp customerSignUp);
	int customerImgIn(CustomerSignUp customerSignUp);
	Integer customerNoCk(String customerId);
	Integer customerEmailCk(String customerEmail);
	
}
