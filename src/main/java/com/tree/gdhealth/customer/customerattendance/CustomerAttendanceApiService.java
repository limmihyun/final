package com.tree.gdhealth.customer.customerattendance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CustomerAttendanceApiService {
    private final CustomerAttendanceApiMapper mapper;
    public List<Map<String, Object>> getCustomerAttendanceList(int programDateNo, int branchNo) {
        return mapper.getCustomerAttendanceList(programDateNo, branchNo);
    }

    public void recordEnterTime(int programReservationNo) {
        mapper.recordEnterTime(programReservationNo);
    }

    public void recordExitTime(int programReservationNo) {
        mapper.recordExitTime(programReservationNo);
    }
}
