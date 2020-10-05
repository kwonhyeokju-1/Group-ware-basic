package com.team02.groupware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.service.MessengerService;


@Controller
public class MessengerController {
	
	@Autowired
	private MessengerService messengerService;
	
	// 대화방 생성 모달
	@GetMapping("/createChatRoomModal")
	public String createChatRoomModal(Model model, HttpSession session){
		
		String userId = (String) session.getAttribute("userId");
		System.out.println(userId+" 대화방 생성 모달 아이디 확인");
		List<Map<String, String>> userList = messengerService.selectUserList(userId);
		model.addAttribute("userList", userList);
		
		return "messenger/modal/createChatRoomModal";
	}
	
	@GetMapping("/createChatRoom")
	public String createChatRoom(Model model, @RequestParam("roomName") String roomName,
		@RequestParam(value="roomMember[]", required = false) List<String> roomMember,
		HttpSession session){
		
		System.out.println("gdgd");
		Map<String,Object> roomInfo = new HashMap<String,Object>();
		System.out.println(roomName);
		roomMember.add((String) session.getAttribute("userId"));
		if(roomMember != null) {
			for(int i=0; i < roomMember.size(); i++) {				
				System.out.println(roomMember.get(i));
			}
		}
		int roomCount = roomMember.size();
		roomInfo.put("roomName", roomName);
		roomInfo.put("roomMember", roomMember);
		roomInfo.put("roomCount", roomCount);
		roomInfo.put("roomCode", 0);
		System.out.println(roomInfo.get("roomMember").toString());
		roomInfo = messengerService.createChatRoom(roomInfo);
		model.addAttribute("roomInfo", roomInfo);
		return "messenger/newChatRoom";
	}
	
	
	// 채팅방 유저 초대 모달
	@GetMapping("/inviteUserModal")
	public String inviteUserModal(Model model){
		
		return "messenger/modal/inviteUserModal";
	}
	
	// 채팅방 리스트
	@GetMapping("/selectChatRoomList")
	public String selectChatRoomList(Model model, HttpSession session){
		
		String userId = (String) session.getAttribute("userId");
		List<Map<String,Object>> chatRoomListMap = messengerService.selectChatRoomList(userId);
		
		System.out.println("시간 테스트 : " + chatRoomListMap.get(0).get("chatMsgDate"));
		model.addAttribute("chatRoomListMap", chatRoomListMap);
		return "messenger/chatRoomList";
	}
	
	// 채팅방 상세보기
	@GetMapping("/chatRoomView")
	public String chatRoomView(Model model,
			HttpSession session,
			@RequestParam(value="roomCode") String roomCode){
		
		List<Map<String,Object>> chatRoomLog = new ArrayList<Map<String,Object>>();
		chatRoomLog = messengerService.chatRoomView(roomCode);
		List<Map<String,Object>> chatRoomMember = new ArrayList<Map<String,Object>>();
		chatRoomMember = messengerService.chatRoomMember(roomCode);
		String userId = (String) session.getAttribute("userId");
		messengerService.updateLastChatMessage(userId, roomCode);
		
		System.out.println(chatRoomLog.toString());
		model.addAttribute("chatRoomLog", chatRoomLog);
		model.addAttribute("userId", userId);
		model.addAttribute("roomCode", roomCode);
		model.addAttribute("chatRoomMember", chatRoomMember);
		
		return "messenger/chatRoomView";
	}
	
	// 채팅메시지 insert
	@RequestMapping(value="/insertChatMessage", method=RequestMethod.POST)
	public @ResponseBody String insertChatMessage(Model model, @RequestBody ChatMessage chatMessage){
		
		System.out.println("채팅 인서트 테스트 : " + chatMessage.toString());
		
		messengerService.insertChatMessage(chatMessage);
		
		return null;
	}
	
	@GetMapping("/chatTest")
	public String chatTest(Model model) {
		
			
		return "messenger/chatTest";
	}
	
	// 마지막으로 읽은 채팅메시지 update
	@GetMapping("/updateLastChatMessage")
	public @ResponseBody String updateLastChatMessage(HttpSession session, @RequestParam(value="chatRoomCode") String chatRoomCode){
		
		System.out.println("업데이트라스트챗메시지 챗룸코드 : " + chatRoomCode);
		String userId = (String) session.getAttribute("userId");
		messengerService.updateLastChatMessage(userId, chatRoomCode);
		
		return null;
	}
	
	//
	@GetMapping("/selectNewChatRoom")
	public String selectNewChatRoom(Model model, HttpSession session, @RequestParam(value="chatRoomCode") String chatRoomCode){
		
		System.out.println("selectNewChatRoom");
		Map<String,Object> roomInfo = messengerService.selectNewChatRoom(chatRoomCode);
		String userId = (String) session.getAttribute("userId");
		messengerService.updateNewChatRoomMsg(userId, chatRoomCode);
		model.addAttribute("roomInfo", roomInfo);
		return "messenger/newChatRoom";
	}
	
	
	
	

}
