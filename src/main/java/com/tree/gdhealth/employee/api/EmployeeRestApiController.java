package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformationDto;
import com.tree.gdhealth.vo.EmployeeDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class EmployeeRestApiController {
    private final EmployeeApiService service;

    private ResponseEntity<Object> generateResponseEntity(Object responseObject){
        if(responseObject == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("serverMessage","조회결과가 없습니다."));
        }else{
            return  ResponseEntity.ok(responseObject);
        }
    }

    @GetMapping("/api/v1/employeeDetail/{employeeNo}")
    public EmployeeDetail getEmployeeDetailByNo(@PathVariable int employeeNo){
        return service.getEmployeeDetailByNo(employeeNo);
    }


    /**<p>본사 직원리스트/ 모든 직원리스트 호출</p>
     * @param isHeadOffice ture/false
     * @return 조회된 리스트
     */
    @GetMapping(value = "/api/v1/employee",params = "isHeadOffice")
    public ResponseEntity<Object> getEmployeeListIsHeadOffice(@RequestParam(name = "isHeadOffice") boolean isHeadOffice){
        List<EmployeeInformationDto> dtoList = service.getEmployeeListIsHeadOffice();

        return generateResponseEntity(dtoList);
    }



    /**<p>특정지점에 소속된 직원리스트 호출</p>
     * @param branchNo 지점번호
     * @return 조회된 리스트
     */
    @GetMapping(value = "/api/v1/employee", params = "branchNo")
    public ResponseEntity<Object> getEmployeeListByBranchNo(@RequestParam(name = "branchNo") int branchNo){
        List<EmployeeInformationDto> dtoList = service.getEmployeeListByBranchNo(branchNo);

        return generateResponseEntity(dtoList);
    }
}
