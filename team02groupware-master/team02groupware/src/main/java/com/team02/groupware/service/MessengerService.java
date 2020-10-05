package com.team02.groupware.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.mapper.MessengerMapper;

@Service
@Transactional
public class MessengerService {
	
	@Autowired
	private MessengerMapper messengerMapper;
	
	// 채팅방 리스트 조회
	public List<Map<String,Object>> selectChatRoomList(String userId) {
		
		List<Map<String,Object>> chatRoomListMap = messengerMapper.selectChatRoomList(userId);
		
		System.out.println("채팅방리스트 투스트링 : " + chatRoomListMap.toString());
		System.out.println("시간 테스트 서비스단 : " + (String)chatRoomListMap.get(0).get("chatMsgDate"));
		
		return chatRoomListMap;
	}
	
	// 채팅방 상세보기
	public List<Map<String,Object>> chatRoomView(String roomCode) {
			
		List<Map<String,Object>> chatRoomLog = new ArrayList<Map<String,Object>>();
		chatRoomLog = messengerMapper.selectChatRoomView(roomCode);
		
		return chatRoomLog;
	}
	
	// 채팅 메시지 전송
	public void insertChatMessage(ChatMessage chatMessage) {
		
		messengerMapper.insertChatMessage(chatMessage);
		messengerMapper.updateLastChatMessage(chatMessage.getUserId(), chatMessage.getChatRoomCode());
	}
	
	// 유저 리스트 Select
	public List<Map<String, String>> selectUserList(String userId) {
		
		List<Map<String, String>> userList = messengerMapper.selectUserList(userId);
		String prevGroupName = "";
		
		for(int i = 0; i< userList.size(); i++) {
			
			String currentGroupName = userList.get(i).get("groupName");
			System.out.println(currentGroupName);
			if(prevGroupName.equals(currentGroupName)) {
				userList.get(i).put("check", "true");
			}else {
				userList.get(i).put("check", "false");
			}
			
			
			prevGroupName = currentGroupName;
			System.out.println(userList.get(i).get("check")+"리스트 셀렉트 테스트 ");
		}
		
		return userList;
	}
	
	// 대화방 생성
	public Map<String, Object> createChatRoom(Map<String, Object> roomInfo) {
		
		int a = messengerMapper.createChatRoom(roomInfo);
		System.out.println(roomInfo.get("roomCode") +" 셀렉트키 테스트");
		messengerMapper.insertUserChatRoom(roomInfo);
		messengerMapper.insertCreateChatMessage(roomInfo);
		return roomInfo;
		
	}
	
	// 채팅방 멤버 리스트 select
	public List<Map<String, Object>> chatRoomMember(String roomCode) {
		
		List<Map<String,Object>> chatRoomMember = new ArrayList<Map<String,Object>>();
		chatRoomMember = messengerMapper.chatRoomMember(roomCode);
		return chatRoomMember;
	}
	
	// 마지막으로 읽은 채팅메시지 update
	public void updateLastChatMessage(String userId, String chatRoomCode) {
		
		messengerMapper.updateLastChatMessage(userId, chatRoomCode);
	}
	
	// selectNewChatRoom
	public Map<String, Object> selectNewChatRoom(String chatRoomCode) {
			
		Map<String,Object> roomInfo = messengerMapper.selectNewChatRoom(chatRoomCode);
		
		return roomInfo;
	}
	
	// 채팅방 생성시 읽은 메시지 업데이트
	public void updateNewChatRoomMsg(String userId, String chatRoomCode) {
		
		messengerMapper.updateNewChatRoomMsg(userId, chatRoomCode);
	}
	
	

}
