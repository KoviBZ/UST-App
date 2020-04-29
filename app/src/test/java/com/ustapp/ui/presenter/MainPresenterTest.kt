package com.ustapp.ui.presenter

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.ustapp.network.utils.BaseSchedulerProvider
import com.ustapp.network.utils.TestSchedulerProvider
import com.ustapp.ui.main.model.MainModel
import com.ustapp.ui.main.presenter.MainPresenter
import com.ustapp.ui.main.view.MainView
import io.reactivex.Single
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class MainPresenterTest : Spek({

    val view: MainView by memoized { mock<MainView>() }

    val schedulers: BaseSchedulerProvider by memoized { TestSchedulerProvider() }
    val model: MainModel by memoized { mock<MainModel>() }

    val presenter by memoized { MainPresenter(schedulers, model) }

    beforeEachTest {
        presenter.attachView(view)
    }

    describe("attach view") {

        context("model returns EMPTY data") {
            val response: List<Pair<String, String>> = emptyList()

            beforeEachTest {
                given(model.getUserData()).willReturn(Single.just(response))

                presenter.loadUserData()
            }

            it("should call onProfileLoadedSuccess") {
                verify(view).onProfileLoadedSuccess(response)
            }

            it("should show progress") {
                verify(view).showProgress()
            }

            it("should hide progress") {
                verify(view).hideProgress()
            }
        }

        context("model returns NON-EMPTY data") {
            val response = prepareResponse()

            beforeEachTest {
                given(model.getUserData()).willReturn(Single.just(response))

                presenter.loadUserData()
            }

            it("should call onProfileLoadedSuccess") {
                verify(view).onProfileLoadedSuccess(response)
            }

            it("should show progress") {
                verify(view).showProgress()
            }

            it("should hide progress") {
                verify(view).hideProgress()
            }
        }

        context("model returns error") {
            val response = Throwable()

            beforeEachTest {
                given(model.getUserData()).willReturn(Single.error(response))

                presenter.loadUserData()
            }

            it("should call onProfileLoadedSuccess") {
                verify(view).onProfileLoadedFailure(response)
            }

            it("should show progress") {
                verify(view).showProgress()
            }

            it("should hide progress") {
                verify(view).hideProgress()
            }
        }
    }

})

private fun prepareResponse(): List<Pair<String, String>> {
    val list = ArrayList<Pair<String, String>>()

    list.add(Pair("first1", "second1"))
    list.add(Pair("first2", "second2"))
    list.add(Pair("first3", "second3"))

    return list
}