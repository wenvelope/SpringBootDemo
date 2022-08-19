package com.example.demo3

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.web.socket.config.annotation.EnableWebSocket


@SpringBootApplication
class Demo3Application

fun main(args: Array<String>) {
    runApplication<Demo3Application>(*args)
}




