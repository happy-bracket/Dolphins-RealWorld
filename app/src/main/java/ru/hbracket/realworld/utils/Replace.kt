package ru.hbracket.realworld.utils

fun <E> List<E>.replaceAt(index: Int, value: E): List<E> {
    val tl = toMutableList()
    tl.removeAt(index)
    tl.add(index, value)
    return tl
}