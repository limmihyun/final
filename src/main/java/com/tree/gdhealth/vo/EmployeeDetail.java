package com.tree.gdhealth.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeDetail {

	private int employeeNo;
	
	@NotBlank(message = "이름을 입력해주세요.")
	private String employeeName;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String employeePhone;
	
	@Email
	@NotBlank(message = "이메일을 입력해주세요.")
	private String employeeEmail;
	
	@NotBlank(message = "성별을 선택해주세요.")
	private String employeeGender;
	
	private String createdate;
	private String updatedate;
}
