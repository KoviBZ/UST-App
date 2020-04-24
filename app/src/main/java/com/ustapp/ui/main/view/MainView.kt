package com.ustapp.ui.main.view

import com.ustapp.network.dto.HeaderData

interface MainView {

    fun onProfileLoadedSuccess(headerData: HeaderData)

    fun onProfileLoadedFailure(throwable: Throwable)
}