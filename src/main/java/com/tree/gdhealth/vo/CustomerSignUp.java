package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class CustomerSignUp {
	private int customerNo;
	private String customerId;
	private String customerPw;
	private String customerActive;
	private String customerName;
	private String customerGender;
	private int customerHeight;
	private int customerWeight;
	private int customerAge;
	private String customerPhone;
	private String customerAddress;
	private String customerEmail;
	private int customerImgNo;
	private String customerImgOriginName;
	private String customerImgFileName;
	private int customerImgSize;
	private String customerImgType;
	private String createdate;
	private String updatedate;
	
}
