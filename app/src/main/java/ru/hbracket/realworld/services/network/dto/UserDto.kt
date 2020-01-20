package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("image")
    val image: String?
)