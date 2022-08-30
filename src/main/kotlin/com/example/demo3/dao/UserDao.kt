package com.example.demo3.dao

import com.example.demo3.model.User

interface UserDao {
    fun findAll():List<User>

    fun findOnePerson(email:String): User?
}