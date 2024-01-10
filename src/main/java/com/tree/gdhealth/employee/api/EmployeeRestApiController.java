package com.tree.gdhealth.employee.api;

import com.tree.gdhealth.employee.dto.EmployeeInformationDto;
import com.tree.gdhealth.utils.exception.TooManyResultsException;
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

/**@apiNote Employee 도메인을 담당하는 REST API Controller
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class EmployeeRestApiController {
    private final EmployeeApiService service;

    /**<p>응답엔티티를 생성하는 메서드</p>
     * @param responseObject object
     * @return responseObject 가 널? 404 notFound : 200 ok
     */
    private ResponseEntity<Object> generateResponseEntity(Object responseObject){
        if(responseObject == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("serverMessage","조회결과가 없습니다."));
        }
        return  ResponseEntity.ok(responseObject);
    }

    /**<p>직원 1명의 정보를 호출</p>
     * @param employeeNo 직번
     * @return 조회된 직원정보
     */
    @GetMapping(value = "/api/v1/employee/{employeeNo}")
    public ResponseEntity<Object> getEmployeeOneByEmployeeNo(@PathVariable(name = "employeeNo") int employeeNo){
        try{
            return generateResponseEntity(service.getEmployeeOneByEmployeeNo(employeeNo));
        }catch (TooManyResultsException e){
            return ResponseEntity.internalServerError().body(Map.of("serverMessage","2개 이상 조회되었습니다."));
        }
    }

    /**<p>본사 직원리스트/ 모든 직원리스트 호출</p>
     * @param isHeadOffice ture/false
     * @return 조회된 리스트
     */
    @GetMapping(value = "/api/v1/employee",params = "isHeadOffice")
    public ResponseEntity<Object> getEmployeeListIsHeadOffice(@RequestParam(name = "isHeadOffice") boolean isHeadOffice){
        return generateResponseEntity(service.getEmployeeListIsHeadOffice());
    }

    /**<p>특정지점에 소속된 직원리스트 호출</p>
     * @param branchNo 지점번호
     * @return 조회된 리스트
     */
    @GetMapping(value = "/api/v1/employee", params = "branchNo")
    public ResponseEntity<Object> getEmployeeListByBranchNo(@RequestParam(name = "branchNo") int branchNo){
        return generateResponseEntity(service.getEmployeeListByBranchNo(branchNo));
    }
}
