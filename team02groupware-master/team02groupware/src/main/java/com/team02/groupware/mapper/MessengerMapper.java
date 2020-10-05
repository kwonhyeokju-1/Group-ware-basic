package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.ChatMessage;




@Mapper
public interface MessengerMapper {
	
	public void insertChatMessage(ChatMessage chatMessage);

	public List<Map<String, Object>> selectChatRoomList(String userId);

	public List<Map<String, Object>> selectChatRoomView(String roomCode);

	public List<Map<String, String>> selectUserList(String userId);

	public int createChatRoom(Map<String, Object> roomInfo);

	public void insertUserChatRoom(Map<String, Object> roomInfo);

	public void insertCreateChatMessage(Map<String, Object> roomInfo);

	public List<Map<String, Object>> chatRoomMember(String roomCode);

	public void updateLastChatMessage(String userId, String chatRoomCode);

	public String selectUnReadMessageCount(Object chatMsgCode, Object chatRoomCode);

	public Map<String, Object> selectNewChatRoom(String chatRoomCode);

	public void updateNewChatRoomMsg(String userId, String chatRoomCode);
	
}
