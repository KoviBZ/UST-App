package com.ustapp.ui.view

import com.ustapp.network.dto.UserData

interface MainView {

    fun onProfileLoadedSuccess(userData: UserData)

    fun onProfileLoadedFailure(throwable: Throwable)
}