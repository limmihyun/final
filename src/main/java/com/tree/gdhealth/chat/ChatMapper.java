package com.tree.gdhealth.chat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.ChatRoom;


@Mapper
public interface ChatMapper {
	
	List<Map<String, Object>> roomList();
	boolean isRoomExists(int customerNo);
	int getRoomNo(String customerId);
	
	int insertRoom(ChatRoom chatRoom);

}
