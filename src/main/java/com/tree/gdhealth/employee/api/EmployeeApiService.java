package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.headoffice.emp.vo.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** <p></p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EmployeeApiService {
    private final EmployeeApiMapper mapper;
    public EmployeeDetail getEmployeeDetailByNo(int employeeNo){
        return mapper.getEmployeeDetailByNo(employeeNo);
    }

    public List<Employee> getEmployeeListIsHeadOffice() {
        return mapper.getEmployeeListIsHeadOffice();
    }
}
