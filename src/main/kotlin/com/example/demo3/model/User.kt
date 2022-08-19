package com.example.demo3.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import net.bytebuddy.implementation.InvokeDynamic.InvocationProvider.ArgumentProvider.ForThisInstance

@ApiModel(value = "User", discriminator = "用户信息")
data class User(
    @ApiModelProperty(value = "ID", example = "1")
    var id:Int?,
    @ApiModelProperty(value = "邮箱", example = "2312313@qq.com")
    var email: String?,
    @ApiModelProperty(value = "密码", example = "********")
    var pwd: String?
){
    constructor():this(null,null,null)
}
