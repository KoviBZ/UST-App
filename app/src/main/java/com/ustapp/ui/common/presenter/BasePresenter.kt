package com.ustapp.ui.common.presenter

import androidx.annotation.VisibleForTesting
import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.ui.common.view.BaseView
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : BaseView>(
    private val schedulerProvider: BaseSchedulerProvider
) {

    protected lateinit var view: T

    @VisibleForTesting
    lateinit var subscriptions: CompositeDisposable

    fun attachView(view: T) {
        this.view = view
        subscriptions = CompositeDisposable()
    }

    fun disposeSubscriptions() {
        subscriptions.dispose()
    }

    fun <RESPONSE> Single<RESPONSE>.applyDefaultIOSchedulers(): Single<RESPONSE> {
        return this
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
    }

    fun <RESPONSE> Single<RESPONSE>.applyDefaultProgressActions(): Single<RESPONSE> {
        return this
            .doOnSubscribe { view.showProgress() }
            .doOnTerminate { view.hideProgress() }
    }
}