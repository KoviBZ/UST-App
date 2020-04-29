package com.ustapp.ui.main.model

import io.reactivex.Single

interface MainModel {

    fun getUserData(): Single<List<Pair<String, String>>>
}