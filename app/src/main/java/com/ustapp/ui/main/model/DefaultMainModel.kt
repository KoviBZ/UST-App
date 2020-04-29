package com.ustapp.ui.main.model

import com.ustapp.network.CVDataAPI
import com.ustapp.utils.Constants
import io.reactivex.Single

class DefaultMainModel(
    private val cvDataAPI: CVDataAPI
) : MainModel {

    override fun getUserData(): Single<List<Pair<String, String>>> {
        return cvDataAPI.getUserData()
            .map { response ->
                val newList = ArrayList<Pair<String, String>>()

                newList.add(Pair(Constants.PHOTO_HEADER, response.photoUrl ?: ""))
                newList.addAll(parseMapIntoList(response.personalData))
                newList.add(Pair(Constants.SECTION_HEADER, "Education"))
                newList.addAll(parseMapIntoList(response.educationData))
                newList.add(Pair(Constants.SECTION_HEADER, "Experience"))
                newList.addAll(parseMapIntoList(response.experienceData))
                newList.add(Pair(Constants.SECTION_HEADER, "Languages"))
                newList.addAll(parseMapIntoList(response.languageData))
                newList.add(Pair(Constants.SECTION_HEADER, "Skills"))
                response.skillData.forEach { item ->
                    newList.add(Pair(Constants.SKILL_ROW, item))
                }

                newList
            }
    }

    private fun parseMapIntoList(map: LinkedHashMap<String, String>): List<Pair<String, String>> {
        val newList = ArrayList<Pair<String, String>>()

        map.forEach { item ->
            newList.add(Pair(item.key, item.value))
        }

        return newList
    }
}