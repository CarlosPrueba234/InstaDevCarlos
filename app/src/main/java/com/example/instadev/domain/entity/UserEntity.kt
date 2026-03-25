package com.example.instadev.domain.entity

data class UserEntity (
    val userId: String,
    val name: String,
    val nickName: String,
    val follower: Int,
    val following: List<String>,
    val userMode: Int
)

sealed class UserMode(val userType: Int){
    object REGULAR_USER: UserMode(0)
    object CONTENT_CREATOR_USER: UserMode(1)
    object COMPANY_USER: UserMode(2)

}