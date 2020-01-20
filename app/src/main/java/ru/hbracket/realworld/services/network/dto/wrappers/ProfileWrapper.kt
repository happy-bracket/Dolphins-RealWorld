package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class ProfileWrapper<W>(
    @SerializedName("profile")
    val profile: W
)