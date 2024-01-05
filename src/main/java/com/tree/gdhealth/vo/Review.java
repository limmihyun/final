package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class Review {
	private int reviewNo;
	private int programReservationNo;
	private int customerNo;
	private String customerId;
	private String reviewTitle;
	private String reviewContent;
	private String createdate;
	private String updatedate;
}
