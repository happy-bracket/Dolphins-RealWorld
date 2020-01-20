package ru.hbracket.realworld.mappers

import ru.hbracket.realworld.models.Article
import ru.hbracket.realworld.services.network.dto.ArticleDto

fun convertArticle(dto: ArticleDto): Article =
    with(dto) {
        Article(
            slug,
            title,
            description,
            body,
            tags,
            liked,
            likesCount,
            author.toDomain(),
            createdAt
        )
    }