package ru.hbracket.realworld.home.stuff

import android.content.Context
import dolphins.rx.feature.RxHandler
import io.reactivex.Observable
import ru.hbracket.realworld.App

class HomeCofx : RxHandler<HomeEvent, HomeMutation>() {

    override fun handle(e: HomeEvent): Observable<HomeMutation> {
        return when (e) {
            is HomeEvent.LikeClicked ->
                Observable.create<HomeMutation> { em ->
                    val auth = App.context.getSharedPreferences("stub", Context.MODE_PRIVATE)
                        .getBoolean("authorized", false)
                    em.onNext(HomeMutation.LikeClicked(e.articleSlug, auth))
                }
            else ->
                Observable.just(HomeMutation.EventWrapper(e))
        }
    }
}