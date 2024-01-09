package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformationDto;
import com.tree.gdhealth.employee.dto.EmployeeRetrieveCriteria;
import com.tree.gdhealth.vo.EmployeeDetail;
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

    public List<EmployeeInformationDto> getEmployeeListIsHeadOffice() {
        return mapper.selectEmployeeListByCriteria(EmployeeRetrieveCriteria.isHeadOffice());
    }

    public List<EmployeeInformationDto> getEmployeeListByBranchNo(int branchNo) {
        return mapper.selectEmployeeListByCriteria(EmployeeRetrieveCriteria.branchNo(branchNo));
    }
}
