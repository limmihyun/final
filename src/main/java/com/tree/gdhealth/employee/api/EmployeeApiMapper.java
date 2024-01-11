package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformation;
import com.tree.gdhealth.employee.dto.EmployeeRetrieveCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 정인호
 */
@Mapper
public interface EmployeeApiMapper {

    List<EmployeeInformation> selectEmployeeListByCriteria(EmployeeRetrieveCriteria criteria);
}
