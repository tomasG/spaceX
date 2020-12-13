package com.tom.enhanceit.app

import com.tom.enhanceit.model.Launch
import com.tom.enhanceit.ui.list.PresenterSpaceX
import io.reactivex.Single
import java.util.*

class PresenterMock : PresenterSpaceX {

    override fun getLaunches(): Single<List<Launch>> {
        val launch = Launch("SpaceX", Date(), null, true)
        return Single.just(listOf(launch))
    }
}