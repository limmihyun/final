package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class EmpService {
	
	// DI
	private final EmpMapper empMapper;
	
	public List<Map<String, Object>> getEmployeeList() {
		
		List<Map<String, Object>> employeeList = empMapper.employeeList();		
		// 디버깅 
		log.debug("직원 목록 : " + employeeList);
		
		return employeeList;
	}
	
	public int insertEmployee(Employee employee) {
		
		int result = empMapper.insertEmployee(employee);
		// 디버깅
		log.debug("employee 추가(성공:1,실패:0) : " + result);
		
		return result;
		
	}
	
	public int insertEmployeeDetail(EmployeeDetail employeeDetail) {
		
		int result = empMapper.insertEmployeeDetail(employeeDetail);
		// 디버깅
		log.debug("employeeDetail 추가(성공:1,실패:0) : " + result);
		
		return result;
	}
	
	public int insertEmployeeImg(EmployeeImg employeeImg) {
		
		int result = empMapper.insertEmployeeImg(employeeImg);
		// 디버깅
		log.debug("employeeImg 추가(성공:1,실패:0) : " + result);
		
		return result;
	}

}
