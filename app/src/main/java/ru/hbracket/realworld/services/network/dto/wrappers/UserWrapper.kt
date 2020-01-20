package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class UserWrapper<W>(
    @SerializedName("user")
    val user: W
)