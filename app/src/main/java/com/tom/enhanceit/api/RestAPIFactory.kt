package com.tom.enhanceit.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPIFactory {

    companion object {
        private var BASE_URL: String = "https://api.spacexdata.com"
        private var retrofit: Retrofit? = null

        fun generateRetrofitClient(context: Context): SpaceXAPI? {
            if (retrofit == null) {
                val cacheSize = (5 * 1024 * 1024).toLong()
                val cache = Cache(context.cacheDir, cacheSize)

                val httpClient = OkHttpClient.Builder()
                retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            }
            return retrofit?.create(SpaceXAPI::class.java)
        }
    }
}