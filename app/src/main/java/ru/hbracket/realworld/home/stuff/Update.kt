package ru.hbracket.realworld.home.stuff

import ru.hbracket.realworld.common.Paging
import ru.hbracket.realworld.common.editContent
import ru.hbracket.realworld.common.write
import ru.hbracket.realworld.utils.replaceAt

infix fun HomeState.update(mutation: HomeMutation): Pair<HomeState, Set<HomeEffect>> {
    return when (mutation) {
        is HomeMutation.Articles -> {
            copy(
                articles = articles.write(mutation.articles)
            ) to emptySet()
        }
        is HomeMutation.LikeClicked -> {
            if (mutation.authorized) {
                val likedArticleIndex = articles.items
                    .indexOfFirst { article -> article.slug == mutation.articleSlug }
                    .takeUnless { it == -1 }
                check(likedArticleIndex != null) { "No article found with slug ${mutation.articleSlug}" }
                val likedArticle = articles.items[likedArticleIndex]
                val edited = articles.editContent { items ->
                    items.replaceAt(
                        likedArticleIndex,
                        likedArticle.copy(
                            thumbUp = true,
                            thumbsCount = likedArticle.thumbsCount + 1
                        )
                    )
                }
                copy(articles = edited) to setOf(HomeEffect.LikeArticle(mutation.articleSlug))
            } else {
                copy(authPromptVisible = true) to emptySet()
            }
        }
        is HomeMutation.ArticleClicked -> {
            this to setOf(HomeEffect.OpenArticle(mutation.articleSlug))
        }
        is HomeMutation.Tags ->
            copy(tags = mutation.tags) to emptySet()
        is HomeMutation.LoadArticles ->
            copy(articles = Paging.Loading(articles.items)) to setOf(
                HomeEffect.LoadArticles(
                    articles.items.size,
                    selectedTag
                )
            )
        is HomeMutation.TagClicked -> {
            if (selectedTag != mutation.tag) {
                copy(
                    selectedTag = mutation.tag,
                    articles = Paging.Loading(emptyList())
                ) to setOf(HomeEffect.LoadArticles(0, mutation.tag))
            } else {
                this to emptySet()
            }
        }
    }
}