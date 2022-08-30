package com.example.demo3.dao

import com.example.demo3.model.User
import com.mysql.cj.x.protobuf.MysqlxExpr
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

    override fun findOnePerson(email: String): User?{
        val sql = "select * from users where email =\"$email\""
        return try {
            jdbcTemplate.queryForObject(sql,BeanPropertyRowMapper(User::class.java))
        }catch (e:Exception){
            null
        }
    }
}