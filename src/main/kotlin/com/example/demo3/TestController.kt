package com.example.demo3

import com.example.demo3.model.User
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value =["/"])
@Api(tags = ["测试接口"])
class TestController {
    val wuHongRu = User("wuhongru","123456")

    @GetMapping("/moon")
    fun moon():ResponseEntity<Any>{
        return ResponseEntity(wuHongRu, HttpStatus.OK)
    }
    @ApiOperation(value = "返回你输入的param")
    @GetMapping("/moon/23")
    @ApiImplicitParams(ApiImplicitParam(name = "name", value = "sas", required = false,defaultValue = "sasa", paramType = "query", example = "sasa"),
        ApiImplicitParam(name = "2323", value = "sas", defaultValue = "sasa", paramType ="query", example = "sasa")
        )
    fun test2(@RequestParam(value = "name", required = false, defaultValue = "wuhongru") name:String):String{
        return name
    }
}