package com.tom.enhanceit.core

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class AppSchedulers {
    fun mainThread(): Scheduler = AndroidSchedulers.mainThread()
    fun io() = Schedulers.io()
    fun single() = Schedulers.single()
}