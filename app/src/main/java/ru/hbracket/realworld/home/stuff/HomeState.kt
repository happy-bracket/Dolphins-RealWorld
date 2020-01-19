package ru.hbracket.realworld.home.stuff

import ru.hbracket.realworld.common.Paging
import ru.hbracket.realworld.models.Article

data class HomeState(
    val articles: Paging<Article, Exception> = Paging.Idle(emptyList()),
    val tags: List<String> = emptyList(),
    val selectedTag: String? = null,
    val authPromptVisible: Boolean = false
)

sealed class HomeEvent<M> {

    data class LikeClicked(val articleSlug: String) : HomeEvent<Nothing>()
    data class MutationWrapper<M>(val mutation: M) : HomeEvent<M>()

}

sealed class HomeMutation {

    data class LikeClicked(val articleSlug: String, val authorized: Boolean) : HomeMutation()
    data class ArticleClicked(val articleSlug: String) : HomeMutation()
    data class TagClicked(val tag: String) : HomeMutation()
    object LoadArticles : HomeMutation()
    data class Articles(val articles: List<Article>) : HomeMutation()
    data class Tags(val tags: List<String>) : HomeMutation()

}

sealed class HomeEffect {

    data class LoadArticles(val offset: Int = 0, val tag: String? = null) : HomeEffect()
    data class LikeArticle(val articleSlug: String) : HomeEffect()
    object LoadTags : HomeEffect()
    data class OpenArticle(val articleSlug: String) : HomeEffect()

}