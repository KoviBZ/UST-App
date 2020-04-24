package com.ustapp.ui.main.model

import com.ustapp.utils.Constants

class DefaultMainModel: MainModel {

    override fun getUserData(): List<Pair<String, String>> {
        val personalMap = LinkedHashMap<String, String>()

        personalMap.put(
            "Registered address",
            "ul. Niwa 3, 28-100 Busko-Zdrój"
        )
        personalMap.put(
            "Temporary address",
            "ul. Fieldorfa-Nila 9/114, 31-209 Kraków"
        )
        personalMap.put(
            "Phone",
            "784 533 297"
        )
        personalMap.put(
            "E-mail",
            "mateusz.k.kowalski@wp.pl"
        )
        personalMap.put(
            "LinkedIn",
            "https://www.linkedin.com/in/mateusz-kowalski-a06aba64/"
        )

        val educationMap = LinkedHashMap<String, String>()

        educationMap.put(
            "2007-2013",
            "Politechnika Krakowska im. Tadeusza Kościuszki, kierunek Informatyka, stopień I"
        )
        educationMap.put(
            "2014-2017",
            "Politechnika Krakowska im. Tadeusza Kościuszki, kierunek Informatyka, stopień II"
        )

        val workingExperienceMap = LinkedHashMap<String, String>()
        workingExperienceMap.put(
            "2013-2017", "Android Developer w Miquido"
        )
        workingExperienceMap.put(
            "2017-2019", "Android Developer w EPAM Systems"
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
            "Polish", "Native"
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
        finalList.add(
            Pair(
                Constants.NAME_HEADER,
                "Mateusz Kowalski"
            )
        )

        val personalIterator = personalMap.iterator()
        while (personalIterator.hasNext()) {
            val newElement = personalIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        val eduationIterator = educationMap.iterator()
        finalList.add(Pair(Constants.SECTION_HEADER, "Education"))
        while (eduationIterator.hasNext()) {
            val newElement = eduationIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        val experienceIterator = workingExperienceMap.iterator()
        finalList.add(Pair(Constants.SECTION_HEADER, "Experience"))
        while (experienceIterator.hasNext()) {
            val newElement = experienceIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

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
}