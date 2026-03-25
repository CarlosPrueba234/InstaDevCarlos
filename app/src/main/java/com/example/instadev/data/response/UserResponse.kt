package com.example.instadev.data.response

import com.example.instadev.domain.entity.UserEntity
import com.example.instadev.domain.entity.UserMode

data class UserResponse(
    val userId: String,
    val name: String,
    val nickName: String,
    val follower: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {
    val userMode = when(userType){
        0 -> UserMode.REGULAR_USER
        1 -> UserMode.CONTENT_CREATOR_USER
        2 -> UserMode.COMPANY_USER
        else -> UserMode.REGULAR_USER
    }
    return UserEntity(userId, name, nickName, follower, following, userType)
}