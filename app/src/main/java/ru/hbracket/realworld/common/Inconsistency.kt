package ru.hbracket.realworld.common

fun inconsistentState(message: String): Nothing = throw IllegalStateException(message)