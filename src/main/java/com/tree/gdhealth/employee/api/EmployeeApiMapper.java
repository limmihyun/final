package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeApiMapper {
    EmployeeDetail getEmployeeDetailByNo(int employeeNo);

    List<Employee> getEmployeeListIsHeadOffice();
}
