package com.ustapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ustapp.R
import com.ustapp.ui.app.CVApplication
import com.ustapp.ui.main.di.MainModule
import com.ustapp.ui.main.presenter.MainPresenter
import com.ustapp.views.CVAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

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

        retry_button.setOnClickListener {
            presenter.retry()
            it.isEnabled = false
        }

        presenter.attachView(this)
        presenter.loadUserData()
    }

    override fun onProfileLoadedSuccess(list: List<Pair<String, String>>) {
        retry_container.visibility = View.GONE

        adapter.setItems(list)
        adapter.notifyDataSetChanged()

        recycler_view.adapter = adapter
    }

    override fun onProfileLoadedFailure(throwable: Throwable) {
        retry_button.isEnabled = true
        retry_container.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }
}
