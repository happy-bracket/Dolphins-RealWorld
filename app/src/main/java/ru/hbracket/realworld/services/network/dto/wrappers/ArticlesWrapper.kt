package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class ArticlesWrapper<W : List<*>>(
    @SerializedName("articles")
    val articles: W
)