package com.tree.gdhealth.employee.dto;

import lombok.Data;

/**<p> 직원의 상세정보를 담는 객체</p>
 * @author 정인호
 */

@Data
public class EmployeeInformation {
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
