package com.tree.gdhealth.chat;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
			
	// 채팅방(고객)
	@GetMapping("/moveChating")
	public String chating(Model model, String customerId, ChatRoom chatRoom,
						@SessionAttribute("customerNo") int customerNo) {
		
		System.out.println("customerNo : " + customerNo);
		
		boolean isRoomExists = chatService.isRoomExists(customerNo);
		if(!isRoomExists) {
			chatRoom.setCustomerNo(customerNo);
			int insertRoom = chatService.insertRoom(chatRoom);
			model.addAttribute("roomNo",chatRoom.getChatRoomNo());
			System.out.println("방 추가 : " + insertRoom) ;
		}
		
		int roomNo = chatService.getRoomNo(customerId);
		model.addAttribute("roomNo",roomNo);
		model.addAttribute("customerId", customerId);
		model.addAttribute("status", "customer");
		
		return "chat/chat";
	
	}
	
	// 채팅창(본사)
	@GetMapping("/headofficeRoom")
	public String headofficeRoom(Model model, String customerId) {
		
		model.addAttribute("customerId", customerId);
		model.addAttribute("status", "employee");
		
		int roomNo = chatService.getRoomNo(customerId);
		model.addAttribute("roomNo", roomNo);
		
		return "chat/chat";
	}

}
