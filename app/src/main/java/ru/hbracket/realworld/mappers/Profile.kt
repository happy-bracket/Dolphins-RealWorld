package ru.hbracket.realworld.mappers

import ru.hbracket.realworld.models.Profile
import ru.hbracket.realworld.services.network.dto.ProfileDto
import ru.hbracket.realworld.utils.*
import java.net.URL

fun ProfileDto.toDomain(): Profile =
    Profile(
        username,
        bio,
        Either.ofNullable(image)
            .flatMap { Either.recover { URL(it) }.lmap { Unit } }
            .fold(
                { URL("https://ra.ac.ae/wp-content/uploads/2017/02/user-icon-placeholder.png") },
                ::self
            ),
        following
    )