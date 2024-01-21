package com.tree.gdhealth.vo;

import lombok.Data;

@Data
public class ChatMessage {
	
	int chatMessageNo;
	int chatRoomNo;
	int messageSenderNo;
	String messageContent;
	String createdate;

}
