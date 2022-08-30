package com.example.demo3

import com.example.demo3.dao.UserDao
import com.example.demo3.model.User
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = ["测试接口"])
class TestController {
    @Autowired
    private lateinit var mailSender: JavaMailSender
    @Autowired
    private lateinit var userDao:UserDao


    companion object{
        const val fromEmail:String = "1425636954@qq.com"
    }

    fun  send(to:String,subject:String,content:String){
        val message = SimpleMailMessage().apply {
            setFrom(fromEmail)
            setTo(to)
            setSubject(subject)
            setText(content)
        }
        mailSender.send(message)
    }

    @GetMapping("/moon/email")
    fun sendEmail():String{
        val to = "1911630413@tiangong.edu.cn"
        val subject = "GDP你好"
        val content= "这是来自吴鸿儒的SpringBoot的第一封邮件"
        send(to,subject,content)
        return "sasa"
    }

    val wuhongru = User(1,"1425636954@qq.com","weewqe")

    @GetMapping("/user/all")
    fun getAllUsers(): List<User> {
        println(wuhongru.toString())
        return userDao.findAll()
    }


}