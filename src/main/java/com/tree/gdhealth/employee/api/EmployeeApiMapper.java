package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.EmployeeDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeApiMapper {
    EmployeeDetail getEmployeeDetailByNo(int employeeNo);

    List<Map<String, Object>> getEmployeeListIsHeadOffice();
}
