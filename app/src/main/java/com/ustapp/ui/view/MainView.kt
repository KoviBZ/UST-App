package com.ustapp.ui.view

import com.ustapp.network.dto.UserPersonalData

interface MainView {

    fun onProfileLoadedSuccess(userPersonalData: UserPersonalData)

    fun onProfileLoadedFailure(throwable: Throwable)
}