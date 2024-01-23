package com.tree.gdhealth.chat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChatMapper {
	
	List<Map<String, Object>> roomList();
	boolean isRoomExists(int customerNo);
	
	int insertRoom(int customerNo);

}
