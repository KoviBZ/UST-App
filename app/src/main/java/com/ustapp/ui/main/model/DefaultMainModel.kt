package com.ustapp.ui.main.model

import com.ustapp.network.CVDataAPI
import com.ustapp.utils.Constants
import io.reactivex.Single

class DefaultMainModel(
    private val cvDataAPI: CVDataAPI
) : MainModel {

    fun getMock(): List<Pair<String, String>> {
        val workingExperienceMap = LinkedHashMap<String, String>()
        workingExperienceMap.put(
            "01.12.2013 - 31.07.2017", "Android Developer w Miquido"
        )
        workingExperienceMap.put(
            "16.08.2017 - 31.12.2019", "Android Developer w EPAM Systems"
        )

        val languageMap = LinkedHashMap<String, String>()
        languageMap.put(
            "Polish", "Native"
        )
        languageMap.put(
            "English", "Very good"
        )
        languageMap.put(
            "German", "Basic/average"
        )

        val skillMap = LinkedHashMap<String, String>()
        skillMap.put(
            "Basic", "Java"
        )
        skillMap.put(
            "English", "Very good"
        )
        skillMap.put(
            "German", "Basic/average"
        )

        val finalList = ArrayList<Pair<String, String>>()

        finalList.add(
            Pair(
                Constants.PHOTO_HEADER,
                "https://cdn.shopify.com/s/files/1/0223/4339/products/image_1108973_0b8b155d-fd0e-49d1-9f96-b71ec3edfff6_grande.jpg?v=1578614450"
            )
        )

        val languageIterator = languageMap.iterator()
        finalList.add(Pair(Constants.SECTION_HEADER, "Languages"))
        while (languageIterator.hasNext()) {
            val newElement = languageIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        val skillIterator = skillMap.iterator()
        finalList.add(Pair(Constants.SECTION_HEADER, "Skills"))
        while (skillIterator.hasNext()) {
            val newElement = skillIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        return finalList
    }

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