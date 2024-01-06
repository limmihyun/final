package com.tree.gdhealth.headoffice.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CustomerService {
	
	private final CustomerMapper customerMapper;
	
	public List<Map<String, Object>> getCustomerList(int beginRow, int rowPerPage) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		List<Map<String,Object>> customerList = customerMapper.customerList(map);
		
		return customerList;
		
	}
	
	public int getCustomerCnt() {
		
		int customerCnt = customerMapper.customerCnt();
		// 디버깅 
		log.debug("고객 수 : " + customerCnt);
		
		return customerCnt;
	}
	
	

}
