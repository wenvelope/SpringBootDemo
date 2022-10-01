package com.example.demo3.model

data class MaterialByRe(
    val uid:String,
    val name:String,
    val materialList:MutableIterable<Material>
) {
}