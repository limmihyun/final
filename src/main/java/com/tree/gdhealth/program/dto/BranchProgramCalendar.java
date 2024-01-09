package com.tree.gdhealth.program.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**<p> 주간 프로그램현황을 담는 vo</p>
 * @author 정인호
 */
@Data
public class BranchProgramCalendar {
    private int branchNo;
    private List<BranchProgramDate> branchDateList;
    private LocalDate requestDate;
    private LocalDate previousWeekDate;
    private LocalDate nextWeekDate;
}
