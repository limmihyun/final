package com.tree.gdhealth.headoffice.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
	
	List<Map<String, Object>> employeeList();
	
}
