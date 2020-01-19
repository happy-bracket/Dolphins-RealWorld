package ru.hbracket.realworld.models

import java.net.URL

data class Profile(
    val username: String,
    val bio: String,
    val avatar: URL,
    val following: Boolean
)