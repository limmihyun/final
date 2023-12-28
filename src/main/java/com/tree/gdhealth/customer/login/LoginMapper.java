package com.tree.gdhealth.customer.login;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Customer;

@Mapper
public interface LoginMapper {
	int customerLoginCk(Customer customer);
	
	
}
