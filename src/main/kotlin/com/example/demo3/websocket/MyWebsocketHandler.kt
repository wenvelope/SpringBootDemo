package com.example.demo3.websocket

import com.example.demo3.model.MessageBean
import com.example.demo3.model.WebSocketBean
import com.fasterxml.jackson.databind.util.JSONPObject
import com.google.gson.Gson
import com.mysql.cj.xdevapi.JsonArray
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.AbstractWebSocketHandler
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger
import javax.websocket.server.ServerEndpoint

//@ServerEndpoint("/websocket")
class MyWebsocketHandler : AbstractWebSocketHandler() {


    companion object{
        val webSocketBeanMap = ConcurrentHashMap<String,WebSocketBean>()
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        val token = session.attributes["TOKEN"].toString()
        println(token+"已连接")
        webSocketBeanMap[session.id] = WebSocketBean(session,token)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
        if(session.isOpen){
            session.close()
        }
        println(session.id+"已断开")
        webSocketBeanMap.remove(session.id)
    }



    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        super.handleTextMessage(session, message)
        val messageBean = with(Gson()) {
            this.fromJson(message.payload,MessageBean::class.java)
        }

        webSocketBeanMap.forEach{
            if(it.value.clientEmail == messageBean.to){
                it.value.webSocketSession.sendMessage(message)
            }
        }
    }

}