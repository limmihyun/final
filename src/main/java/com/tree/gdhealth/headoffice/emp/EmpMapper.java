package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeDetail;
import com.tree.gdhealth.headoffice.emp.vo.EmployeeImg;

@Mapper
public interface EmpMapper {
	
	List<Map<String, Object>> employeeList();
	
	int insertEmployee(Employee employee);
	int insertEmployeeDetail(EmployeeDetail employeeDetail);
	int insertEmployeeImg(EmployeeImg employeeImg);
	
}
