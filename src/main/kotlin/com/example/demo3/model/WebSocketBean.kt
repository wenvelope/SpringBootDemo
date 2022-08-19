package com.example.demo3.model

import org.springframework.web.socket.WebSocketSession

data class WebSocketBean(val webSocketSession: WebSocketSession,val clientEmail:String)
