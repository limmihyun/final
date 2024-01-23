package com.tree.gdhealth.customer.customerattendance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**<p>고객출결관리 서비스</p>
 * @author 정인호
 */
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CustomerAttendanceApiService {
    private final CustomerAttendanceApiMapper mapper;

    /**
     * @return 해당 프로그램 날짜 번호와 지점에 예약한 고객의 출결정보
     */
    public List<Map<String, Object>> getCustomerAttendanceList(int programDateNo, int branchNo) {
        return mapper.getCustomerAttendanceList(programDateNo, branchNo);
    }

    /** 입장 시간기록
     */
    public void recordEnterTime(int programReservationNo) {
        mapper.recordEnterTime(programReservationNo);
    }

    /**퇴실 시간기록
     */
    public void recordExitTime(int programReservationNo) {

        mapper.recordExitTime(programReservationNo);
    }
}
