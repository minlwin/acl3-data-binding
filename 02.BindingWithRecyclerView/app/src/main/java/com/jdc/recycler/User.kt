package com.jdc.recycler

data class User(val name:String, val phone:String)

object UserModel {

    val users:List<User> = mutableListOf<User>().also {
        for (index in 1 .. 20) {
            it.add(User("Name $index", "Phone $index"))
        }
    }
}