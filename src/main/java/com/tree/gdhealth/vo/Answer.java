package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class Answer {
	private int answerNo;
	private int questionNo;
	private int employeeNo;
	private String answerContent;
	private String createdate;
	private String updatedate;
}
