package com.ustapp.ui.app

import android.app.Application
import com.ustapp.ui.app.di.ApplicationComponent
import com.ustapp.ui.app.di.ApplicationModule
import com.ustapp.ui.app.di.DaggerApplicationComponent

class CVApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = buildComponent()
    }

    private fun buildComponent(): ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()

    companion object {

        private lateinit var applicationComponent: ApplicationComponent

        @JvmStatic
        fun getApplicationComponent() = applicationComponent
    }
}