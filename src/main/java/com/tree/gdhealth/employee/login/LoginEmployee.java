package com.tree.gdhealth.employee.login;

import lombok.Data;

/**
 * @author 정인호
 * <p>로그인세션에 담기는 직원의 정보 객체</p>
 */

@Data
public class LoginEmployee {
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
