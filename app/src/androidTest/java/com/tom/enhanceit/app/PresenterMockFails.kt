package com.tom.enhanceit.app

import com.tom.enhanceit.model.Launch
import com.tom.enhanceit.ui.list.PresenterSpaceX
import io.reactivex.Single
import java.lang.RuntimeException
import java.util.*

class PresenterMockFails : PresenterSpaceX {

    override fun getLaunches(): Single<List<Launch>> {
        return Single.error(RuntimeException())
    }
}