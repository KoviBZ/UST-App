package com.ustapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ustapp.R
import com.ustapp.network.dto.HeaderData
import com.ustapp.ui.app.CVApplication
import com.ustapp.ui.main.di.MainModule
import com.ustapp.ui.main.presenter.MainPresenter
import com.ustapp.utils.Constants
import com.ustapp.views.CVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    lateinit var adapter: CVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = CVApplication.getApplicationComponent()
        val mainComponent = appComponent.plusMainComponent(MainModule())
        mainComponent.inject(this)

        recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = CVAdapter(this)

        presenter.attachView(this)
        presenter.loadUserData()
    }

    override fun onProfileLoadedSuccess(list: List<Pair<String, String>>) {
        adapter.setItems(list)
        adapter.notifyDataSetChanged()

        recycler_view.adapter = adapter
    }

    override fun onProfileLoadedFailure(throwable: Throwable) {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hideProgress() {
        TODO("Not yet implemented")
    }
}
