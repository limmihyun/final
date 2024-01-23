package com.tree.gdhealth.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tree.gdhealth.vo.ChatRoom;

import lombok.RequiredArgsConstructor;

@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private final ChatService chatService;
	
	/**
	 * 방 페이지
	 * @return
	 */
	@GetMapping("/room")
	public String room(Model model) {
		
		List<Map<String, Object>> roomList = chatService.getRoomList();
		
		model.addAttribute("roomList", roomList);

		return "chat/room";
	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	@PostMapping("/room")
	public @ResponseBody ChatRoom insertRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
		
		ChatRoom getInsertRoom = null;
		if(roomName != null && !roomName.trim().equals("")) {
			
			ChatRoom room = new ChatRoom();
			// room.setRoomNumber(++roomNumber);
	//		room.setRoomName(roomName);
	//		int insertRoom = chatService.insertRoom(room);
	//		System.out.println("insertRoom : " + insertRoom);
			
			// 추가된 방에 대한 정보 불러 오기
	//		getInsertRoom = chatService.getRoomOne(room.getRoomNumber());
			
		}
		
		return getInsertRoom;
	}
		
	/**
	 * 채팅방
	 * @return
	 */
	@GetMapping("/moveChating")
	public String chating(Model model, String customerId,
						@SessionAttribute("customerNo") int customerNo) {
		
		System.out.println("customerNo : " + customerNo);
		
		boolean isRoomExists = chatService.isRoomExists(customerNo);
		if(!isRoomExists) {
			int insertRoom = chatService.insertRoom(customerNo);
			System.out.println("방 추가 : " + insertRoom) ;
		}
		
		model.addAttribute("customerId", customerId);
		
		return "chat/chat";
	
	}

}
