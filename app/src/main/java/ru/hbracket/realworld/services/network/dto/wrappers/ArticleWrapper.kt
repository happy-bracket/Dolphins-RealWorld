package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class ArticleWrapper<W>(
    @SerializedName("article")
    val article: W
)