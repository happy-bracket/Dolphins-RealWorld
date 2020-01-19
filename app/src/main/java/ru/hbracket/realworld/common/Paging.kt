package ru.hbracket.realworld.common

sealed class Paging<T, out E> {

    abstract val items: List<T>

    data class Idle<T>(override val items: List<T>) : Paging<T, Nothing>()
    data class Loading<T>(override val items: List<T>) : Paging<T, Nothing>()
    data class Error<T, E>(override val items: List<T>, val error: E) : Paging<T, E>()
    data class Eof<T>(override val items: List<T>) : Paging<T, Nothing>()

}

fun <T, E> Paging<T, E>.editContent(edit: (List<T>) -> List<T>): Paging<T, E> =
    when (this) {
        is Paging.Idle -> copy(items = edit(items))
        is Paging.Loading -> copy(items = edit(items))
        is Paging.Error -> copy(items = edit(items))
        is Paging.Eof -> copy(items = edit(items))
    }

fun <T, E> Paging<T, E>.write(newItems: List<T>): Paging<T, E> {
    return when (this) {
        is Paging.Loading ->
            Paging.Idle(items + newItems)
        else ->
            inconsistentState("Paging was not ready to accept items.")
    }
}