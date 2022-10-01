package com.example.demo3.dao

import com.example.demo3.model.Material
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
interface MaterialDao:CrudRepository<Material,String> {
    fun findAllByRepoBeanUid(repoBeanUid: String):MutableIterable<Material>
}