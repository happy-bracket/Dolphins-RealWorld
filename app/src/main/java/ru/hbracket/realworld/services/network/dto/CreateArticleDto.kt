package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class CreateArticleDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("tagList")
    val tags: List<String>? = null
)