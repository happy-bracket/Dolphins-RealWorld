package ru.hbracket.realworld.models

data class Article(
    val slug: String,
    val title: String,
    val description: String,
    val body: String,
    val tagList: List<String>,
    val thumbUp: Boolean,
    val thumbsCount: Int,
    val author: Profile,
    val createdAt: String
)