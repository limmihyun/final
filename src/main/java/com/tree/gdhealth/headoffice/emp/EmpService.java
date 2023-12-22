package com.tree.gdhealth.headoffice.emp;

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
public class EmpService {
	
	private final EmpMapper empMapper;
	
	public List<Map<String, Object>> getEmployeeList() {
		
		List<Map<String, Object>> employeeList = empMapper.employeeList();
		
		log.debug("직원 목록 : " + employeeList);
		
		return employeeList;
	}

}
