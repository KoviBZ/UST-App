package com.ustapp.ui.app.di

import android.content.Context
import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.network.utils.SchedulerProvider
import com.ustapp.utils.service.DefaultStringService
import com.ustapp.utils.service.StringService
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val context: Context) {

    @Provides
    fun providesContext(): Context {
        return context
    }

    @Provides
    fun provideSchedulerProvider(): BaseSchedulerProvider = SchedulerProvider()

    @Provides
    fun provideStringService(context: Context): StringService =
        DefaultStringService(context)
}