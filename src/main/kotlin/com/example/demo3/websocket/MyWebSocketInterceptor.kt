package com.example.demo3.websocket

import com.example.demo3.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.http.server.ServletServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor
import java.lang.Exception

class MyWebSocketInterceptor: HttpSessionHandshakeInterceptor() {
    @Autowired
    private lateinit var userDao: UserDao

    override fun beforeHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Boolean {
        println("before")
        val mRequest = (request as ServletServerHttpRequest).servletRequest
        val token = mRequest.getHeader("TOKEN")?:return false
        val list = userDao.findAll()
        list.forEach {
            if(it.email.equals(token)){
                attributes["TOKEN"] = token
                return super.beforeHandshake(request, response, wsHandler, attributes)
            }
        }
        return false
    }

    override fun afterHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        ex: Exception?
    ) {
        super.afterHandshake(request, response, wsHandler, ex)
        println("after")
    }
}