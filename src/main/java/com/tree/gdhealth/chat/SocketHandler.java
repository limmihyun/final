package com.tree.gdhealth.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.tree.gdhealth.employee.login.LoginEmployee;

@Component
public class SocketHandler extends TextWebSocketHandler {
	
	List<HashMap<String, Object>> roomListSessions = new ArrayList<>(); // 웹소켓 세션을 담아둘 리스트
	ArrayList<HashMap<String, Object>> messageList = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		System.out.println("세션? : " + session.getAttributes());
		System.out.println("세션 정보 : " + session); // 세션 아이디는 랜덤 생성
		
		//소켓 연결
		boolean flag = false;
		String url = session.getUri().toString();
		String roomNo = url.split("/chating/")[1];
		
		int idx = roomListSessions.size(); //방의 사이즈를 조사한다.
		System.out.println("방의 개수 : " + idx);
		if(roomListSessions.size() > 0) {
			
			for(int i=0; i<roomListSessions.size(); i++) {
				String roomNoCheck = (String) roomListSessions.get(i).get("roomNo");
				
				if(roomNoCheck.equals(roomNo)) {
					flag = true;
					idx = i;
					break;
				}
			}
			
		}
		
		if(flag) { // 존재하는 방이라면 세션만 추가한다.
			// 해당 방에 대한 정보를 나타내는 map을 가져 온다.
			HashMap<String, Object> map = roomListSessions.get(idx);
			// 해당 방에 현재 연결된 session을 map에 추가한다.
			map.put(session.getId(), session);
			System.out.println("roomListSessions(이미 존재) : " + roomListSessions);
			
		} else { // 최초 생성하는 방이라면 방번호와 세션을 추가한다.
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("roomNo", roomNo);
			map.put(session.getId(), session);
			roomListSessions.add(map);
			System.out.println("roomListSessions(최초 생성) : " + roomListSessions);
		}
		
		// 세션 등록이 끝나면 발급받은 세션ID값의 메시지를 발송한다.
		JSONObject obj = new JSONObject();
		obj.put("type", "getId");
		
		
		////////////////////////////////////////////////////////////
		Object customerId = session.getAttributes().get("customerId");
		LoginEmployee loginEmployee =(LoginEmployee) session.getAttributes().get("loginEmployee");
		String employeeId = "";
		if(loginEmployee != null) {
			employeeId = loginEmployee.getEmployeeId();
		}
		
		if(customerId != null) {
			obj.put("id", session.getAttributes().get("customerId"));
		} else {
			obj.put("id", employeeId);
		}
		// 디버깅
		System.out.println("웹 소켓 연결 : " + obj);
		session.sendMessage(new TextMessage(obj.toJSONString()));
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		//메시지 발송
		String msg = message.getPayload();
		System.out.println("메시지 전송 : " + msg);
		JSONObject obj = jsonToObjectParser(msg);
		
		String roomNo = (String) obj.get("roomNo");
		HashMap<String, Object> temp = new HashMap<String, Object>();
		
		System.out.println("roomListSessions : " + roomListSessions.size());
		if(roomListSessions.size() > 0) {
			
			for(int i=0; i<roomListSessions.size(); i++) {
				String idCheck = (String) roomListSessions.get(i).get("roomNo"); // 세션리스트의 저장된 방 번호를 가져와서
				if(idCheck.equals(roomNo)) { // 같은 값의 방이 존재한다면
					// 해당 방 번호의 세션리스트에 존재하는 모든 object값(id, sessionId)을 가져온다.
					temp = roomListSessions.get(i); 
					break;
				}
			}
			
			// 해당 방의 세션들만 찾아서 메시지를 발송해준다.
			for(String k : temp.keySet()) {
				
				if(k.equals("roomNo")) { // 다만 방 번호일 경우에는 건너뛴다.(sessionId일 경우에만 적용)
					continue;
				}
				
				String message2 = (String) obj.get("msg");
				HashMap<String, Object> map = new HashMap<>();
				map.put("roomNo", roomNo);
				map.put("message", message2);
				messageList.add(map);
				System.out.println("messageList : " + messageList);
				
				WebSocketSession wss = (WebSocketSession) temp.get(k);
				System.out.println("webSocketSessions : " + wss);
				if(wss != null) {
					try {
						wss.sendMessage(new TextMessage(obj.toJSONString()));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		System.out.println("종료 session : " + session.getAttributes());
		List<String> chatMessages = (List<String>) session.getAttributes().get("msg");
		System.out.println("chatMessages : " + chatMessages);
		
		//소켓 종료
		if(roomListSessions.size() > 0) { //소켓이 종료되면 해당 세션값들을 찾아서 지운다.
			for(int i=0; i<roomListSessions.size(); i++) {
				roomListSessions.get(i).remove(session.getId());
			}
		}
	}
	
	private static JSONObject jsonToObjectParser(String jsonStr) {
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(jsonStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
