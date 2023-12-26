package com.tree.gdhealth.customer.signup;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.customer.signup.vo.CustomerSignUp;

@Mapper
public interface SignUpMapper {
	
	int customerIn(CustomerSignUp customerSignUp);
	int customerDetailIn(CustomerSignUp customerSignUp);
	int customerImgIn(CustomerSignUp customerSignUp);
	int customerNoCk(String customerId);
	
}
