package com.tree.gdhealth.program.dto;

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
    private Boolean isToday;
    private int programDateNo;
    private int programNo;
    private String programName;
    private String programDetail;
    private int writerEmployeeNo; // editor
    private String employeeName;
    private int trainerEmployeeNo; // charged of branch
    private String managerName;
    private int maxCustomer;
    private int reservedCount;
}
