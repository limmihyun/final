package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class CustomerMyPage {
	private Integer customerNo;
	private String customerId;
	private String customerBirth;
	private int customerHeight;
	private int customerWeight;
	private int attendanceCount;
	private int reviewCount;
	private int questionCount;
	private double customerBmi;
	private String customerName;
	private String customerEmail;
	private String customerUpdatedate;
}
