package com.ustapp.ui.app.di

import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.network.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideSchedulerProvider(): BaseSchedulerProvider {
        return SchedulerProvider()
    }
}