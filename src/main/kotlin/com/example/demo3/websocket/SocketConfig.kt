package com.example.demo3.websocket

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry


@Configuration
@EnableWebSocket
class SocketConfig:WebSocketConfigurer {
    @Bean
    fun webSocketInterceptor():MyWebSocketInterceptor{
        return MyWebSocketInterceptor()
    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(MyWebsocketHandler(),"websocket")
            .addInterceptors(webSocketInterceptor())
            .setAllowedOrigins("*")
    }


}