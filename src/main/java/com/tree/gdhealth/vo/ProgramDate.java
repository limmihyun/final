package com.tree.gdhealth.vo;

import java.util.List;

import com.tree.gdhealth.headoffice.customValidation.ListPattern;

import jakarta.validation.Valid;
import lombok.Data;


@Data
public class ProgramDate {
	
	private int programDateNo;
	private int programNo;
	private String programDate;
	private String createdate;
	private String updatedate;
	
	// 커스텀 애노테이션(기존의 @Pattern 애노테이션으로는 List 타입 검증이 불가해서 생성)
	@ListPattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "날짜 형식이 올바르지 않습니다.")
	private List<@Valid String> programDates;
    
	private String originDate;

}
