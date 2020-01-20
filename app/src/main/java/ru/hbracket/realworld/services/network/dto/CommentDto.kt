package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class CommentDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("author")
    val author: ProfileDto
)