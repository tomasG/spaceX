package com.tom.moviesapp.core

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.disposeBy(composite: CompositeDisposable) {
    composite.add(this)
}