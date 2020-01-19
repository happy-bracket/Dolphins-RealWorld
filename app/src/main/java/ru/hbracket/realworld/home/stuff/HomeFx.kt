package ru.hbracket.realworld.home.stuff

import dolphins.rx.feature.RxHandler
import io.reactivex.Observable

class HomeFx : RxHandler<HomeEffect, HomeEvent<HomeMutation>>() {

    override fun handle(e: HomeEffect): Observable<HomeEvent<HomeMutation>> {
        TODO()
    }

}