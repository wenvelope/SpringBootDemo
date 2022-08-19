package com.example.demo3.dao

import com.example.demo3.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class UserDaoService:UserDao {
    @Autowired
    lateinit var jdbcTemplate:JdbcTemplate

    override fun findAll(): List<User> {
        val sql = "select * from users"
        return jdbcTemplate.query(sql,BeanPropertyRowMapper(User::class.java))
    }
}