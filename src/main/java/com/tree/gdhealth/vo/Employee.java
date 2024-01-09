package com.tree.gdhealth.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Employee {

	private int employeeNo;
	
	private Integer branchNo;
	
	@NotBlank(message = "ID를 입력해주세요.")
	@Size(max = 15, message = "ID의 최대 길이는 15입니다.")
	private String employeeId;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Size(max = 15, message = "비밀번호의 최대 길이는 15입니다.")
	private String employeePw;
	
	private String employeeActive;
	
	@NotBlank(message = "직책을 선택해주세요.")
	private String employeePosition;
	
	private String createdate;
	private String updatedate;
	
}
