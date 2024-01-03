package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class Customer {
	private Integer customerNo;
	private String customerId;
	private String customerPw;
	private String customerActive;
	private String customerBirth;
	private String createdate;
	private String updatedate;
}
