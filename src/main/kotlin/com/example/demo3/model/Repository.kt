package com.example.demo3.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "repository")
data class Repository(
    @Id
    var uid:String ?=null,
    @Column
    var name:String ?=null,
    @Column
    var country:String?=null,
    @Column
    var area:String?=null,
    @Column
    var state:String?=null
){
    constructor():this(null,null,null,null,null)
}
