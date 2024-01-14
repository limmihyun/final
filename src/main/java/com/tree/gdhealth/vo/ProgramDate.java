package com.tree.gdhealth.vo;

import java.util.List;

import com.tree.gdhealth.headoffice.customValidation.FutureDate;
import com.tree.gdhealth.headoffice.customValidation.FutureDateGroup;
import com.tree.gdhealth.headoffice.customValidation.ListGroup;
import com.tree.gdhealth.headoffice.customValidation.ListPattern;

import lombok.Data;


@Data
public class ProgramDate {
	
	private int programDateNo;
	private int programNo;
	private String programDate;
	private String createdate;
	private String updatedate;
	
	/*
		커스텀 애노테이션(기존의 @Pattern 애노테이션으로는 List 타입 검증이 불가해서 생성)
		@ListPattern : List의 각각의 String에 대해 날짜 형식이 올바른지 검증
		@FutureDate : List의 각각의 String에 대해 현재 날짜와 동일하거나 현재 날짜 이후인지 검증
	*/
	@ListPattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", groups = ListGroup.class)
	@FutureDate(groups = FutureDateGroup.class)
	private List<String> programDates;
    
	// 프로그램 날짜를 수정하기 전의 날짜
	private String originDate;

}
