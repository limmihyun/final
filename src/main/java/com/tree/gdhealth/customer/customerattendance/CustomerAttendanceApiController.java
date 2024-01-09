package com.tree.gdhealth.customer.customerattendance;

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
public class CustomerAttendanceApiController {
    private final CustomerAttendanceApiService service;

    @GetMapping("/api/v1/customerAttendance/{programDateNo}")
    public List<Map<String, Object>> getCustomerAttendanceList(@PathVariable int programDateNo, @RequestParam int branchNo){
        return service.getCustomerAttendanceList(programDateNo, branchNo);
    }

    @GetMapping("/api/v1/customerAttendance/enter")
    public void recordEnterTime(@RequestParam int programReservationNo){
        service.recordEnterTime(programReservationNo);
    }

    @GetMapping("/api/v1/customerAttendance/exit")
    public void recordExitTime(@RequestParam int programReservationNo){
        service.recordExitTime(programReservationNo);
    }
}
