package ru.hbracket.realworld

import android.app.Application
import android.content.Context
import com.facebook.soloader.SoLoader

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        SoLoader.init(this, false)

        instance = this
    }

    companion object {

        private lateinit var instance: App

        val context: Context
            get() = instance.applicationContext

    }

}