package ru.hbracket.realworld.services.network.dto

import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("slug")
    val slug: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("tagList")
    val tags: List<String>,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("favorited")
    val liked: Boolean,
    @SerializedName("favoritesCount")
    val likesCount: Int,
    @SerializedName("author")
    val author: ProfileDto
)