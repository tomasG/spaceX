package com.tom.enhanceit.api

import com.tom.enhanceit.model.Launch
import io.reactivex.Single
import retrofit2.http.GET

interface SpaceXAPI {

    @GET("v4/launches")
    fun getLaunches(): Single<List<Launch>>
}