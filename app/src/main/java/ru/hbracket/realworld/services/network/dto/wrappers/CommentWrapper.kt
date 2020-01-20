package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class CommentWrapper<W>(
    @SerializedName("comment")
    val comment: W
)