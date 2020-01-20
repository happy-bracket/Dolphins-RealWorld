package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class UpdateArticleDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("body")
    val body: String? = null
)