package com.ustapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ustapp.R
import com.ustapp.network.dto.BaseUserData
import com.ustapp.network.dto.UserPersonalData
import com.ustapp.views.CVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.Arrays.asList
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = CVAdapter(this)
        adapter.setItems(prepareList())
        adapter.notifyDataSetChanged()

        recycler_view.adapter = adapter
    }

    override fun onProfileLoadedSuccess(userPersonalData: UserPersonalData) {

    }

    override fun onProfileLoadedFailure(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    private fun prepareList(): List<Pair<String, String>> {
        val educationMap = TreeMap<String, String>()

        educationMap.put(
            "2007-2013", "Politechnika Krakowska im. Tadeusza Kościuszki, kierunek Informatyka, stopień I"
        )
        educationMap.put(
            "2014-2017", "Politechnika Krakowska im. Tadeusza Kościuszki, kierunek Informatyka, stopień II"
        )

        val workingExperienceMap = HashMap<String, String>()
        workingExperienceMap.put(
            "2013-2017", "Android Developer w Miquido"
        )
        workingExperienceMap.put(
            "2017-2019", "Android Developer w EPAM Systems"
        )

        val finalList = ArrayList<Pair<String, String>>()

        val eduationIterator = educationMap.iterator()
        finalList.add(Pair("Header", "Education"))
        while (eduationIterator.hasNext()) {
            val newElement = eduationIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        val experienceIterator = educationMap.iterator()
        finalList.add(Pair("Header", "Experience"))
        while (experienceIterator.hasNext()) {
            val newElement = experienceIterator.next()
            finalList.add(Pair(newElement.key, newElement.value))
        }

        return finalList
    }
}
