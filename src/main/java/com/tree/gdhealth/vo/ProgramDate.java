package com.tree.gdhealth.vo;

import java.util.List;

import lombok.Data;

@Data
public class ProgramDate {
	
	private int programDateNo;
	private int programNo;
	private String programDate;
	private String createdate;
	private String updatedate;
	
	private List<String> programDates;
	private String originDate;

}
