package com.ustapp.network

import com.ustapp.network.dto.UserDataResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CVDataAPI {

    @GET("getUserData")
    fun getUserData(): Single<UserDataResponse>
}