package com.ustapp.ui.main.view

import com.ustapp.ui.common.view.BaseView

interface MainView: BaseView {

    fun onProfileLoadedSuccess(list: List<Pair<String, String>>)

    fun onProfileLoadedFailure(throwable: Throwable)
}