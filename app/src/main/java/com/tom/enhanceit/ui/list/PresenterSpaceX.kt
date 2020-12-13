package com.tom.enhanceit.ui.list

import com.tom.enhanceit.model.Launch
import io.reactivex.Single

interface PresenterSpaceX {
    fun getLaunches(): Single<List<Launch>>
}