package com.tree.gdhealth.customer.customerattendance;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**<p>고객출결의 매퍼</p>
 * @author 정인호
 */
@Mapper
public interface CustomerAttendanceApiMapper {
    List<Map<String, Object>> getCustomerAttendanceList(@Param("programDateNo") int programDateNo, @Param("branchNo") int branchNo);

    void recordEnterTime(@Param("programReservationNo") int programReservationNo);

    void recordExitTime(@Param("programReservationNo") int programReservationNo);
}
