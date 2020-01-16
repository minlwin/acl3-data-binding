package com.jdc.binding

import java.util.*

data class User(
    val firstName:String? = null,
    val lastName:String? = null,
    val dob:Date? = null,
    val contact: Contact? = null
) {
    val fullName:String?
        get() = if(null != firstName && null != lastName)
            "$firstName $lastName" else null
}

data class Contact(
    val phone:String,
    val email:String?
)