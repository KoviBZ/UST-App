package com.ustapp.ui.main.di

import com.ustapp.network.CVDataAPI
import com.ustapp.network.di.NetworkModule
import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.ui.main.model.DefaultMainModel
import com.ustapp.ui.main.model.MainModel
import com.ustapp.ui.main.presenter.MainPresenter
import com.ustapp.utils.StringService
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class MainModule {

    @Provides
    fun providesMainPresenter(
        schedulerProvider: BaseSchedulerProvider,
        mainModel: MainModel
    ): MainPresenter = MainPresenter(
        schedulerProvider,
        mainModel
    )

    @Provides
    fun providesMainModel(
        cvDataApi: CVDataAPI,
        stringService: StringService
    ): MainModel = DefaultMainModel(
        cvDataApi,
        stringService)
}