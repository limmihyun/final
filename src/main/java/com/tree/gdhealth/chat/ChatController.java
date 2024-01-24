package com.tree.gdhealth.chat;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tree.gdhealth.utils.auth.Auth;
import com.tree.gdhealth.utils.auth.Authority;
import com.tree.gdhealth.vo.ChatMessage;
import com.tree.gdhealth.vo.ChatRoom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/chat")
@RequiredArgsConstructor
@Controller
public class ChatController {
	
	private final ChatService chatService;
	
	// 방
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping("/roomList")
	public String room(Model model) {
				
		List<Map<String, Object>> roomList = chatService.getRoomList();
		model.addAttribute("roomList", roomList);

		return "chat/room";
	}
			
	// 채팅방(고객)
	@Auth(AUTHORITY = Authority.CUSTOMER_ONLY)
	@GetMapping("/customerRoom")
	public String chatting(Model model, String customerId, ChatRoom chatRoom,
						@SessionAttribute("customerNo") int customerNo) {
				
		boolean isRoomExists = chatService.isRoomExists(customerNo);
		if(!isRoomExists) {
			
			chatRoom.setCustomerNo(customerNo);
			int insertRoom = chatService.insertRoom(chatRoom);
			log.debug("방 추가(성공:1) : " + insertRoom);
			
			model.addAttribute("roomNo",chatRoom.getChatRoomNo());
		}
		
		model.addAttribute("customerId", customerId);
		model.addAttribute("status", "customer");
		
		int roomNo = chatService.getRoomNo(customerId);
		model.addAttribute("roomNo",roomNo);
		
		List<ChatMessage> messageList = chatService.getChatList(roomNo);
		model.addAttribute("messageList", messageList);
		log.debug("messageList : " + messageList.toString());
		
		return "chat/chat";
	
	}
	
	// 채팅창(본사)
	@Auth(AUTHORITY = Authority.HEAD_EMP_ONLY)
	@GetMapping("/headofficeRoom")
	public String headofficeRoom(Model model, String customerId) {
		
		model.addAttribute("customerId", customerId);
		model.addAttribute("status", "employee");
		
		int roomNo = chatService.getRoomNo(customerId);
		model.addAttribute("roomNo", roomNo);
		
		List<ChatMessage> messageList = chatService.getChatList(roomNo);
		model.addAttribute("messageList", messageList);
		log.debug("messageList : " + messageList.toString());
		
		return "chat/chat";
	}

}
