package ru.hbracket.realworld.home.stuff

import dolphins.core.Core

val HomeCore = Core(HomeState(), setOf(HomeMutation.LoadArticles, HomeEffect.LoadTags), HomeState::update)