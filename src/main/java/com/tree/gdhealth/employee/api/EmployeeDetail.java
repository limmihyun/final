package com.tree.gdhealth.employee.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDetail {
    private int employeeNo;
    private String employeeName;
    private String employeePhone;
    private String employeeEmail;
    private String employeeGender;
    private LocalDateTime createdate;
    private LocalDateTime updatedate;
}
