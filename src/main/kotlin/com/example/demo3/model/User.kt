package com.example.demo3.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "User", discriminator = "用户信息")
data class User(
    @ApiModelProperty(value = "用户名")
    val name: String,
    @ApiModelProperty(value = "密码")
    val pwd: String
)
