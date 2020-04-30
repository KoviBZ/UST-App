package com.ustapp.ui.main.model

import com.ustapp.R
import com.ustapp.network.CVDataAPI
import com.ustapp.utils.Constants
import com.ustapp.utils.service.StringService
import io.reactivex.Single

class DefaultMainModel(
    private val cvDataAPI: CVDataAPI,
    private val stringService: StringService
) : MainModel {

    override fun getUserData(): Single<List<Pair<String, String>>> {
        return cvDataAPI.getUserData()
            .map { response ->
                val newList = ArrayList<Pair<String, String>>()

                response.let {
                    newList.add(Pair(Constants.PHOTO_HEADER, it.photoUrl ?: ""))
                    newList.addAll(it.personalData.map { item -> item.toPair() })

                    if(it.educationData.isNotEmpty()) {
                        newList.add(Pair(Constants.SECTION_HEADER, stringService.getString(R.string.education)))
                        newList.addAll(it.educationData.map { item -> item.toPair() })
                    }

                    if(it.experienceData.isNotEmpty()) {
                        newList.add(Pair(Constants.SECTION_HEADER, stringService.getString(R.string.experience)))
                        newList.addAll(it.experienceData.map { item -> item.toPair() })
                    }

                    if(it.languageData.isNotEmpty()) {
                        newList.add(Pair(Constants.SECTION_HEADER, stringService.getString(R.string.languages)))
                        newList.addAll(it.languageData.map { item -> item.toPair() })
                    }

                    if(it.skillData.isNotEmpty()) {
                        newList.add(Pair(Constants.SECTION_HEADER, stringService.getString(R.string.skills)))
                        response.skillData.forEach { item ->
                            newList.add(Pair(Constants.SKILL_ROW, item))
                        }
                    }
                }

                newList
            }
    }
}