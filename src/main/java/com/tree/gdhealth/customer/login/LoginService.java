package com.tree.gdhealth.customer.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Customer;

@Service
@Transactional
public class LoginService {
	@Autowired LoginMapper loginMapper;
	
	public int login(Customer customer) {
		int n = loginMapper.customerLoginCk(customer);
		
		return n;
	}

}
