package com.chatbot.Chatbot_application.WebSocketconfig;

import java.util.Objects;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventlistener {
	private final SimpMessageSendingOperations messageOperations;

	@EventListener
	public void handleWebSocketDiscoonectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor =  StompHeaderAccessor.wrap(event.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if (Objects.nonNull(username)) {
			log.info("User disconnected: {}",username);
			
			
			messageOperations.convertAndSend("/topic/chat", message);
			
		}
	}
}
