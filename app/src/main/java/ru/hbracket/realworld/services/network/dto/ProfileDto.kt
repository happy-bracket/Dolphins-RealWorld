package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("bio")
    val bio: String,
    @SerializedName("image")
    val image: String?,
    @SerializedName("following")
    val following: Boolean
)