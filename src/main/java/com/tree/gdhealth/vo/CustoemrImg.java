package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class CustoemrImg {
	private int customerNo;
	private int customerImgNo;
	private String customerImgOriginName;
	private String customerImgFileName;
	private int customerImgSize;
	private String customerImgType;
	private String createdate;
	private String updatedate;
}
