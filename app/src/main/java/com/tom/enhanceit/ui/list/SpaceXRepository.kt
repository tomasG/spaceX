package com.tom.enhanceit.ui.list

import com.tom.enhanceit.api.SpaceXAPI
import com.tom.enhanceit.model.Launch
import io.reactivex.Single

open class SpaceXRepository(private val api: SpaceXAPI) {

    fun getLaunches(): Single<List<Launch>> = api.getLaunches()
}