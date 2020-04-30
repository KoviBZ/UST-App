package com.ustapp.ui.model

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ustapp.network.CVDataAPI
import com.ustapp.network.dto.UserDataResponse
import com.ustapp.ui.main.model.DefaultMainModel
import com.ustapp.ui.main.model.MainModel
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class MainModelTest : Spek ({

    val api: CVDataAPI by memoized { mock<CVDataAPI>() }

    val model: MainModel by memoized { DefaultMainModel(api) }

    describe("retrieve cv response") {

        val observer = TestObserver<List<Pair<String, String>>>()
        val response = apiResponse()

        beforeEachTest {
            given(api.getUserData()).willReturn(Single.just(response))

            model.getUserData().subscribe(observer)
        }

        it("should complete") {
            observer.assertComplete()
        }

        it("should return photoUrl as first item") {
            observer.assertValue(response.photoUrl)
        }
    }
})

private fun apiResponse(): UserDataResponse {
    val languages = LinkedHashMap<String, String>()

    languages["Polish"] = "native"
    languages["English"] = "very good"

    return UserDataResponse(
        "url_path",
        LinkedHashMap<String, String>(),
        LinkedHashMap<String, String>(),
        LinkedHashMap<String, String>(),
        languages,
        ArrayList<String>()
    )
}