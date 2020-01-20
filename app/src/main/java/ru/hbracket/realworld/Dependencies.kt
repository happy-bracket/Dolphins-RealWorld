package ru.hbracket.realworld

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.hbracket.realworld.services.network.ConduitApi

object Dependencies {

    val Api: ConduitApi =
        Retrofit.Builder()
            .baseUrl("https://conduit.productionready.io/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .build())
            .build()
            .create(ConduitApi::class.java)

}