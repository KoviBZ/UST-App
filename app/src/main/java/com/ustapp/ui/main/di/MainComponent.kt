package com.ustapp.ui.main.di

import com.ustapp.ui.main.view.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}