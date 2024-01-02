package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.EmployeeDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Mapper
public interface EmployeeApiMapper {
    EmployeeDetail getEmployeeDetailByNo(int employeeNo);

    List<Map<String, Object>> getEmployeeListIsHeadOffice();

    List<Map<String, Object>> getBranchEmployeeList(int branchNo);
}
