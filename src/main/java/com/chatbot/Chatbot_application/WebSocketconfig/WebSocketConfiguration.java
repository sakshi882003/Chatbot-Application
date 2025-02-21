package com.chatbot.Chatbot_application.WebSocketconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration // Marks this class as a configuration class
@EnableWebSocketMessageBroker // Enables WebSocket message handling with STOMP protocol
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Defining WebSocket endpoint where clients will connect
        registry.addEndpoint("/ws") // Clients will connect to WebSocket at /ws
                .withSockJS(); // Enables SockJS as a fallback for clients that don’t support WebSockets
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Clients will send messages to /app/chat or similar destinations
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");// Server will send messages to clients subscribed to /topic
        
    }
}
