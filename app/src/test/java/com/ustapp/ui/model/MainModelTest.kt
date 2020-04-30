package com.ustapp.ui.model

import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.ustapp.network.CVDataAPI
import com.ustapp.network.dto.UserDataResponse
import com.ustapp.ui.main.model.DefaultMainModel
import com.ustapp.ui.main.model.MainModel
import com.ustapp.utils.service.StringService
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class MainModelTest : Spek ({

    val api: CVDataAPI by memoized { mock<CVDataAPI>() }
    val stringService: StringService by memoized { mock<StringService>() }

    val model: MainModel by memoized { DefaultMainModel(api, stringService) }

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

        it("should return photoUrl as first element") {
            assertEquals(observer.values()[0][0].second, response.photoUrl)
        }
    }
})

private fun apiResponse(): UserDataResponse {
    val languages = LinkedHashMap<String, String>()
    languages["Polish"] = "native"
    languages["English"] = "very good"

    return UserDataResponse(
        "url_path",
        LinkedHashMap(),
        LinkedHashMap(),
        LinkedHashMap(),
        languages,
        ArrayList()
    )
}