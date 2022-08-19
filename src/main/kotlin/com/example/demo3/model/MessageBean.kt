package com.example.demo3.model


data class MessageBean(
    var form :String?,
    var to:String?,
    var message:String?
){
    constructor():this(null,null,null)
}

