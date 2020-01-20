package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class UpdateUserDto(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("bio")
    val bio: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("password")
    val password: String? = null
)