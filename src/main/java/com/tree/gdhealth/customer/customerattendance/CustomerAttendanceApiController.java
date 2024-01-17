package com.tree.gdhealth.customer.customerattendance;

import com.tree.gdhealth.utils.ResponseEntityGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**<p> 회원의 출결을 기록하는 RESTAPI</p>
 * @author 정인호
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class CustomerAttendanceApiController {
    private final CustomerAttendanceApiService service;
    private final ResponseEntityGenerator responseEntityGenerator;

    /**<p>날짜의 예약한 고객과 출결정보를 호출</p>
     */
    @GetMapping("/api/v1/customerAttendance/{programDateNo}")
    public ResponseEntity<Object> getCustomerAttendanceList(@PathVariable int programDateNo, @RequestParam int branchNo){

        return responseEntityGenerator.respGET(service.getCustomerAttendanceList(programDateNo, branchNo));
    }

    /**<p>입장</p>
     */
    @GetMapping("/api/v1/customerAttendance/enter")
    public void recordEnterTime(@RequestParam int programReservationNo){
        service.recordEnterTime(programReservationNo);
    }

    /**<p>퇴실</p>
     */
    @GetMapping("/api/v1/customerAttendance/exit")
    public void recordExitTime(@RequestParam int programReservationNo){
        service.recordExitTime(programReservationNo);
    }
}
