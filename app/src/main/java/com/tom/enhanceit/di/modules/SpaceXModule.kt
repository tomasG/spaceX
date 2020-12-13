package com.tom.enhanceit.di.modules

import com.tom.enhanceit.api.RestAPIFactory
import com.tom.enhanceit.core.AppSchedulers
import com.tom.enhanceit.ui.list.ListPresenter
import com.tom.enhanceit.ui.list.SpaceXRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


/**
 * Dependency injection
 */
val spaceXModule: Module = module {
    single { RestAPIFactory.generateRetrofitClient(androidContext()) }
    single { ListPresenter(get()) }
    single { SpaceXRepository(get()) }
    single { AppSchedulers() }
}