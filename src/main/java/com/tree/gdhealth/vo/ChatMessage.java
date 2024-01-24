package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class ChatMessage {
	
	int chatMessageNo;
	int chatRoomNo;
	Integer customerNo;
	Integer employeeNo;
	String messageContent;
	String createdate;

}
