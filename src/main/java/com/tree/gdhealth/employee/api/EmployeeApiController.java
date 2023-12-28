package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.vo.Employee;
import com.tree.gdhealth.vo.EmployeeDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class EmployeeApiController {
    private final EmployeeApiService service;
    @GetMapping("/api/v1/employeeDetail/{employeeNo}")
    public EmployeeDetail getEmployeeDetailByNo(@PathVariable int employeeNo){
        return service.getEmployeeDetailByNo(employeeNo);
    }

    /*본사직원만 리스트로 가져옵니다.*/
    @GetMapping("/api/v1/employee")
    public List<Map<String, Object>> getEmployeeListIsHeadOffice(
            @RequestParam(name = "isHeadOffice") boolean isHeadOffice){
        if(isHeadOffice) {
            return service.getEmployeeListIsHeadOffice();
        }
        return null;
    }
}
