package com.ustapp.ui.app.di

import com.ustapp.ui.main.di.MainComponent
import com.ustapp.ui.main.di.MainModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun plusMainComponent(mainModule: MainModule): MainComponent
}