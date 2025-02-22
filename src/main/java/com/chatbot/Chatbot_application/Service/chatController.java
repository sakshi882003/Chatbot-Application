package com.chatbot.Chatbot_application.Service;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class chatController {

	@MessageMapping("chat.sendMessage")
	@SendTo("/topic/chat")
	public MessageDTO sendMsg(@Payload MessageDTO msg) {
		return msg;
		
	}
	
	@MessageMapping("chat.adduser")
	@SendTo("/topic/chat")
	public MessageDTO addUser(@Payload MessageDTO msg, SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", msg.getSender());
		return msg;
		
	}
	
}
