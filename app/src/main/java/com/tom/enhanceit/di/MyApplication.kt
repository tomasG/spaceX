package com.tom.enhanceit.di

import android.app.Application
import com.tom.enhanceit.di.modules.spaceXModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(arrayListOf(spaceXModule))
        }
    }
}