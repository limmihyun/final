package com.tree.gdhealth.customer.programreservation.vo;

import lombok.Data;

@Data
public class ProgramReservation {
	private String programName;
	private String programData;
	private String customerId;
	private String branchName;
	private int programDateNo;
	private int branchNo;
}
