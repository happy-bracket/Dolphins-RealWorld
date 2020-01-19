package ru.hbracket.realworld.home

import androidx.fragment.app.Fragment
import dolphins.rx.feature.RxFeature
import ru.hbracket.realworld.home.stuff.HomeCofx
import ru.hbracket.realworld.home.stuff.HomeCore
import ru.hbracket.realworld.home.stuff.HomeFx

class HomeFragment : Fragment() {

    private val feature =
        RxFeature(
            HomeCore,
            HomeCofx(),
            HomeFx()
        )

}