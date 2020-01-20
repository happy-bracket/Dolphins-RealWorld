package ru.hbracket.realworld.services.network.dto.wrappers

import com.google.gson.annotations.SerializedName

data class TagsWrapper<W : List<*>>(
    @SerializedName("tags")
    val tags: List<String>
)