package com.team02.groupware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.team02.groupware.dto.ChatMessage;
import com.team02.groupware.service.MessengerService;

@RestController
public class ChatController {
	
	@Autowired
	private MessengerService messengerService;
	
	// 채팅방 메시지 전송
	@MessageMapping("/chat.sendMessage/{userId}")
    @SendTo("/topic/public/{userId}")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage, @DestinationVariable String userId) {
		
		System.out.println("채팅 컨트롤러 유저아이디 : " + userId);
		System.out.println(chatMessage.getContent());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getChatRoomCode());
		
		
        return chatMessage;
    }
	
	//테스트
	@MessageMapping("/chat.test/{userId}")
    @SendTo("/topic/public/{userId}")
    public ChatMessage sendMessage2(@Payload ChatMessage chatMessage, @DestinationVariable String userId) {
		
		System.out.println(chatMessage.getContent());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getChatRoomCode());
		
		
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public2")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor){
    	
    	System.out.println(chatMessage.getUserId());
		System.out.println(chatMessage.getUserNickName());
		System.out.println(chatMessage.getType());
		System.out.println(chatMessage.getContent());
        headerAccessor.getSessionAttributes().put("userid", chatMessage.getUserId());
        return chatMessage;
    }
    
    // 채팅방 생성 메시지
    @MessageMapping("/chat.createChatRoom")
    @SendTo("/topic/public2")
    public ChatMessage createChatRoom(@Payload ChatMessage chatMessage){
    	
    	
    	
        return chatMessage;
    }

}
