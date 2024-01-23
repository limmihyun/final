package com.tree.gdhealth.chat;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.ChatRoom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class ChatService {
	
	private final ChatMapper chatMapper;
	
	public List<Map<String, Object>> getRoomList() {
		
		List<Map<String, Object>> ChatRoomList = chatMapper.roomList();
		
		return ChatRoomList;
		
	}
	
	public int getRoomNo(String customerId) {
		
		int getRoomNo = chatMapper.getRoomNo(customerId);
		
		return getRoomNo;
	}
	
	public boolean isRoomExists(int customerNo) {
		
		boolean isRoomExists = chatMapper.isRoomExists(customerNo);
		
		return isRoomExists;
	}
	
	public int insertRoom(ChatRoom chatRoom) {
		
		int result = chatMapper.insertRoom(chatRoom);
		
		return result;
		
	}

}
