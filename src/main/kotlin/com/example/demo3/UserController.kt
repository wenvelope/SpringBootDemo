package com.example.demo3

import com.example.demo3.dao.MaterialDao
import com.example.demo3.dao.UserDao
import com.example.demo3.model.Material
import com.example.demo3.model.MaterialByRe
import com.google.gson.Gson
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = ["用户登录"])
class UserController {
    @Autowired
    private lateinit var userdao: UserDao

    @Autowired
    private lateinit var materialDao: MaterialDao

    @GetMapping("/user/login")
    fun login(
        @RequestParam(value = "email", required = true)
        email:String,
        @RequestParam(value = "password", required = true)
        password:String
    ): String{
        val userBean = userdao.findOnePerson(email)
        return if(userBean!=null){
            if(password==userBean.pwd){
                "登陆成功"
            }else{
                "密码错误"
            }
        }else{
            "用户不存在"
        }
    }

    @GetMapping("/material/all")
    fun getAllMaterial(): String {
        val gson = Gson()
        val materialByRe = MaterialByRe("1","1",materialDao.findAll())
        val str = gson.toJson(materialByRe)
        return str
    }

    @GetMapping("material/add")
    fun addNewMaterial():String{
        val material = Material("1","2","1","23","32","23","23","343")
        materialDao.save(material)
        return "save"
    }
}