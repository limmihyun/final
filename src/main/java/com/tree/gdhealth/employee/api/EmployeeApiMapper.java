package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformationDto;
import com.tree.gdhealth.employee.dto.EmployeeRetrieveCriteria;
import com.tree.gdhealth.vo.EmployeeDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 정인호
 */
@Mapper
public interface EmployeeApiMapper {
    EmployeeDetail getEmployeeDetailByNo(int employeeNo);

    List<EmployeeInformationDto> selectEmployeeListByCriteria(EmployeeRetrieveCriteria criteria);

    List<EmployeeInformationDto> selectEmployeeListByBranchNo(int branchNo);
}
