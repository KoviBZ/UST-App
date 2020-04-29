package com.ustapp.ui.main.presenter

import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.ui.common.presenter.BasePresenter
import com.ustapp.ui.main.model.MainModel
import com.ustapp.ui.main.view.MainView

class MainPresenter(
    schedulerProvider: BaseSchedulerProvider,
    private val mainModel: MainModel
) : BasePresenter<MainView>(schedulerProvider) {

    fun loadUserData() {
        val disposable = mainModel.getUserData()
            .applyDefaultIOSchedulers()
            .applyDefaultProgressActions()
            .subscribe(
                { response ->
                    view.onProfileLoadedSuccess(response)
                }, { error ->
                    view.onProfileLoadedFailure(error)
                }
            )

        subscriptions.add(disposable)
    }

    fun retry() {
        loadUserData()
    }
}