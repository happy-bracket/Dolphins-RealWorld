package ru.hbracket.realworld.home.stuff

import dolphins.rx.feature.RxHandler
import io.reactivex.Observable
import ru.hbracket.realworld.Dependencies
import ru.hbracket.realworld.mappers.convertArticle

class HomeFx : RxHandler<HomeEffect, HomeEvent<HomeMutation>>() {

    private val api = Dependencies.Api

    override fun handle(e: HomeEffect): Observable<HomeEvent<HomeMutation>> {
        return when (e) {
            is HomeEffect.LoadTags ->
                api.getTags()
                    .map { HomeEvent.MutationWrapper(HomeMutation.Tags(it.tags)) as HomeEvent<HomeMutation> }
                    .toObservable()
            is HomeEffect.LoadArticles ->
                api.articlesList(
                    tag = e.tag,
                    offset = e.offset
                ).map {
                    HomeEvent.MutationWrapper(HomeMutation.Articles(it.articles.map(::convertArticle))) as HomeEvent<HomeMutation>
                }.toObservable()
            is  HomeEffect.OpenArticle ->
                Observable.empty()
            is HomeEffect.LikeArticle ->
                Observable.empty()
        }
    }

}