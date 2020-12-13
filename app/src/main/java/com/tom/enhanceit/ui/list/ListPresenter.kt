package com.tom.enhanceit.ui.list

import com.tom.enhanceit.model.Launch
import io.reactivex.Single

open class ListPresenter(private val repository: SpaceXRepository) {

    open fun getLaunches(): Single<List<Launch>> {
        return repository.getLaunches()
    }
}