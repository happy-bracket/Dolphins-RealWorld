package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class RegistrationDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)