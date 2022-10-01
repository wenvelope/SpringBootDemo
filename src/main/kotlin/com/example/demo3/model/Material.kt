package com.example.demo3.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "material")
data class Material(
    @Id
    var uid:String ?=null,
    @Column
    var name:String?=null,
    @Column
    var state:String?=null,
    @Column
    val inboundNum:String ?=null,
    @Column
    var repoBeanUid:String?=null,
    @Column
    var category:String?=null,
    @Column
    val description:String?=null,
    @Column
    var born:String?=null
) {
    constructor():this(null,null,null,null,null,null,null,null)
}
