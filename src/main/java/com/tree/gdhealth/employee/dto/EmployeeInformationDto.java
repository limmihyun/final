package com.tree.gdhealth.employee.dto;

import lombok.Data;

/**
 * @author 정인호
 */

@Data
public class EmployeeInformationDto {
	//employee
	private Integer employeeNo;
	private Integer branchNo;
	private String employeeId;
	private String employeeActive;
	private String employeePosition;

	//employee_detail
	private String employeeName;
	private String employeePhone;
	private String employeeEmail;
	private String employeeGender;

	//employee_img
	private String employeeImgNo;
	private String employeeImgOriginName;
	private String employeeImgFileName;
	private String employeeImgSize;
	private String employeeImgType;

	//branch
	private String branchName;
	private String branchLevel;
}
