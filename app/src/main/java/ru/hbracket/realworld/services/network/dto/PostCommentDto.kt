package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class PostCommentDto(
    @SerializedName("body")
    val body: String
)