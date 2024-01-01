package com.tree.gdhealth.branch.programcalendar.vo;

import lombok.Data;

import java.util.List;

/**<p> 주간 프로그램현황을 담는 vo</p>
 * @author 정인호
 */
@Data
public class BranchProgramCalendar {
    private int branchNo;
    private List<BranchProgramDate> branchDateList;

}
