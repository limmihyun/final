package com.tree.gdhealth.headoffice.emp.vo;

import lombok.Data;

@Data
public class EmployeeImg {
	
	private int employeeImgNo;
	private int employeeNo;
	private String employeeImgOriginName;
	private String employeeImgFilename;
	private long employeeImgSize;
	private String employeeImgType;
	private String createdate;
	private String updatedate;
	
}
