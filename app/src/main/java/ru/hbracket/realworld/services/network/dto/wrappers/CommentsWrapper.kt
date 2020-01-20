package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class CommentsWrapper<W : List<*>>(
    @SerializedName("comments")
    val comments: W
)