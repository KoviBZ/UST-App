package com.ustapp.ui.main.di

import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.ui.main.model.DefaultMainModel
import com.ustapp.ui.main.model.MainModel
import com.ustapp.ui.main.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module
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
    fun providesMainModel(): MainModel = DefaultMainModel()
}