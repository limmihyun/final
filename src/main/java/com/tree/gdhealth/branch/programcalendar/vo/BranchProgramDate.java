package com.tree.gdhealth.branch.programcalendar.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author 정인호
 */
@NoArgsConstructor
@Data
public class BranchProgramDate {
    private LocalDate date;
    private String dateName;
    private Boolean isHoliday;
    private int programDateNo;
    private int programNo;
    private String programName;
    private String programDetail;
    private int employeeNo; // editor
    private String employeeName;
    private int managerNo; // charged of branch
    private String managerName;
    private int maxCustomer;
    private int reservedCount;
}
